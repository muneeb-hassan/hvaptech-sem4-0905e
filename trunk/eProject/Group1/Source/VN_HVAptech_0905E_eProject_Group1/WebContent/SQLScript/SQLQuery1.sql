CREATE DATABASE ALLU_DECORS
GO
USE ALLU_DECORS
GO
/* TABLE OF ALLU_DECOR */
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
	ID int identity(1,1),
	FullName nvarchar(100) NOT NULL,
	Address nvarchar(100) NOT NULL,
	Phone nvarchar(50),
	Email nvarchar(70) PRIMARY KEY,
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
ALTER TABLE tblProject ADD CONSTRAINT FK_ProjectID FOREIGN KEY (ProjectTypeID) REFERENCES tblProjectType(ID)
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
CREATE TABLE PageContact
(
	ID int identity(1,1) PRIMARY KEY,
	Introdution nvarchar(2000) NOT NULL,
	DateCreate datetime
)
GO
INSERT INTO PageContact VALUES('For any subscription-related inquiries, including change of mailing address, 
ordering another subscription, canceling your subscription, or any other questions or concerns, 
please contact 1. General inquiries or comments about the site - info@alludecors.com
2. All advertising inquiries with the exception of Home Products & Services Directory advertisement@alludecors.com
3. Business & Professionals membership inquiries or questions about the Home Products & Services Directory Sales@alludecors.com
Or MAILING ADDRESS: Rental Decorating Digest P.O. Box 580845 Modesto, CA. 95358 United States',GETDATE())
GO
CREATE TABLE Feedback
(
	ID int identity(1,1) PRIMARY KEY,
	Fullname nvarchar(100) NOT NULL,
	Address nvarchar(100) NOT NULL,
	Email nvarchar (100),
	Phone nvarchar(100),
	Comment nvarchar (1000) NOT NULL,
	Datecreate datetime
)
GO
CREATE TABLE Aboutus
(
	ID int identity(1,1) PRIMARY KEY,
	Introduction nvarchar(2000) NOT NULL
)
GO
CREATE TABLE tblServiceType
(
	ID int identity(1,1) PRIMARY KEY,
	ServiceName nvarchar(100) UNIQUE NOT NULL
)
GO
CREATE TABLE tblService
(
	ID int identity (1,1) PRIMARY KEY,
	ServiceID int,
	Description nvarchar(100) NOT NULL
	CONSTRAINT FK_Service FOREIGN KEY (ServiceID) REFERENCES tblServiceType(ID)
)
GO
INSERT INTO tblServiceType VALUES('Decorating the House')
INSERT INTO tblServiceType VALUES('Decorating the Offices')
INSERT INTO tblServiceType VALUES('Decorating the Community Halls')
INSERT INTO tblServiceType VALUES('Decorating the Restaurants')

INSERT INTO tblService (ServiceID,Description) VALUES (1,'Decorating and Furnishing with Furniture And Glass')
INSERT INTO tblService (ServiceID,Description) VALUES (1,'Kitchen Design')
INSERT INTO tblService (ServiceID,Description) VALUES (1,'Flooring Layout')
INSERT INTO tblService (ServiceID,Description) VALUES (1,'Lightning Effects')
INSERT INTO tblService (ServiceID,Description) VALUES (1,'Window Coverings')

INSERT INTO tblService (ServiceID,Description) VALUES (2,'Decorating and Furnishing with Furniture And Glass')
INSERT INTO tblService (ServiceID,Description) VALUES (2,'Kitchen Design')
INSERT INTO tblService (ServiceID,Description) VALUES (2,'Flooring Layout')
INSERT INTO tblService (ServiceID,Description) VALUES (2,'Lightning Effects')
INSERT INTO tblService (ServiceID,Description) VALUES (2,'Window Coverings')

INSERT INTO tblService (ServiceID,Description) VALUES (3,'Decorating and Furnishing with Furniture And Glass')
INSERT INTO tblService (ServiceID,Description) VALUES (3,'Curtain Designing')
INSERT INTO tblService (ServiceID,Description) VALUES (3,'Flooring Layout')
INSERT INTO tblService (ServiceID,Description) VALUES (3,'Lightning Effects')
INSERT INTO tblService (ServiceID,Description) VALUES (3,'Window Coverings')

INSERT INTO tblService (ServiceID,Description) VALUES (4,'Decorating and Furnishing with Furniture And Glass')
INSERT INTO tblService (ServiceID,Description) VALUES (4,'Curtain Designing')
INSERT INTO tblService (ServiceID,Description) VALUES (4,'Flooring Layout')
INSERT INTO tblService (ServiceID,Description) VALUES (4,'Lightning Effects')
INSERT INTO tblService (ServiceID,Description) VALUES (4,'Colour Schemes')
GO
/* 
	tblOrder de chua cac don dat hang tu Customer.
		TotalPayment se duoc Admin dien vao khi nhan duoc Order
		Payment la tong so tien thanh toan cho Order dua tren tblPayment
	tblOrderDetail chi tiet don dat hang cua Customer
	tblPayment chua cac dot thanh toan cho tung Order cua Customer.
		Payment se duoc cong Update tren tblOrder dua tren OrderID
*/

CREATE TABLE tblOrder
(
	OrderDate datetime,
	ID int identity(1,1) PRIMARY KEY,
	Email nvarchar(70) NOT NULL,
	TotalPayment int DEFAULT(0),
	Payment int DEFAULT (0),
	OrderStatus bit DEFAULT(0),
	BeginDate datetime
)
ALTER TABLE tblOrder ADD CONSTRAINT FK_UserOrder FOREIGN KEY (Email) REFERENCES tblUserDetails(Email)
GO
CREATE TABLE tblOrderDetail
(
	ID int identity(1,1) PRIMARY KEY,
	OrderID int,
	ServiceID int,
	CONSTRAINT FK_OrderID FOREIGN KEY (ServiceID) REFERENCES tblOrder(ID)
)
GO
CREATE TABLE tblPayment
(
	PaymentDate datetime,
	ID int identity(1,1) PRIMARY KEY,
	OrderID int,
	Payment int DEFAULT(0),
	CONSTRAINT FK_Payment FOREIGN KEY (OrderID) REFERENCES tblOrder(ID)
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
GO
