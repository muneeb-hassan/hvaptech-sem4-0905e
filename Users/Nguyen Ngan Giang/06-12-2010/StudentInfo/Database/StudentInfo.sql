-- Account table stores information about user id and password of users
CREATE TABLE Account
(
	StudentID varchar(3) NOT NULL ,
	Password varchar(15) NOT NULL ,
	CONSTRAINT PK_StudentID PRIMARY KEY(StudentID)
)
GO

-- Student table stores details of student such as id, name, and birthday
CREATE TABLE Student
(
	StudentID varchar(3) NOT NULL,
	StudentName varchar(38) NOT NULL,
	DateBirth datetime,
	CONSTRAINT PK_StudentDetail PRIMARY KEY(StudentID),
	CONSTRAINT FK_StudentDetail FOREIGN KEY(StudentID) REFERENCES Account(StudentID)
)
GO

INSERT INTO Account VALUES ('ST1','admin')
INSERT INTO Student VALUES ('ST1','Nguyen Ngan Giang','1987-10-18')


