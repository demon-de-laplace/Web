USE [ninja]
GO

/****** Object:  Table [dbo].[paper]    Script Date: 10/30/2014 21:47:53 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[paper](
	[articleId] [int] NOT NULL,
	[title] [varchar](50) NOT NULL,
	[author] [varchar](50) NOT NULL,
	[type1] [varchar](50) NOT NULL,
	[type2] [varchar](50) NOT NULL,
	[userId] [int] NOT NULL,
	[keyWord] [varchar](50) NOT NULL,
	[content] [image] NOT NULL,
	[flag] [int] NOT NULL,
	[downloadTimes] [int] NOT NULL,
	[year] [int] NOT NULL,
	[month] [int] NULL,
	[authorNum] [int] NOT NULL,
	[score] [int] NOT NULL,
	[sci] [varchar](50) NULL,
	[ei] [varchar](50) NULL,
	[istp] [varchar](50) NULL,
	[effect] [varchar](50) NOT NULL,
	[name] [varchar](50) NOT NULL,
	[otherInfo] [varchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[articleId] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO

