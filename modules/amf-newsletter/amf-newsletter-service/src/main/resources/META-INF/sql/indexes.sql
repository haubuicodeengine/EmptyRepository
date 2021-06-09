create index IX_E471FECE on TS_Article (groupId);
create index IX_195D2050 on TS_Article (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_61517AD2 on TS_Article (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_D7FD6F6B on TS_Newsletter (groupId);
create index IX_E4BA1053 on TS_Newsletter (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_A4208F95 on TS_Newsletter (uuid_[$COLUMN_LENGTH:75$], groupId);