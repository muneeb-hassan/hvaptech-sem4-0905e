--DROP DATABASE Servler_Exercises2
GO
CREATE DATABASE Servler_Exercises2
GO
USE Servler_Exercises2
GO
CREATE TABLE Student
	(
		StudentID	varchar(3)	primary key,
		StudentName	varchar(38),
		DateBirth	datetime
	)
GO
CREATE TABLE Student_Login
	(
		StudentID	varchar(3),
		Username	varchar(30),
		[Password]	varchar(30)
	)
GO
INSERT INTO Student
	VALUES ('AAA', 'Thanh A', '1987-12-20')
INSERT INTO Student
	VALUES ('BBB', 'Tran B', '1988-11-21')
INSERT INTO Student
	VALUES ('CCC', 'Nguyen C', '1989-10-22')
GO
INSERT INTO Student_Login
	VALUES('AAA','aaa','passa')
INSERT INTO Student_Login
	VALUES('BBB','bbb','passb')
INSERT INTO Student_Login
	VALUES('CCC','ccc','passc')