/* ---------------------------------------------------------------------- */
/* Project name:		  Blue Pumpkin				                      */
/* Database name:		  Blue_Pumpkin                                    */			
/* Script type:           Database creation script                        */
/* Created on:            2011-06-06 14:52                                */
/* Model version:         Version 2011-06-06 1                            */
/* ---------------------------------------------------------------------- */

CREATE DATABASE Blue_Pumpkin
GO
USE Blue_Pumpkin
GO

/* ---------------------------------------------------------------------- */
/* Tables                                                                 */
/* ---------------------------------------------------------------------- */

/* ---------------------------------------------------------------------- */
/* Add table "Users"                                                      */
/* ---------------------------------------------------------------------- */

CREATE TABLE [Users] (
    [UserId] INTEGER IDENTITY(1,1) NOT NULL,
    [RoleId] INTEGER NOT NULL,
    [Username] VARCHAR(12) NOT NULL,
    [Password] VARCHAR(50) NOT NULL,
    [Active] BIT CONSTRAINT [DEF_Users_Active] DEFAULT '1',
    [DateCreate] VARCHAR(10),
    [FirstName] VARCHAR(30),
    [LastName] VARCHAR(30),
    [Gender] BIT CONSTRAINT [DEF_Users_Gender] DEFAULT '1',
    [DateOfBirth] VARCHAR(10),
    [Address] VARCHAR(2500),
    [Email] VARCHAR(30),
    [Phone] VARCHAR(20),
    [Image] VARCHAR(300),
    CONSTRAINT [PK_Users] PRIMARY KEY ([UserId])
)
GO

/* ---------------------------------------------------------------------- */
/* Add table "Roles"                                                      */
/* ---------------------------------------------------------------------- */

CREATE TABLE [Roles] (
    [RoleId] INTEGER IDENTITY(0,1) NOT NULL,
    [RoleName] VARCHAR(30) NOT NULL,
    [Description] VARCHAR(2500),
    CONSTRAINT [PK_Roles] PRIMARY KEY ([RoleId])
)
GO

/* ---------------------------------------------------------------------- */
/* Add table "Events"                                                     */
/* ---------------------------------------------------------------------- */

CREATE TABLE [Events] (
    [EventId] INTEGER IDENTITY(1,1) NOT NULL,
    [TypeId] INTEGER NOT NULL,
    [EventName] VARCHAR(30) NOT NULL,
    [DateCreate] VARCHAR(10),
    [DateBegin] VARCHAR(10) NOT NULL,
    [DateEnd] VARCHAR(10) NOT NULL,
    [Description] VARCHAR(2500),
    [Image] VARCHAR(30),
    CONSTRAINT [PK_Events] PRIMARY KEY ([EventId])
)
GO


/* ---------------------------------------------------------------------- */
/* Add table "EventTypes"                                                 */
/* ---------------------------------------------------------------------- */

CREATE TABLE [EventTypes] (
    [TypeId] INTEGER IDENTITY(1,1) NOT NULL,
    [TypeName] VARCHAR(30) NOT NULL,
    [Description] VARCHAR(2500),
    CONSTRAINT [PK_EventTypes] PRIMARY KEY ([TypeId])
)
GO

/* ---------------------------------------------------------------------- */
/* Add table "EventResults"                                               */
/* ---------------------------------------------------------------------- */

CREATE TABLE [EventResults] (
	[ResultsId] INTEGER IDENTITY(1,1) NOT NULL,
    [EventId] INTEGER NOT NULL,
    [UserId] INTEGER NOT NULL,
    [Rank] INTEGER NOT NULL,
    [Description] VARCHAR(2500),
    CONSTRAINT [PK_EventResults] PRIMARY KEY ([ResultsId])
)

GO

/* ---------------------------------------------------------------------- */
/* Add table "Requests"                                                     */
/* ---------------------------------------------------------------------- */

CREATE TABLE [Requests] (
    [RequestId] INTEGER IDENTITY(1,1) NOT NULL,
    [UserId] INTEGER NOT NULL,
    [EventId] INTEGER NOT NULL,
    [DateRequest] VARCHAR(10),
    [State] VARCHAR(30),
    [Description] VARCHAR(2500),
    CONSTRAINT [PK_Requests] PRIMARY KEY ([RequestId])
)
GO

/* ---------------------------------------------------------------------- */
/* Foreign key constraints                                                */
/* ---------------------------------------------------------------------- */

ALTER TABLE [Users] ADD CONSTRAINT [Roles_Users] 
    FOREIGN KEY ([RoleId]) REFERENCES [Roles] ([RoleId])
GO

ALTER TABLE [Events] ADD CONSTRAINT [EventTypes_Events] 
    FOREIGN KEY ([TypeId]) REFERENCES [EventTypes] ([TypeId])
GO 

ALTER TABLE [EventResults] ADD CONSTRAINT [Events_EventResults] 
    FOREIGN KEY ([EventId]) REFERENCES [Events] ([EventId])
GO

ALTER TABLE [Requests] ADD CONSTRAINT [Users_Requests] 
    FOREIGN KEY ([UserId]) REFERENCES [Users] ([UserId])
GO

ALTER TABLE [Requests] ADD CONSTRAINT [Events_Requests] 
    FOREIGN KEY ([EventId]) REFERENCES [Events] ([EventId])
GO

/* ---------------------------------------------------------------------- */
/* Insert data                                                            */
/* ---------------------------------------------------------------------- */

INSERT INTO [Roles]([RoleName])
VALUES('Admin')
INSERT INTO [Roles]([RoleName])
VALUES('Employee')
GO
INSERT INTO [Users]([RoleId],[Username],[Password])
VALUES(0,'admin','admin')
INSERT INTO [Users]([RoleId],[Username],[Password])
VALUES(1,'employee','employee')
INSERT INTO [Users]([RoleId],[Username],[Password])
VALUES(1,'user01','user01')


