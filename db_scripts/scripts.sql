-----------------------------------------------------------------------------------------
--Azure MS SQL Queries:
Create Database SmartHireDb;
GO

Create Schema SmartHire;
GO

Use SmartHire;
GO

CREATE TABLE [SmartHire].[HR_Profile](
	[ID] [int] IDENTITY(1000,1) NOT NULL,
	[First_Name] [varchar](500) NULL,
	[Last_Name] [varchar](500) NULL,
	[Email] [varchar](500) NULL,
	[Password] varchar(500) not null,
	[Phone] [varchar](500) NULL,
	[City] [varchar](500) NULL,
	[Created_Date] [datetime] NOT NULL DEFAULT (getdate()),
	[Created_By] [varchar](255) NULL,
	[Modified_Date] [datetime] NULL,
	[Modified_By] [varchar](255) NULL,
 CONSTRAINT [PK_HR_Profile_ID] PRIMARY KEY CLUSTERED
([ID] ASC)
)
GO



