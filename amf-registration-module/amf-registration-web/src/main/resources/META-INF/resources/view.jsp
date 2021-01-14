<%@ include file="./init.jsp" %>

<div class="container-fluid-1280">
	<liferay-ui:error exception="<%= UserEmailAddressException.MustNotBeNull.class %>" message="error.user-email-cannot-be-null" />
	<liferay-ui:error exception="<%= UserRegistrationValidationException.EmailMustBeShorter.class %>" message="error.email-cannot-be-longer" />
	<liferay-ui:error exception="<%= UserRegistrationValidationException.FirstNameMustBeShorter.class %>" message="error.firstname-cannot-be-longer" />
	<liferay-ui:error exception="<%= UserRegistrationValidationException.FirstNameMustNotBeNull.class %>" message="error.user-firstname-cannot-be-null" />
	<liferay-ui:error exception="<%= UserRegistrationValidationException.LastNameMustBeShorter.class %>" message="error.lastname-cannot-be-longer" />
	<liferay-ui:error exception="<%= UserRegistrationValidationException.LastNameMustNotBeNull.class %>" message="error.user-lastname-cannot-be-null" />
	<liferay-ui:error exception="<%= UserRegistrationValidationException.UsernameMustBeLonger.class %>" message="error.username-cannot-be-shorter" />
	<liferay-ui:error exception="<%= UserRegistrationValidationException.UsernameMustBeShorter.class %>" message="error.username-cannot-be-longer" />
	<liferay-ui:error exception="<%= UserScreenNameException.MustNotBeNull.class %>" message="error.username-cannot-be-null" />

	<liferay-ui:error exception="<%= UserPasswordException.MustBeLonger.class %>" message="error.user-password-cannot-be-shorter" />
	<liferay-ui:error exception="<%= UserPasswordException.MustHaveMoreNumbers.class %>" message="error.user-password-need-contain-number" />
	<liferay-ui:error exception="<%= UserPasswordException.MustHaveMoreSymbols.class %>" message="error.user-password-need-contain-special-letter" />
	<liferay-ui:error exception="<%= UserPasswordException.MustHaveMoreUppercase.class %>" message="error.user-password-need-contain-uppercase" />
	<liferay-ui:error exception="<%= UserPasswordException.MustNotBeNull.class %>" message="error.user-password-cannot-be-null" />

	<liferay-ui:error exception="<%= UserRegistrationValidationException.BirthdayMustNotInFuture.class %>" message="error.birthday-must-not-in-future" />
	<liferay-ui:error exception="<%= UserRegistrationValidationException.BirthdayMustNotSmaller13.class %>" message="error.user-old-must-not-be-smaller" />
	<liferay-ui:error exception="<%= UserRegistrationValidationException.DayInBirthdayMustCorrect.class %>" message="error.day-of-birthday-must-correct" />
	<liferay-ui:error exception="<%= UserRegistrationValidationException.MonthInBirthdayMustCorrect.class %>" message="error.month-of-birthday-must-correct" />

	<liferay-ui:error exception="<%= AddressValidationException.AddressMustBeShorter.class %>" message="error.address-cannot-be-shorter" />
	<liferay-ui:error exception="<%= AddressValidationException.AddressMustNotBeNull.class %>" message="error.address-cannot-be-null" />
	<liferay-ui:error exception="<%= AddressValidationException.CityMustBeShorter.class %>" message="error.city-cannot-be-shorter" />
	<liferay-ui:error exception="<%= AddressValidationException.CityMustNotBeNull.class %>" message="error.city-cannot-be-null" />
	<liferay-ui:error exception="<%= AddressValidationException.ZipCodeMustBe5Digits.class %>" message="error.zip-code-must-be-5-digits" />
	<liferay-ui:error exception="<%= AddressValidationException.ZipCodeMustNotBeNull.class %>" message="error.zip-code-cannot-be-null" />

	<liferay-ui:error exception="<%= UserRegistrationReminderQueryException.AnswerMustNotBeNull.class %>" message="error.answer-cannot-be-null" />
	<liferay-ui:error exception="<%= UserRegistrationReminderQueryException.SecurityQuestionMustNotBeNull.class %>" message="error.security-question-cannot-be-null" />

	<liferay-ui:error exception="<%= UserCustomRegistrationValidationException.HomePhoneMustBe10Digits.class %>" message="error.home-phone-must-be-10-digits" />
	<liferay-ui:error exception="<%= UserCustomRegistrationValidationException.MobilePhoneMustBe10Digits.class %>" message="error.mobile-phone-must-be-10-digits" />

	<aui:model-context bean="${user}" model="${userClass}" />

	<portlet:actionURL name="<%= MVCCommandNames.ADD_REGISTRATION %>" var="registrationActionURL">
		<portlet:param name="redirect" value="${param.redirect}" />
	</portlet:actionURL>

	<aui:form action="${registrationActionURL}" name="fm">
		<aui:fieldset-group markupView="lexicon">
			<aui:fieldset>
				<div class="row">
					<div class="col-sm-6">
						<aui:input label="First name" name="first_name" type="text">
						</aui:input>

						<aui:input label="Last name" name="last_name" type="text">
						</aui:input>

						<aui:input label="Email" name="email_address" type="text">
						</aui:input>

						<aui:input label="Username" name="username" type="text">
						</aui:input>

						<aui:input label="Password" name="password1" type="text">
						</aui:input>

						<aui:input label="Confirm password" name="password2" type="text">
						</aui:input>

						<aui:input cssClass="text-align-left" id="date-time" label="Birthday" name="birthday" type="date">
						</aui:input>

						<div class="form-group">
							<label class="control-label">Gender</label>

							<span class="lexicon-icon-custom reference-mark text-warning" id="qfkd__column1__0">
								<svg class="lexicon-icon lexicon-icon-asterisk" focusable="false" role="presentation" viewBox="0 0 512 512">
									<path
										class="lexicon-icon-outline"
									d="M323.6,190l146.7-48.8L512,263.9l-149.2,47.6l93.6,125.2l-104.9,76.3l-96.1-126.4l-93.6,126.4L56.9,435.3l92.3-123.9L0,263.8l40.4-122.6L188.4,190v-159h135.3L323.6,190L323.6,190z"></path
								>
								</svg>
							</span>

							<div class="radio-group">
								<aui:input label="Male" name="male" type="radio" value="1" />
								<aui:input checked="true" label="Female" name="male" type="radio" value="0" />
							</div>
						</div>
					</div>

					<div class="col-sm-6">
						<aui:input label="Home phone" name="home_phone" type="text">
						</aui:input>

						<aui:input label="Mobile phone" name="mobile_phone" type="text">
						</aui:input>

						<aui:input label="Address" name="address1" type="text">
						</aui:input>

						<aui:input label="Other address" name="address2" type="text">
						</aui:input>

						<aui:input label="City" name="city" type="text">
						</aui:input>

						<aui:input label="State" name="state" type="text">
						</aui:input>

						<aui:input label="Zip" name="zip" type="text">
						</aui:input>
					</div>
				</div>

				<div class="form-group">
					<aui:input label="${questionRender}" name="security_question" type="hidden" value="${questionRender}" />

					<aui:input label="${questionRender}" name="security_answer" type="text">
					</aui:input>
				</div>

				<aui:input id="accepted_tou" label="${termsOfUseText}" name="accepted_tou" type="checkbox" />
			</aui:fieldset>
		</aui:fieldset-group>

		<aui:button-row>
			<aui:button cssClass="btn btn-primary" disabled="true" id="btn-submit" type="submit" />
			<aui:button cssClass="btn btn-secondary" onClick="${param.redirect}" type="cancel" />
		</aui:button-row>
	</aui:form>
</div>

<aui:script>
	$(document).ready(function() {
		 $('input[type="checkbox"]').click(function() {
			if($(this).prop("checked") == true) {
				$(':button[type="submit"]').attr("disabled", false);
				$(':button[type="submit"]').removeClass("disabled");
			}
			else if($(this).prop("checked") == false) {
				$(':button[type="submit"]').attr("disabled", true);
				$(':button[type="submit"]').addClass("disabled");
			}
		});
	});
</aui:script>