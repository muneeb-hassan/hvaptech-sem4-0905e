CREATE DATABASE Exercises2
GO
USE Exercises2
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
	VALUES ('AAA', 'Nguyen Van A', '1987-12-20')
INSERT INTO Student
	VALUES ('BBB', 'Tran Thi B', '1988-11-21')
GO
INSERT INTO Student_Login
	VALUES('AAA','aaa','aaa')
INSERT INTO Student_Login
	VALUES('BBB','bbb','bbb')
INSERT INTO Student_Login
	VALUES('CCC','ccc','ccc')