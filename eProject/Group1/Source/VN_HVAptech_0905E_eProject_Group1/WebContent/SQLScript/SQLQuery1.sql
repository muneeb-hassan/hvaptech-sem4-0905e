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
CREATE TABLE tblFAQ
(
	ID int identity(1,1) PRIMARY KEY,
	Question nvarchar(300),
	Answer nvarchar(500)	
)
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