create table CourseManagement_Course (
	courseId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	courseName STRING null,
	lecturer STRING null,
	description STRING null,
	duration LONG,
	courseStatus INTEGER
);


create table CourseManagement_Registration (
	registrationId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	courseId LONG,
	registrationStatus INTEGER
);


INSERT INTO CourseManagement_Course (courseId, groupId, companyId, userId, userName, createDate, modifiedDate, courseName, lecturer, description, duration, courseStatus) VALUES (10, 20124, 20101, 1, 'Rose', null, null, 'Course 1', 'Ms. Rose', '', 5, true);
INSERT INTO CourseManagement_Course (courseId, groupId, companyId, userId, userName, createDate, modifiedDate, courseName, lecturer, description, duration, courseStatus) VALUES (11, 20124, 20101, 1, 'Sam', null, null, 'Course 2', 'Ms. Sam', '', 5, true);