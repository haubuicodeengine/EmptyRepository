create table AMFRegistration_CustomUser (
	customUserId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	home_phone INTEGER,
	mobile_phone INTEGER,
	state_ VARCHAR(75) null,
	security_question VARCHAR(75) null,
	security_answer VARCHAR(75) null,
	accepted_tou BOOLEAN
);