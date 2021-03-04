<%@ include file="./init.jsp"%>
<%
	Calendar birthday = CalendarFactoryUtil.getCalendar();
%>
<liferay-ui:error key="Firstname is too long!" message="Firstname is too long!" />
<liferay-ui:error key="Firstname is too short!" message="Firstname is too short!" />
<liferay-ui:error key="Firstname could not be null!" message="Firstname could not be null!" />
<liferay-ui:error key="Lastname is too long!" message="Lastname is too long!" />
<liferay-ui:error key="Lastname is too short!" message="Lastname is too long!" />
<liferay-ui:error key="Lastname could not be null!" message="Lastname could not be null!" />
<liferay-ui:error key="Email is too long!" message="Email is too long!" />
<liferay-ui:error key="Email is too short!" message="Email is too short!" />
<liferay-ui:error key="Email could not be null!" message="Email could not be null!" />
<liferay-ui:error key="Username is too long!" message="Firstname is too long!" />
<liferay-ui:error key="Username is too short!" message="Username is too short!" />
<liferay-ui:error key="Username could not be null!" message="Username could not be null!" />
<liferay-ui:error key="Address1 is too long!" message="Address1 is too long!" />
<liferay-ui:error key="Address1 is too short!" message="Address1 is too long!" />
<liferay-ui:error key="Address1 could not be null!" message="Address1 is too long!" />
<liferay-ui:error key="Address2 is too long!" message="Address2 is too long!" />
<liferay-ui:error key="Address2 is too short!" message="Address2 is too short!" />
<liferay-ui:error key="Address2 could not be null!" message="Address2 could not be null!" />
<liferay-ui:error key="City is too long!" message="City is too long!" />
<liferay-ui:error key="City is too short!" message="City is too short!" />
<liferay-ui:error key="City could not be null!" message="City could not be null!" />
<liferay-ui:error key="Home phone is too long!" message="Home phone is too long!" />
<liferay-ui:error key="Home phone is too short!" message="Home phone is too short!" />
<liferay-ui:error key="Home phone could not be null!" message="Home phone could not be null!" />
<liferay-ui:error key="mobile phone is too long!" message="mobile phone is too long!" />
<liferay-ui:error key="mobile phone is too short!" message="mobile phone is too short!" />
<liferay-ui:error key="mobile phone could not be null!" message="mobile phone could not be null!" />
<liferay-ui:error key="Security answer is too long!" message="Security answer is too long!" />	
<liferay-ui:error key="Security answer is too short!" message="Security answer is too short!" />
<liferay-ui:error key="Security answer could not be null!" message="Security answer could not be null!" />
<liferay-ui:error key="Password is too long!" message="Password is too long!" />
<liferay-ui:error key="Password is too short!" message="Password is too short!" />
<liferay-ui:error key="Password could not be null!" message="Security answer could not be null!" />
<liferay-ui:error key="Terms of Use must be checked" message="Terms of Use must be checked" />
<liferay-ui:error key="Home phone is required only number" message="Home phone is required only number" />
<liferay-ui:error key="Mobile phone is required only number" message="Mobile phone is required only number" />

<liferay-ui:error exception="<%= UserPasswordException.MustHaveMoreNumbers.class %>" message="Password must contain at least 1 number" />
<liferay-ui:error exception="<%= UserPasswordException.MustHaveMoreSymbols.class %>" message="Password must contain at least 1 special symbol" />
<liferay-ui:error exception="<%= UserPasswordException.MustHaveMoreUppercase.class %>" message="Password must contain at least 1 uppercase" />

<portlet:actionURL var="userActionURL"
	name="<%=MVCCommandNames.ADD_USER%>">
	<portlet:param name="redirect" value="${param.redirect}" />
</portlet:actionURL>

<div class="container-fluid-1280 edit-course">

	<aui:model-context bean="${user}" model="${userClass}" />

	<aui:form action="${userActionURL}" name="fm">

		<aui:input name="userId" field="userId" type="hidden" />

		<aui:fieldset-group markupView="lexicon">

			<aui:fieldset label="Base Infor">
				<aui:row>
					<aui:col width="50">
						<aui:input label="First Name" name="first_name"></aui:input>
					</aui:col>
					<aui:col width="50">
						<aui:input label="Last Name" name="last_name"></aui:input>
					</aui:col>

				</aui:row>

				<aui:row>
					<aui:col width="50">
						<aui:input label="Email Address" name="email_address"></aui:input>
					</aui:col>
					<aui:col width="50">
						<aui:input label="Username" name="username"></aui:input>
					</aui:col>
				</aui:row>

				<aui:row>
					<aui:col width="50">
						<aui:input label="Male" name="male" />
					</aui:col>
					<aui:col width="50">
						<aui:input label="Password" name="password1" type="text">
						</aui:input>
					</aui:col>
				</aui:row>
				
				
				<aui:row>
					<aui:col width="50">
						<aui:input cssClass="text-align-left" id="date-time" label="Birthday" name="birthday" type="date">
						</aui:input>
					</aui:col>
					<aui:col width="50">
						<aui:input label="Confirm Password" name="password2" type="text"></aui:input>
					</aui:col>
				</aui:row>

			</aui:fieldset>

		</aui:fieldset-group>

		<aui:fieldset-group markupView="lexicon">
			<aui:fieldset label="Phone">

				<aui:input label="Home Phone" name="home_phone" type="text"></aui:input>

				<aui:input label="Mobile" name="mobile_phone" type="text"></aui:input>
			</aui:fieldset>
		</aui:fieldset-group>

		<aui:fieldset-group markupView="lexicon">
			<aui:fieldset label="Billing Address">

				<aui:row>
					<aui:col width="50">
						<aui:input label="Address 1" name="address" type="text"></aui:input>
					</aui:col>
					<aui:col width="50">
						<aui:input label="Address 2" name="address2" type="text"></aui:input>
					</aui:col>
				</aui:row>

				<aui:row>
					<aui:col width="50">
						<aui:input label="City" name="city" type="text"></aui:input>
					</aui:col>
					<aui:col width="50">
						<aui:input label="State" name="state" type="text"></aui:input>
					</aui:col>
				</aui:row>

				<aui:input label="Zip Code" name="zip" type="text"></aui:input>
			</aui:fieldset>
		</aui:fieldset-group>
		<aui:fieldset-group markupView="lexicon">
			<aui:fieldset label="Misc">
				<aui:input label="Security Question" name="security_question"
					type="text"></aui:input>

				<aui:input label="Answer" name="security_answer" type="text"></aui:input>

				<aui:row>
					<aui:input type="checkbox" label="I have read, understand, and agree with the Terms of Use governing my
access to and use of the Acme Movie Fanatics
web site." name="accepted_tou" />
				
				</aui:row>

			</aui:fieldset>
		</aui:fieldset-group>
		<aui:button value="Finish" href="" type="submit" />
	</aui:form>

</div>