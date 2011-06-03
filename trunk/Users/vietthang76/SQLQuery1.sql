CREATE DATABASE ALLU_DECORS
GO
CREATE TABLE tblLevel
(
	ID int identity(1,1) PRIMARY KEY,
	LevelName nvarchar(10)NOT NULL UNIQUE
)
GO
INSERT INTO tblLevel VALUES ('Admin')
INSERT INTO tblLevel VALUES ('Client')
GO
CREATE TABLE tblUserDetails
(
	ID int identity(1,1) PRIMARY KEY,
	Email nvarchar(70) UNIQUE NOT NULL,
	Password nvarchar(30) NOT NULL,
	FullName nvarchar(100) NOT NULL,
	Address nnvarchar(100) NOT NULL,
	LevelID int NOT NULL DEFAULT(2),
	Status bit DEFAULT (0)	
)
GO
CREATE TABLE tblProjectType
(
	ID int identity(1,1) PRIMARY KEY,
	ProjectName nvarchar(100) NOT NULL UNIQUE
)
GO
CREATE TABLE tblProject
(
	ID int identity(1,1) PRIMARY KEY,
	ProjectTypeID int,
	Description nvarchar(100) NOT NULL,
	Image nvarchar(100)		
)
GO
CREATE TABLE tblFAQ
(
	ID int identity(1,1) PRIMARY KEY,
	Question nvarchar(300),
	Answer nvarchar(500)	
)
GO
