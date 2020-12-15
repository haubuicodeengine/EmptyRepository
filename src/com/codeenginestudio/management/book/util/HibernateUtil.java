package com.codeenginestudio.management.book.util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.codeenginestudio.management.book.model.Author;
import com.codeenginestudio.management.book.model.Book;
import com.codeenginestudio.management.book.model.BookAndBookType;
import com.codeenginestudio.management.book.model.BookType;

public class HibernateUtil {

	private static SessionFactory _sessionFactory;

	public static SessionFactory _getSessionFactory() {

		if (_sessionFactory == null) {

			try {

				Configuration configuration = new Configuration();
				// Hibernate settings equivalent to hibernate.cfg.xml's properties
				Properties settings = new Properties();
				settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
				settings.put(Environment.URL, "jdbc:mysql://localhost:3306/book_management?useSSL=false");
				settings.put(Environment.USER, "root");
				settings.put(Environment.PASS, "123456");
				settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
				settings.put(Environment.SHOW_SQL, "true");
				settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
				settings.put(Environment.HBM2DDL_AUTO, "update");

				configuration.setProperties(settings);
				configuration.addAnnotatedClass(Book.class);
				configuration.addAnnotatedClass(Author.class);
				configuration.addAnnotatedClass(BookType.class);
				configuration.addAnnotatedClass(BookAndBookType.class);

				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
						.applySettings(configuration.getProperties()).build();
				System.out.println("Hibernate Java Config serviceRegistry created");
				_sessionFactory = configuration.buildSessionFactory(serviceRegistry);

				return _sessionFactory;

			} catch (Exception e) {

				e.printStackTrace();
			}
		}

		return _sessionFactory;
	}
}
