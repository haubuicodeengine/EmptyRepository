create table AMFRegistration_CustomUser (
	customUserId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	home_phone VARCHAR(75) null,
	mobile_phone VARCHAR(75) null,
	state_ VARCHAR(75) null,
	security_question VARCHAR(75) null,
	security_answer VARCHAR(75) null,
	accepted_tou BOOLEAN
);

--create table Registration_CustomUser (
--	customUserId LONG not null primary key,
--	groupId LONG,
--	companyId LONG,
--	userId LONG,
--	userName VARCHAR(75) null,
--	createDate DATE null,
--	modifiedDate DATE null,
--	home_phone INTEGER,
--	mobile_phone INTEGER,
--	state_ VARCHAR(75) null,
--	security_question VARCHAR(75) null,
--	security_answer VARCHAR(75) null,
--	accepted_tou BOOLEAN
--);