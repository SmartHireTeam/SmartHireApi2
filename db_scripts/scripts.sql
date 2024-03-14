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

Create table [SmartHire].[JOB_DESCRIPTION_UPLOAD]
(
JD_ID INT IDENTITY(1,1) NOT NULL,
JD_Code VARCHAR(50) NULL,
JD_Name VARCHAR(500) NULL,
JD_Description VARCHAR(2000) NULL,
JD_FILE varbinary(max) NULL,
File_Name VARCHAR(500) NULL,
File_Type VARCHAR(20) NULL,
Created_Date DateTime NULL,
Created_By VARCHAR(2000) NULL,
Modified_Date DateTime NULL,
Modified_By VARCHAR(2000) NULL,
CONSTRAINT [PK_JD_ID] PRIMARY KEY CLUSTERED
([JD_ID])
);
GO
--

INSERT INTO [SmartHire].[JOB_DESCRIPTION_UPLOAD]
           ([JD_Code]
           ,[JD_Name]
           ,[JD_Description]
           ,[JD_FILE]
		   ,[File_Name]
		   ,[File_Type]
           ,[Created_Date]
           ,[Created_By]
           ,[Modified_Date]
           ,[Modified_By])
     VALUES
           ('JD_Code'
           ,'JD_Name'
           ,'JD_Description'
           ,Convert(varbinary(max),'D:\WF_Hackathon\CV_Sample.pdf')
           ,'CV_Sample.pdf'
           ,'pdf'
           ,getDate()
           ,'Akash'
           ,getDate()
           ,'Akash')
GO



CREATE TABLE [SmartHire].[Profile_Upload](
	[ID] [int] IDENTITY(101,1) NOT NULL,
	[JD_ID] [int] NOT NULL,
	[Resume_FILE] varbinary(max) NULL,
	[File_Name] VARCHAR(500) NULL,
	[File_Type] VARCHAR(20) NULL,
	[Expected_CTC] Integer null,
	[Experience] char(10) null,
	[Created_Date] [datetime] NOT NULL DEFAULT (getdate()),
	[Created_By] [varchar](255) NULL,
	[Modified_Date] [datetime] NULL,
	[Modified_By] [varchar](255) NULL,
 CONSTRAINT [PK_ID] PRIMARY KEY CLUSTERED
([ID] ASC)
)
GO



