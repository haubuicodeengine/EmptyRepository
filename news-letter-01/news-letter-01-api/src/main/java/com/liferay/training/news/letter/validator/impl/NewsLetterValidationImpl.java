package com.liferay.training.news.letter.validator.impl;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.training.news.letter.exception.NewsLetterValidationException;
import com.liferay.training.news.letter.exception.NewsLetterValidationException.DescriptionMustNotBeNull;
import com.liferay.training.news.letter.exception.NewsLetterValidationException.IssueNumberMustBeANumber;
import com.liferay.training.news.letter.exception.NewsLetterValidationException.IssueNumberMustNotBeDuplicate;
import com.liferay.training.news.letter.exception.NewsLetterValidationException.IssueNumberMustNotBeNull;
import com.liferay.training.news.letter.exception.NewsLetterValidationException.TitleMustNotBeNull;
import com.liferay.training.news.letter.model.NewsLetter;
import com.liferay.training.news.letter.validator.NewsLetterValidation;

import java.util.List;

import org.osgi.service.component.annotations.Component;

@Component(
	immediate = true, 
	service = NewsLetterValidation.class)
public class NewsLetterValidationImpl implements NewsLetterValidation {

	@Override
	public void validate(long newsletterId, int issueNumber, String title, String description,
			List<NewsLetter> newsletters) throws IssueNumberMustNotBeNull, TitleMustNotBeNull, DescriptionMustNotBeNull,
			IssueNumberMustBeANumber, IssueNumberMustNotBeDuplicate {

		if (!checkNull(issueNumber)) {
			throw new NewsLetterValidationException.IssueNumberMustNotBeNull();
		}

		if (!checkNull(title)) {
			throw new NewsLetterValidationException.TitleMustNotBeNull();
		}

		if (!checkNull(description)) {
			throw new NewsLetterValidationException.DescriptionMustNotBeNull();
		}

		if (!isNumber(issueNumber)) {
			throw new NewsLetterValidationException.IssueNumberMustBeANumber();
		}

		if (!checkIssueNumberDuplicate(newsletterId, issueNumber, newsletters)) {
			throw new NewsLetterValidationException.IssueNumberMustNotBeDuplicate(issueNumber);
		}

	}

	private boolean checkNull(String string) {
		boolean result = true;

		if (Validator.isBlank(string)) {
			result = false;
		}

		return result;
	}

	private boolean checkNull(int issueNumber) {
		boolean result = true;

		if (issueNumber == 0) {
			result = false;
		}

		return result;
	}

	private boolean checkIssueNumberDuplicate(long newsletterId, int issueNumber, List<NewsLetter> newsletters) {

		boolean result = true;

		for (NewsLetter newsLetter : newsletters) {
			if (newsLetter.getNewsletterId() != newsletterId) {
				if (newsLetter.getIssueNumber() == issueNumber) {
					result = false;
				}
			}
		}

		return result;
	}

	private boolean isNumber(int issueNumber) {

		boolean result = true;

		if (issueNumber != (int) issueNumber) {
			result = false;
		}
		return result;
	}

}
