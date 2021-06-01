package com.liferay.training.news.letter.validator;

import com.liferay.training.news.letter.exception.NewsLetterValidationException.DescriptionMustNotBeNull;
import com.liferay.training.news.letter.exception.NewsLetterValidationException.IssueNumberMustBeANumber;
import com.liferay.training.news.letter.exception.NewsLetterValidationException.IssueNumberMustNotBeDuplicate;
import com.liferay.training.news.letter.exception.NewsLetterValidationException.IssueNumberMustNotBeNull;
import com.liferay.training.news.letter.exception.NewsLetterValidationException.TitleMustNotBeNull;
import com.liferay.training.news.letter.model.NewsLetter;

import java.util.List;

public interface NewsLetterValidation {

	public void validate(long newsletterId, int issueNumber, String title, String description,
			List<NewsLetter> newsletters) throws IssueNumberMustNotBeNull, TitleMustNotBeNull, DescriptionMustNotBeNull,
			IssueNumberMustBeANumber, IssueNumberMustNotBeDuplicate;
}
