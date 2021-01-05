create table COURSE_Course (
	courseId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	status BOOLEAN,
	duration LONG,
	lecturer STRING null,
	description STRING null,
	courseName STRING null
);