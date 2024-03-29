CREATE DATABASE [LoginRegistrationDB]
GO
USE [LoginRegistrationDB]
GO
/****** Object:  Table [dbo].[Users]    Script Date: 02/22/2010 15:59:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[Users]') AND type in (N'U'))
BEGIN
CREATE TABLE [Users](
	[UserId] [int] IDENTITY(1,1) NOT NULL,
	[UserName] [varchar](25) NOT NULL,
	[Password] [nvarchar](25) NOT NULL,
	[Email] [varchar](50) NOT NULL,
	[AddedDate] [datetime] NOT NULL DEFAULT (getdate()),
PRIMARY KEY CLUSTERED 
(
	[UserId] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY],
UNIQUE NONCLUSTERED 
(
	[UserName] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
END
GO
SET ANSI_PADDING OFF
GO
/****** Object:  StoredProcedure [dbo].[usp_UsersLogin]    Script Date: 02/22/2010 15:58:58 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[usp_UsersLogin]') AND type in (N'P', N'PC'))
BEGIN
EXEC dbo.sp_executesql @statement = N'CREATE PROC [usp_UsersLogin] 
	@userName varchar(25),
	@pass nvarchar(25)
AS
	SELECT UserId,UserName,Email,AddedDate FROM Users
	WHERE UserName = @userName AND Password = @pass

	' 
END
GO
/****** Object:  StoredProcedure [dbo].[usp_UsersInsert]    Script Date: 02/22/2010 15:58:57 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[usp_UsersInsert]') AND type in (N'P', N'PC'))
BEGIN
EXEC dbo.sp_executesql @statement = N'CREATE PROC [usp_UsersInsert] 
    @UserName varchar(25),
    @Password nvarchar(25),
    @Email varchar(50)
AS 
	SET NOCOUNT ON 
	SET XACT_ABORT ON  
	
	BEGIN TRAN
	
	INSERT INTO [dbo].[Users] ([UserName], [Password], [Email])
	SELECT @UserName, @Password, @Email
	
	-- Begin Return Select <- do not remove
	SELECT SCOPE_IDENTITY() AS ''UserId''
	-- End Return Select <- do not remove
               
	COMMIT
' 
END
GO
/****** Object:  StoredProcedure [dbo].[usp_UsersSelect]    Script Date: 02/22/2010 15:58:57 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[usp_UsersSelect]') AND type in (N'P', N'PC'))
BEGIN
EXEC dbo.sp_executesql @statement = N'CREATE PROC [usp_UsersSelect] 
    @UserId INT = null
AS 
	SET NOCOUNT ON 
	SET XACT_ABORT ON  

	BEGIN TRAN

	SELECT [UserId], [UserName], [Email], [AddedDate] 
	FROM   [dbo].[Users] 
	WHERE  ([UserId] = @UserId OR @UserId IS NULL) 

	COMMIT' 
END
GO
