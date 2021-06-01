package com.liferay.training.news.letter.listiing.util;

import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.service.JournalArticleLocalService;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.Order;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.training.news.letter.model.NewsLetter;
import com.liferay.training.news.letter.model.NewsLetter_Articles;
import com.liferay.training.news.letter.service.NewsLetterLocalService;
import com.liferay.training.news.letter.service.NewsLetter_ArticlesService;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
	service = NewsLetterListingUtil.class, 
	immediate = true)
public class NewsLetterListingUtil {

	public List<JournalArticle> getArticles() {
		return journalArticleLocalService.getArticles();
	}

	public List<NewsLetter> getNewsLetter() {

		Order order = OrderFactoryUtil.desc("issueDate");

		DynamicQuery newsletterQuery = newsLetterLocalService.dynamicQuery().addOrder(order);

		return newsLetterLocalService.dynamicQuery(newsletterQuery);
	}

	public List<NewsLetter_Articles> getNewsLetterArticles() {

		return newsLetter_ArticlesService.getNewsLetter_Articles();
	}

	public List<NewsLetter_Articles> getNewsLetterArticlesByNewsLetterId(long newsletterId) {

		return newsLetter_ArticlesService.getNewsLetter_ArticlesByNewsletterId(newsletterId);
	}

	public Set<String> getYearsFromNewsLetter(List<NewsLetter> newsLetters) {

		Set<String> dateList = new LinkedHashSet<String>();

		for (NewsLetter newsLetter : newsLetters) {

			String pattern = "yyyy";
			String year = formatDateTimes(pattern).format(newsLetter.getIssueDate());

			dateList.add(year);
		}

		return dateList;
	}

	public HashMap<Long, String> getDateTimesFromNewsLetter(List<NewsLetter> newsLetters) {

		HashMap<Long, String> months = new HashMap<Long, String>();

		for (NewsLetter newsLetter : newsLetters) {

			String patternMonth = "MMMM";
			String patternYear = "yyyy";

			String month = formatDateTimes(patternMonth).format(newsLetter.getIssueDate());
			String year = formatDateTimes(patternYear).format(newsLetter.getIssueDate());

			String value = month + "_" + year;

			if (!months.containsValue(value)) {
				months.put(newsLetter.getNewsletterId(), value);
			}

		}

		return months;
	}

	public Set<String> getMonthsFromNewsLetter(List<NewsLetter> newsLetters) {

		Set<String> months = new LinkedHashSet<String>();

		for (NewsLetter newsLetter : newsLetters) {

			String patternMonth = "MMMM";

			String month = formatDateTimes(patternMonth).format(newsLetter.getIssueDate());

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
	JournalArticleLocalService journalArticleLocalService;

	@Reference
	NewsLetterLocalService newsLetterLocalService;

	@Reference
	NewsLetter_ArticlesService newsLetter_ArticlesService;
}
