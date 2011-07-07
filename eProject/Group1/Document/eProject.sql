CREATE DATABASE ALLU_DECORS
GO
USE ALLU_DECORS
GO
CREATE TABLE tblHome
(
	ID int identity(1,1) PRIMARY KEY,
	MainIntrodution nvarchar(1000),
	DomainIntrodution nvarchar(1000),
	ServiceIntrodution nvarchar(1000)
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
CREATE TABLE tblPageContact
(
	ID int identity(1,1) PRIMARY KEY,
	Introdution nvarchar(4000) NOT NULL
)
GO
CREATE TABLE tblFeedback
(
	ID int identity(1,1) PRIMARY KEY,
	Fullname nvarchar(100),
	Email nvarchar (70),
	Comment nvarchar (2000) NOT NULL,
	Datecreate nvarchar(10)
)
GO
CREATE TABLE tblAboutus
(
	ID int identity(1,1) PRIMARY KEY,
	Introduction nvarchar(2000) NOT NULL
)
GO
CREATE TABLE tblProjectType
(
	ID int identity(1,1) PRIMARY KEY,
	ProjectTypeName nvarchar(100) NOT NULL UNIQUE
)
GO
INSERT INTO tblProjectType VALUES ('On-Going Projects')
INSERT INTO tblProjectType VALUES ('Up-Coming Projects')
INSERT INTO tblProjectType VALUES ('Accomplished Projects')
GO
CREATE TABLE tblProject
(
	ID int identity(1,1) PRIMARY KEY,
	ProjectName nvarchar(100) NOT NULL UNIQUE,	/*Ten project*/
	Description nvarchar(2000),	/*Dien giai cho project*/
	[Image] nvarchar(100),
	ProjectTypeID int,
	CONSTRAINT FK_tblProject_tblProjectType FOREIGN KEY (ProjectTypeID) REFERENCES tblProjectType(ID)
)
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
CREATE TABLE tblUserDetail
(
	ID int identity(1,1) PRIMARY KEY,
	Email nvarchar(70) UNIQUE NOT NULL,
	Password nvarchar(50) NOT NULL,
	FullName nvarchar(100) NOT NULL,
	Sex bit DEFAULT(1),
	DateBirth nvarchar(10),
	Address nvarchar(100) NOT NULL,
	Phone nvarchar(50),
	LevelID int NOT NULL DEFAULT(2),
	IsActive bit DEFAULT (1),	/*Trang thai active cua user*/
	CONSTRAINT FK_tblUserDetail_tblLevel FOREIGN KEY (LevelID) REFERENCES tblLevel(ID)
)
GO
create table tblDomain	/*Service Type*/
(
	ID int identity(1,1) PRIMARY KEY,
	DomainName nvarchar(100) NOT NULL UNIQUE
)
INSERT INTO tblDomain VALUES('Decorating the House')
INSERT INTO tblDomain VALUES('Decorating the Offices')
INSERT INTO tblDomain VALUES('Decorating the Community Halls')
INSERT INTO tblDomain VALUES('Decorating the Restaurants')
GO
CREATE TABLE tblService
(
	ID int identity(1,1) PRIMARY KEY,
	ServiceName nvarchar(100) NOT NULL,	/*Ten service*/
	Description nvarchar(2000),	/*Dien giai cho service*/
	[Image] nvarchar(100),
	Price decimal(18, 2),
	DomainID int,
	CONSTRAINT FK_tblService_tblDomain FOREIGN KEY (DomainID) REFERENCES tblDomain(ID)
)
INSERT INTO tblService (DomainID,ServiceName) VALUES (1,'Decorating and Furnishing with Furniture And Glass')
INSERT INTO tblService (DomainID,ServiceName) VALUES (1,'Kitchen Design')
INSERT INTO tblService (DomainID,ServiceName) VALUES (1,'Flooring Layout')
INSERT INTO tblService (DomainID,ServiceName) VALUES (1,'Lightning Effects')
INSERT INTO tblService (DomainID,ServiceName) VALUES (1,'Window Coverings')

INSERT INTO tblService (DomainID,ServiceName) VALUES (2,'Decorating and Furnishing with Furniture And Glass')
INSERT INTO tblService (DomainID,ServiceName) VALUES (2,'Kitchen Design')
INSERT INTO tblService (DomainID,ServiceName) VALUES (2,'Flooring Layout')
INSERT INTO tblService (DomainID,ServiceName) VALUES (2,'Lightning Effects')
INSERT INTO tblService (DomainID,ServiceName) VALUES (2,'Window Coverings')

INSERT INTO tblService (DomainID,ServiceName) VALUES (3,'Decorating and Furnishing with Furniture And Glass')
INSERT INTO tblService (DomainID,ServiceName) VALUES (3,'Curtain Designing')
INSERT INTO tblService (DomainID,ServiceName) VALUES (3,'Flooring Layout')
INSERT INTO tblService (DomainID,ServiceName) VALUES (3,'Lightning Effects')
INSERT INTO tblService (DomainID,ServiceName) VALUES (3,'Window Coverings')

INSERT INTO tblService (DomainID,ServiceName) VALUES (4,'Decorating and Furnishing with Furniture And Glass')
INSERT INTO tblService (DomainID,ServiceName) VALUES (4,'Curtain Designing')
INSERT INTO tblService (DomainID,ServiceName) VALUES (4,'Flooring Layout')
INSERT INTO tblService (DomainID,ServiceName) VALUES (4,'Lightning Effects')
INSERT INTO tblService (DomainID,ServiceName) VALUES (4,'Colour Schemes')
GO
create table tblRequest
(
	ID int identity(1,1) PRIMARY KEY,
	Email nvarchar(70) NOT NULL,
	Location nvarchar(100),
	Note nvarchar(300),
	TotalPayment decimal(18, 2) DEFAULT(0),	/*Tong so tien cua Request*/
	TotalPaidAmount decimal(18, 2) DEFAULT (0),	/*Tong so tien Client da tra*/
	DateRequest nvarchar(10) NOT NULL,
	DateBegin nvarchar(10),
	DateComplete nvarchar(10),
	Status nvarchar(30),
	CONSTRAINT FK_tblRequest_tblUserDetail FOREIGN KEY (Email) REFERENCES tblUserDetail(Email)
)
GO
create table tblRequestDetail
(
	ID int identity(1,1) PRIMARY KEY,
	RequestID int,
	ServiceID int,
	Payment decimal(18, 2) DEFAULT(0),	/*So tien cua mot Servcie*/
	CONSTRAINT FK_tblRequestDetail_tblRequest FOREIGN KEY (RequestID) REFERENCES tblRequest(ID)
)
GO
CREATE TABLE tblPayment
(
	ID int identity(1,1) PRIMARY KEY,
	RequestID int,
	PaidAmount decimal(18, 2) DEFAULT(0), /*So tien Client tra mot lan*/
	Date nvarchar(10),
	CONSTRAINT FK_tblPayment_tblRequest FOREIGN KEY (RequestID) REFERENCES tblRequest(ID)
)
