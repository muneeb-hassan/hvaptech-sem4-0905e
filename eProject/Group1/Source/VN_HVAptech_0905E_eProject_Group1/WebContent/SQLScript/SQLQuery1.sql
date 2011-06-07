CREATE DATABASE ALLU_DECORS
GO
USE ALLU_DECORS
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
	FullName nvarchar(100) NOT NULL,
	Address nvarchar(100) NOT NULL,
	Phone nvarchar(50),
	Email nvarchar(70) UNIQUE NOT NULL,
	Password nvarchar(30) NOT NULL,
	LevelID int NOT NULL DEFAULT(2),
	Status bit DEFAULT (1),
	CONSTRAINT FK_UserID FOREIGN KEY (LevelID) REFERENCES tblLevel(ID)
)
GO
CREATE TABLE tblProjectType
(
	ID int identity(1,1) PRIMARY KEY,
	ProjectName nvarchar(100) NOT NULL UNIQUE
)
GO
INSERT INTO tblProjectType VALUES ('On-Going Projects')
INSERT INTO tblProjectType VALUES ('Up-Coming Projects')
INSERT INTO tblProjectType VALUES ('Accomplished Projects')
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
	Question nvarchar(500),
	Answer nvarchar(1000)	
)
GO
INSERT INTO tblFAQ VALUES ('I am not a registered user? Will I be able to apply for the service?',
'No, only the registered users will be able to apply for the service.')
INSERT INTO tblFAQ VALUES ('How to apply for the Service?',
'First you must apply for the service mentioning the service and the domain interested in, and the address at which you want the service to be provided. Then we will get back to you whether we will provide the service at that location or not.')
INSERT INTO tblFAQ VALUES ('Will I be provided in any other services apart from the services and domains displayed? And if yes, what will be the charges?',
'Well it will be dependant on the type of the service and the domain you requested. We will revert back to you once the service request is received by us. The charges will be based on the service and the domain you preferred. This will be communicated well in advance before accepting and going ahead with the service.')
INSERT INTO tblFAQ VALUES('How will I know that whether you will provide the service or not? If yes, then when will the service provided?',
'Once the service request is received, we will get back to you like whether we provide the service or not, and if we provide service we will inform when the service will be started.')
INSERT INTO tblFAQ VALUES('How long will it take to complete the service?',
'Well this will be dependant on the service and domain preferred. Also it will be dependant on the work or building or complex, etc. for which the services are preferred for.')
GO
/* Ham kiem tra Email co ton tai hay khong. Gia tri tra ve se la 0 hoac 1 */
CREATE PROC CheckEmail
(
	@Email nvarchar(70),
	@returnvalue bit OUT
)
AS
	SELECT @returnvalue=COUNT(Email)FROM tblUserDetails WHERE Email=@Email
GO
/* Ham Login cua User. Gia tri tra ve @CheckUser la 0 hoac 1.
Neu @CheckUser la 1 gia tri kem theo se la 1 table chua thong tin nguoi su dung */
CREATE PROC UserLogin
(
	@Email nvarchar(70),
	@Password nvarchar(30),
	@CheckUser int OUT
)
AS
	SELECT @CheckUser = COUNT(LevelID) FROM tblUserDetails WHERE Email=@Email AND Password=@Password
	IF(@CheckUser = 1)
		SELECT  FullName,Email, LevelID FROM tblUserDetails WHERE Email=@Email AND Password=@Password
GO
/*Ham Insert thong tin nguoi su dung. Mac dinh IDLevel = 2*/
CREATE PROC InsertUser
(
	@FullName nvarchar(100),
	@Address nvarchar(100),
	@Phone nvarchar(50),
	@Email nvarchar(70),
	@Password nvarchar(30)
)
AS
	INSERT INTO tblUserDetails (FullName,Address,Phone,Email,Password) 
		VALUES (@FullName,@Address,@Phone,@Email,@Password)
GO
/*Delete User bang cach set dac tinh Status la 0 hoac 1*/
CREATE PROC DeleteUser
(
	@Email nvarchar(70)
)
AS
	UPDATE tblUserDetails SET Status = 0
GO
/*Liet ke User*/
CREATE PROC ListUser
AS
	SELECT FullName,Address,Phone, Email FROM tblUserDetails WHERE Status = 1