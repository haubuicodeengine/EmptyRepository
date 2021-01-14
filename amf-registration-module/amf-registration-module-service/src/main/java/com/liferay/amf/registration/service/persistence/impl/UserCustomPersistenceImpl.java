/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.amf.registration.service.persistence.impl;

import com.liferay.amf.registration.exception.NoSuchUserCustomException;
import com.liferay.amf.registration.model.UserCustom;
import com.liferay.amf.registration.model.impl.UserCustomImpl;
import com.liferay.amf.registration.model.impl.UserCustomModelImpl;
import com.liferay.amf.registration.service.persistence.UserCustomPersistence;
import com.liferay.amf.registration.service.persistence.impl.constants.AMF_REGISTRATIONPersistenceConstants;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the user custom service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = UserCustomPersistence.class)
public class UserCustomPersistenceImpl
	extends BasePersistenceImpl<UserCustom> implements UserCustomPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>UserCustomUtil</code> to access the user custom persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		UserCustomImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public UserCustomPersistenceImpl() {
		setModelClass(UserCustom.class);

		setModelImplClass(UserCustomImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the user custom in the entity cache if it is enabled.
	 *
	 * @param userCustom the user custom
	 */
	@Override
	public void cacheResult(UserCustom userCustom) {
		entityCache.putResult(
			entityCacheEnabled, UserCustomImpl.class,
			userCustom.getPrimaryKey(), userCustom);

		userCustom.resetOriginalValues();
	}

	/**
	 * Caches the user customs in the entity cache if it is enabled.
	 *
	 * @param userCustoms the user customs
	 */
	@Override
	public void cacheResult(List<UserCustom> userCustoms) {
		for (UserCustom userCustom : userCustoms) {
			if (entityCache.getResult(
					entityCacheEnabled, UserCustomImpl.class,
					userCustom.getPrimaryKey()) == null) {

				cacheResult(userCustom);
			}
			else {
				userCustom.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all user customs.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(UserCustomImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the user custom.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(UserCustom userCustom) {
		entityCache.removeResult(
			entityCacheEnabled, UserCustomImpl.class,
			userCustom.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<UserCustom> userCustoms) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (UserCustom userCustom : userCustoms) {
			entityCache.removeResult(
				entityCacheEnabled, UserCustomImpl.class,
				userCustom.getPrimaryKey());
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, UserCustomImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new user custom with the primary key. Does not add the user custom to the database.
	 *
	 * @param userCustomId the primary key for the new user custom
	 * @return the new user custom
	 */
	@Override
	public UserCustom create(long userCustomId) {
		UserCustom userCustom = new UserCustomImpl();

		userCustom.setNew(true);
		userCustom.setPrimaryKey(userCustomId);

		userCustom.setCompanyId(CompanyThreadLocal.getCompanyId());

		return userCustom;
	}

	/**
	 * Removes the user custom with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userCustomId the primary key of the user custom
	 * @return the user custom that was removed
	 * @throws NoSuchUserCustomException if a user custom with the primary key could not be found
	 */
	@Override
	public UserCustom remove(long userCustomId)
		throws NoSuchUserCustomException {

		return remove((Serializable)userCustomId);
	}

	/**
	 * Removes the user custom with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the user custom
	 * @return the user custom that was removed
	 * @throws NoSuchUserCustomException if a user custom with the primary key could not be found
	 */
	@Override
	public UserCustom remove(Serializable primaryKey)
		throws NoSuchUserCustomException {

		Session session = null;

		try {
			session = openSession();

			UserCustom userCustom = (UserCustom)session.get(
				UserCustomImpl.class, primaryKey);

			if (userCustom == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchUserCustomException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(userCustom);
		}
		catch (NoSuchUserCustomException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected UserCustom removeImpl(UserCustom userCustom) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(userCustom)) {
				userCustom = (UserCustom)session.get(
					UserCustomImpl.class, userCustom.getPrimaryKeyObj());
			}

			if (userCustom != null) {
				session.delete(userCustom);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (userCustom != null) {
			clearCache(userCustom);
		}

		return userCustom;
	}

	@Override
	public UserCustom updateImpl(UserCustom userCustom) {
		boolean isNew = userCustom.isNew();

		if (!(userCustom instanceof UserCustomModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(userCustom.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(userCustom);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in userCustom proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom UserCustom implementation " +
					userCustom.getClass());
		}

		UserCustomModelImpl userCustomModelImpl =
			(UserCustomModelImpl)userCustom;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (userCustom.getCreateDate() == null)) {
			if (serviceContext == null) {
				userCustom.setCreateDate(now);
			}
			else {
				userCustom.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!userCustomModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				userCustom.setModifiedDate(now);
			}
			else {
				userCustom.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (userCustom.isNew()) {
				session.save(userCustom);

				userCustom.setNew(false);
			}
			else {
				userCustom = (UserCustom)session.merge(userCustom);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}

		entityCache.putResult(
			entityCacheEnabled, UserCustomImpl.class,
			userCustom.getPrimaryKey(), userCustom, false);

		userCustom.resetOriginalValues();

		return userCustom;
	}

	/**
	 * Returns the user custom with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the user custom
	 * @return the user custom
	 * @throws NoSuchUserCustomException if a user custom with the primary key could not be found
	 */
	@Override
	public UserCustom findByPrimaryKey(Serializable primaryKey)
		throws NoSuchUserCustomException {

		UserCustom userCustom = fetchByPrimaryKey(primaryKey);

		if (userCustom == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchUserCustomException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return userCustom;
	}

	/**
	 * Returns the user custom with the primary key or throws a <code>NoSuchUserCustomException</code> if it could not be found.
	 *
	 * @param userCustomId the primary key of the user custom
	 * @return the user custom
	 * @throws NoSuchUserCustomException if a user custom with the primary key could not be found
	 */
	@Override
	public UserCustom findByPrimaryKey(long userCustomId)
		throws NoSuchUserCustomException {

		return findByPrimaryKey((Serializable)userCustomId);
	}

	/**
	 * Returns the user custom with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userCustomId the primary key of the user custom
	 * @return the user custom, or <code>null</code> if a user custom with the primary key could not be found
	 */
	@Override
	public UserCustom fetchByPrimaryKey(long userCustomId) {
		return fetchByPrimaryKey((Serializable)userCustomId);
	}

	/**
	 * Returns all the user customs.
	 *
	 * @return the user customs
	 */
	@Override
	public List<UserCustom> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the user customs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserCustomModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user customs
	 * @param end the upper bound of the range of user customs (not inclusive)
	 * @return the range of user customs
	 */
	@Override
	public List<UserCustom> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the user customs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserCustomModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user customs
	 * @param end the upper bound of the range of user customs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of user customs
	 */
	@Override
	public List<UserCustom> findAll(
		int start, int end, OrderByComparator<UserCustom> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the user customs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserCustomModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user customs
	 * @param end the upper bound of the range of user customs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of user customs
	 */
	@Override
	public List<UserCustom> findAll(
		int start, int end, OrderByComparator<UserCustom> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<UserCustom> list = null;

		if (useFinderCache) {
			list = (List<UserCustom>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_USERCUSTOM);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_USERCUSTOM;

				sql = sql.concat(UserCustomModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<UserCustom>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the user customs from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (UserCustom userCustom : findAll()) {
			remove(userCustom);
		}
	}

	/**
	 * Returns the number of user customs.
	 *
	 * @return the number of user customs
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_USERCUSTOM);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "userCustomId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_USERCUSTOM;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return UserCustomModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the user custom persistence.
	 */
	@Activate
	public void activate() {
		UserCustomModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		UserCustomModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, UserCustomImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, UserCustomImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(UserCustomImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	@Reference(
		target = AMF_REGISTRATIONPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
		super.setConfiguration(configuration);

		_columnBitmaskEnabled = GetterUtil.getBoolean(
			configuration.get(
				"value.object.column.bitmask.enabled.com.liferay.amf.registration.model.UserCustom"),
			true);
	}

	@Override
	@Reference(
		target = AMF_REGISTRATIONPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = AMF_REGISTRATIONPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	private boolean _columnBitmaskEnabled;

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_USERCUSTOM =
		"SELECT userCustom FROM UserCustom userCustom";

	private static final String _SQL_COUNT_USERCUSTOM =
		"SELECT COUNT(userCustom) FROM UserCustom userCustom";

	private static final String _ORDER_BY_ENTITY_ALIAS = "userCustom.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No UserCustom exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		UserCustomPersistenceImpl.class);

	static {
		try {
			Class.forName(AMF_REGISTRATIONPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

}