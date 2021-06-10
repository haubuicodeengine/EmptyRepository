package com.liferay.training.newsletter.listing.util;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.Order;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.training.newsletter.model.Newsletter;
import com.liferay.training.newsletter.model.NewsletterArticle;
import com.liferay.training.newsletter.service.NewsletterArticleLocalService;
import com.liferay.training.newsletter.service.NewsletterLocalService;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(service = NewsLetterListingUtil.class, immediate = true)
public class NewsLetterListingUtil {

	public List<Newsletter> getNewsletters() {

		Order order = OrderFactoryUtil.desc("issueDate");

		DynamicQuery newsletterQuery = newsletterLocalService.dynamicQuery()
				.add(RestrictionsFactoryUtil.eq("status", 0)).addOrder(order);

		return newsletterLocalService.dynamicQuery(newsletterQuery);
	}

	public List<NewsletterArticle> getNewsletterArticles() {

		DynamicQuery newsletterArticleQuery = newsletterArticleLocalService.dynamicQuery()
				.add(RestrictionsFactoryUtil.eq("status", 0));

		return newsletterArticleLocalService.dynamicQuery(newsletterArticleQuery);
	}

	public Set<String> getYearsFromNewsLetter(List<Newsletter> newsletters) {

		Set<String> dateList = new LinkedHashSet<String>();

		for (Newsletter newsletter : newsletters) {

			String pattern = "yyyy";
			String year = formatDateTimes(pattern).format(newsletter.getIssueDate());

			dateList.add(year);
		}

		return dateList;
	}

	public HashMap<Long, String> getDateTimesFromNewsLetter(List<Newsletter> newsletters) {

		HashMap<Long, String> months = new HashMap<Long, String>();

		for (Newsletter newsletter : newsletters) {

			String patternMonth = "MMMM";
			String patternYear = "yyyy";

			String month = formatDateTimes(patternMonth).format(newsletter.getIssueDate());
			String year = formatDateTimes(patternYear).format(newsletter.getIssueDate());

			String value = month + "_" + year;

			if (!months.containsValue(value)) {
				months.put(newsletter.getNewsletterId(), value);
			}
		}

		return months;
	}

	public Set<String> getMonthsFromNewsLetter(List<Newsletter> newsletters) {

		Set<String> months = new LinkedHashSet<String>();

		for (Newsletter newsletter : newsletters) {

			String patternMonth = "MMMM";

			String month = formatDateTimes(patternMonth).format(newsletter.getIssueDate());

			months.add(month);
		}

		return months;
	}

	public SimpleDateFormat formatDateTimes(String pattern) {

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

		return simpleDateFormat;
	}

	public String[] splitString(String string) {

		String[] array = string.split("_");

		return array;
	}

	@Reference
	NewsletterLocalService newsletterLocalService;

	@Reference
	NewsletterArticleLocalService newsletterArticleLocalService;
}
