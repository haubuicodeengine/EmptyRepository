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
	duration STRING null
);