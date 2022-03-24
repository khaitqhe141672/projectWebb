USE [master]
GO
/****** Object:  Database [shopdem]    Script Date: 4/16/2021 3:55:40 PM ******/
CREATE DATABASE [shopdem]
GO
USE [shopdem]
GO
/****** Object:  Table [dbo].[Account]    Script Date: 4/16/2021 3:55:40 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Account](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[Password] [nvarchar](50) NULL,
	[Email] [nvarchar](50) NULL,
	[account_detailid] [int] NULL,
	[role_id] [int] NULL,
	[status] [int] NULL,
	[Create_Date] [date] NULL CONSTRAINT [DF_Account_Create_Date]  DEFAULT (getdate()),
	[Active_Code] [nvarchar](50) NULL,
 CONSTRAINT [PK_Account] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[AccountDetail]    Script Date: 4/16/2021 3:55:40 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[AccountDetail](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](50) NOT NULL,
	[mobile] [nvarchar](11) NOT NULL,
	[address] [nvarchar](100) NOT NULL,
	[gender] [bit] NOT NULL,
 CONSTRAINT [PK_AccountDetail] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Admin]    Script Date: 4/16/2021 3:55:40 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Admin](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[UserName] [nvarchar](50) NOT NULL,
	[password] [nvarchar](50) NOT NULL,
	[Status] [bit] NOT NULL,
 CONSTRAINT [PK_Admin] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Brand]    Script Date: 4/16/2021 3:55:40 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Brand](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](200) NOT NULL,
	[Status] [int] NULL,
 CONSTRAINT [PK_Brand] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Category]    Script Date: 4/16/2021 3:55:40 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Category](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](200) NOT NULL,
	[Status] [int] NULL,
 CONSTRAINT [PK_Category] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Color]    Script Date: 4/16/2021 3:55:40 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Color](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[ColorName] [nvarchar](50) NOT NULL,
	[Note] [nvarchar](500) NULL,
 CONSTRAINT [PK_Color] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Customer]    Script Date: 4/16/2021 3:55:40 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Customer](
	[ID] [float] NOT NULL,
	[Name] [nvarchar](200) NOT NULL,
	[Phone] [nvarchar](20) NOT NULL,
	[Address] [nvarchar](200) NOT NULL,
	[Date] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_Customer] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Images]    Script Date: 4/16/2021 3:55:40 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Images](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[Product_ID] [int] NOT NULL,
	[ImageName] [nvarchar](500) NOT NULL,
 CONSTRAINT [PK_Images] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Material]    Script Date: 4/16/2021 3:55:40 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Material](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Material] [nvarchar](100) NOT NULL,
	[Note] [nvarchar](4000) NULL,
 CONSTRAINT [PK_Material] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[OrderDetail]    Script Date: 4/16/2021 3:55:40 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[OrderDetail](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[Order_ID] [int] NULL,
	[Product_ID] [int] NULL,
	[Product_Name] [nvarchar](500) NULL,
	[Product_Price] [float] NULL,
	[Quantity] [int] NULL,
 CONSTRAINT [PK_OrderDetail] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Orders]    Script Date: 4/16/2021 3:55:40 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Orders](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](500) NULL,
	[Mobile] [nvarchar](11) NULL,
	[Address] [nvarchar](500) NULL,
	[Total_money] [float] NULL,
	[Note] [nvarchar](1000) NULL,
	[Account_ID] [int] NULL,
	[Create_Date] [date] NULL CONSTRAINT [DF_Orders_Create_Date]  DEFAULT (getdate()),
	[Status] [int] NULL,
 CONSTRAINT [PK_Order] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Payment]    Script Date: 4/16/2021 3:55:40 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Payment](
	[CustomerID] [float] NOT NULL,
	[CheckNumber] [nchar](10) NOT NULL,
	[PaymentDate] [date] NOT NULL,
	[Amount] [float] NOT NULL,
 CONSTRAINT [PK_Payment] PRIMARY KEY CLUSTERED 
(
	[CustomerID] ASC,
	[CheckNumber] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Product]    Script Date: 4/16/2021 3:55:40 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Product](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[Brand_ID] [int] NOT NULL,
	[Category_ID] [int] NOT NULL,
	[Color_ID] [int] NULL,
	[Size_ID] [int] NULL,
	[Material_ID] [int] NULL,
	[Name] [nvarchar](100) NOT NULL,
	[Price] [float] NOT NULL,
	[Quantity] [int] NOT NULL,
	[Description] [nvarchar](500) NULL,
	[Image] [nvarchar](500) NULL,
	[Note] [nvarchar](500) NULL,
	[Status] [int] NULL,
 CONSTRAINT [PK_Product] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Role]    Script Date: 4/16/2021 3:55:40 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Role](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_Role] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Size]    Script Date: 4/16/2021 3:55:40 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Size](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[Size] [nvarchar](50) NOT NULL,
	[Note] [nvarchar](500) NULL,
 CONSTRAINT [PK_Size] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[StatusAccount]    Script Date: 4/16/2021 3:55:40 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[StatusAccount](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_StatusAccount] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[StatusOrder]    Script Date: 4/16/2021 3:55:40 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[StatusOrder](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_StatusOrder] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[StatusProduct]    Script Date: 4/16/2021 3:55:40 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[StatusProduct](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_Status] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET IDENTITY_INSERT [dbo].[Account] ON 

INSERT [dbo].[Account] ([id], [Password], [Email], [account_detailid], [role_id], [status], [Create_Date], [Active_Code]) VALUES (1, N'k123456', N'anhvu@gmail.com', 1, 2, 2, CAST(N'2021-03-21' AS Date), NULL)
INSERT [dbo].[Account] ([id], [Password], [Email], [account_detailid], [role_id], [status], [Create_Date], [Active_Code]) VALUES (2, N'123456', N'anhvu1@gmail.com', 2, 1, 2, CAST(N'2021-03-22' AS Date), NULL)
INSERT [dbo].[Account] ([id], [Password], [Email], [account_detailid], [role_id], [status], [Create_Date], [Active_Code]) VALUES (3, N'1234567', N'anh@gmail.com', 3, 2, 2, CAST(N'2021-03-25' AS Date), NULL)
INSERT [dbo].[Account] ([id], [Password], [Email], [account_detailid], [role_id], [status], [Create_Date], [Active_Code]) VALUES (5, N'k123456', N'minh@gmail.com', 5, 2, 2, CAST(N'2021-03-29' AS Date), NULL)
INSERT [dbo].[Account] ([id], [Password], [Email], [account_detailid], [role_id], [status], [Create_Date], [Active_Code]) VALUES (9, N'k123456', N'thanhhuyenvu2404@gmail.com', 9, 2, 2, CAST(N'2021-04-08' AS Date), N'aWyYfx')
INSERT [dbo].[Account] ([id], [Password], [Email], [account_detailid], [role_id], [status], [Create_Date], [Active_Code]) VALUES (10, N'k123456', N'khaitqhe141672@fpt.edu.vn', 10, 2, 1, CAST(N'2021-04-14' AS Date), N'RXALam')
SET IDENTITY_INSERT [dbo].[Account] OFF
SET IDENTITY_INSERT [dbo].[AccountDetail] ON 

INSERT [dbo].[AccountDetail] ([id], [name], [mobile], [address], [gender]) VALUES (1, N'ngoc anh', N'98877965', N'gia lam', 0)
INSERT [dbo].[AccountDetail] ([id], [name], [mobile], [address], [gender]) VALUES (2, N'sadd', N'0981234554', N'Æ°ed', 0)
INSERT [dbo].[AccountDetail] ([id], [name], [mobile], [address], [gender]) VALUES (3, N'ddd', N'02155', N'laman', 1)
INSERT [dbo].[AccountDetail] ([id], [name], [mobile], [address], [gender]) VALUES (5, N'Mr C', N'0921282198', N'hanoi', 1)
INSERT [dbo].[AccountDetail] ([id], [name], [mobile], [address], [gender]) VALUES (9, N'khai', N'0921282198', N'PhuXuyenn', 0)
INSERT [dbo].[AccountDetail] ([id], [name], [mobile], [address], [gender]) VALUES (10, N'tranquang khai', N'0921282198', N'hanoi', 1)
SET IDENTITY_INSERT [dbo].[AccountDetail] OFF
SET IDENTITY_INSERT [dbo].[Admin] ON 

INSERT [dbo].[Admin] ([ID], [UserName], [password], [Status]) VALUES (1, N'abc', N'chonhi', 1)
INSERT [dbo].[Admin] ([ID], [UserName], [password], [Status]) VALUES (2, N'abc', N'chonhi', 1)
SET IDENTITY_INSERT [dbo].[Admin] OFF
SET IDENTITY_INSERT [dbo].[Brand] ON 

INSERT [dbo].[Brand] ([ID], [Name], [Status]) VALUES (2, N'Everon', 1)
INSERT [dbo].[Brand] ([ID], [Name], [Status]) VALUES (4, N'Hanvico', 2)
INSERT [dbo].[Brand] ([ID], [Name], [Status]) VALUES (5, N'Lotus', NULL)
INSERT [dbo].[Brand] ([ID], [Name], [Status]) VALUES (6, N'Lucyty', NULL)
SET IDENTITY_INSERT [dbo].[Brand] OFF
SET IDENTITY_INSERT [dbo].[Category] ON 

INSERT [dbo].[Category] ([ID], [Name], [Status]) VALUES (5, N'Cao cấp', NULL)
INSERT [dbo].[Category] ([ID], [Name], [Status]) VALUES (6, N'Trung bình', NULL)
SET IDENTITY_INSERT [dbo].[Category] OFF
SET IDENTITY_INSERT [dbo].[Color] ON 

INSERT [dbo].[Color] ([ID], [ColorName], [Note]) VALUES (4, N'Hồng', NULL)
INSERT [dbo].[Color] ([ID], [ColorName], [Note]) VALUES (5, N'Vàng', NULL)
INSERT [dbo].[Color] ([ID], [ColorName], [Note]) VALUES (6, N'Đỏ', NULL)
INSERT [dbo].[Color] ([ID], [ColorName], [Note]) VALUES (7, N'Tím', NULL)
INSERT [dbo].[Color] ([ID], [ColorName], [Note]) VALUES (8, N'Xanh', NULL)
SET IDENTITY_INSERT [dbo].[Color] OFF
INSERT [dbo].[Customer] ([ID], [Name], [Phone], [Address], [Date]) VALUES (1, N'dssd', N'2', N'4', N'ds')
SET IDENTITY_INSERT [dbo].[Material] ON 

INSERT [dbo].[Material] ([Id], [Material], [Note]) VALUES (2, N'Cottom Cao Cấp', NULL)
INSERT [dbo].[Material] ([Id], [Material], [Note]) VALUES (3, N'Tencal', NULL)
INSERT [dbo].[Material] ([Id], [Material], [Note]) VALUES (4, N'Statin', NULL)
INSERT [dbo].[Material] ([Id], [Material], [Note]) VALUES (5, N'Modal', NULL)
INSERT [dbo].[Material] ([Id], [Material], [Note]) VALUES (6, N'Tencel Dệt Statin', NULL)
SET IDENTITY_INSERT [dbo].[Material] OFF
SET IDENTITY_INSERT [dbo].[OrderDetail] ON 

INSERT [dbo].[OrderDetail] ([ID], [Order_ID], [Product_ID], [Product_Name], [Product_Price], [Quantity]) VALUES (5, 10, 14, N'BỘ CHĂN GA ASM-20102', 22230000, 1)
INSERT [dbo].[OrderDetail] ([ID], [Order_ID], [Product_ID], [Product_Name], [Product_Price], [Quantity]) VALUES (6, 12, 7, N'BỘ CHĂN GA EVERON ASM 19104', 16750000, 1)
INSERT [dbo].[OrderDetail] ([ID], [Order_ID], [Product_ID], [Product_Name], [Product_Price], [Quantity]) VALUES (7, 12, 14, N'BỘ CHĂN GA ASM-20102', 22230000, 1)
INSERT [dbo].[OrderDetail] ([ID], [Order_ID], [Product_ID], [Product_Name], [Product_Price], [Quantity]) VALUES (8, 13, 21, N'BỘ CHĂN GA EVERON ASM 19105', 14280000, 1)
INSERT [dbo].[OrderDetail] ([ID], [Order_ID], [Product_ID], [Product_Name], [Product_Price], [Quantity]) VALUES (9, 14, 6, N'BỘ CHĂN GA EVERON ASM 19106', 12610000, 1)
INSERT [dbo].[OrderDetail] ([ID], [Order_ID], [Product_ID], [Product_Name], [Product_Price], [Quantity]) VALUES (10, 15, 22, N'BỘ CHĂN GA ASM-20104', 25440000, 1)
INSERT [dbo].[OrderDetail] ([ID], [Order_ID], [Product_ID], [Product_Name], [Product_Price], [Quantity]) VALUES (11, 15, 24, N'
BỘ CHĂN GA GỐI EVERON AS 1804', 12546000, 2)
INSERT [dbo].[OrderDetail] ([ID], [Order_ID], [Product_ID], [Product_Name], [Product_Price], [Quantity]) VALUES (12, 15, 25, N'BỘ CHĂN GA ASM-20105', 12265000, 1)
INSERT [dbo].[OrderDetail] ([ID], [Order_ID], [Product_ID], [Product_Name], [Product_Price], [Quantity]) VALUES (13, 15, 21, N'BỘ CHĂN GA EVERON ASM 19105', 14280000, 1)
INSERT [dbo].[OrderDetail] ([ID], [Order_ID], [Product_ID], [Product_Name], [Product_Price], [Quantity]) VALUES (14, 16, 21, N'BỘ CHĂN GA EVERON ASM 19105', 14280000, 1)
INSERT [dbo].[OrderDetail] ([ID], [Order_ID], [Product_ID], [Product_Name], [Product_Price], [Quantity]) VALUES (15, 16, 22, N'BỘ CHĂN GA ASM-20104', 25440000, 1)
INSERT [dbo].[OrderDetail] ([ID], [Order_ID], [Product_ID], [Product_Name], [Product_Price], [Quantity]) VALUES (16, 17, 6, N'BỘ CHĂN GA EVERON ASM 19106', 12610000, 2)
SET IDENTITY_INSERT [dbo].[OrderDetail] OFF
SET IDENTITY_INSERT [dbo].[Orders] ON 

INSERT [dbo].[Orders] ([ID], [Name], [Mobile], [Address], [Total_money], [Note], [Account_ID], [Create_Date], [Status]) VALUES (10, N'ngocanh', N'0921282198', N'a', 22230000, N'a', 1, CAST(N'2021-03-25' AS Date), 3)
INSERT [dbo].[Orders] ([ID], [Name], [Mobile], [Address], [Total_money], [Note], [Account_ID], [Create_Date], [Status]) VALUES (12, N'ngocanh', N'0921282198', N'hanoi', 38980000, N'ship nhanh', 1, CAST(N'2021-03-26' AS Date), 3)
INSERT [dbo].[Orders] ([ID], [Name], [Mobile], [Address], [Total_money], [Note], [Account_ID], [Create_Date], [Status]) VALUES (13, N'ngocanh', N'0921282198', N'hanoi', 14280000, N'luon va nhanh', 1, CAST(N'2021-03-26' AS Date), 4)
INSERT [dbo].[Orders] ([ID], [Name], [Mobile], [Address], [Total_money], [Note], [Account_ID], [Create_Date], [Status]) VALUES (14, N'ngocanh', N'0921282198', N'gialam', 12610000, N'ship nhanh', 4, CAST(N'2021-03-26' AS Date), 1)
INSERT [dbo].[Orders] ([ID], [Name], [Mobile], [Address], [Total_money], [Note], [Account_ID], [Create_Date], [Status]) VALUES (15, N'tranquang khai', N'0921282198', N'hanoi', 77077000, N'luon luon', 1, CAST(N'2021-03-26' AS Date), 3)
INSERT [dbo].[Orders] ([ID], [Name], [Mobile], [Address], [Total_money], [Note], [Account_ID], [Create_Date], [Status]) VALUES (16, N'Mr C', N'0921282198', N'NinhBinh', 39720000, N'fast', 1, CAST(N'2021-03-26' AS Date), 3)
INSERT [dbo].[Orders] ([ID], [Name], [Mobile], [Address], [Total_money], [Note], [Account_ID], [Create_Date], [Status]) VALUES (17, N'anh', N'0988770431', N'ha noi', 25220000, N'mua', 1, CAST(N'2021-03-26' AS Date), 3)
SET IDENTITY_INSERT [dbo].[Orders] OFF
SET IDENTITY_INSERT [dbo].[Product] ON 

INSERT [dbo].[Product] ([ID], [Brand_ID], [Category_ID], [Color_ID], [Size_ID], [Material_ID], [Name], [Price], [Quantity], [Description], [Image], [Note], [Status]) VALUES (6, 5, 5, 4, 2, 2, N'BỘ CHĂN GA EVERON ASM 19106', 12610000, 5, N'Bộ chăn ga gối ASM 19106 lấy màu hồng làm tone nền chủ đạo, kết hợp họa tiết theo phong cách cổ điển châu Âu điểm xuyết ở phần đầu và cuối chăn ga, tạo nên vẻ đẹp cân xứng, hài hòa. Ngoài ra, nếu bạn là người mệnh Thổ, cũng đừng quên màu hồng chính là lựa chọn sáng suốt và đừng bỏ lỡ nhé.', N'asm19106_ok__5e3a6b88bf15458bb77b15c10a994ec2_master.jpg', NULL, 1)
INSERT [dbo].[Product] ([ID], [Brand_ID], [Category_ID], [Color_ID], [Size_ID], [Material_ID], [Name], [Price], [Quantity], [Description], [Image], [Note], [Status]) VALUES (7, 6, 6, 5, 3, 3, N'BỘ CHĂN GA EVERON ASM 19104', 16750000, 5, N'Màu trắng luôn là màu sắc được yêu thích của thế giới. Một sắc trắng tinh khôi, một sắc trắng sang trọng lại nền nã, dịu dàng. Không có gì có thể làm phai mờ vẻ đẹp tuyệt phẩm của sắc trắng. Trên nền vải trắng bóng mịn là những chùm hoa thêu đồng màu, điểm xuyết bằng nhụy hoa kim tuyến, tạo hộ sáng cho họa tiết trên sản phẩm. ASM20102 là sự kết hợp ăn ý của sắc trắng và họa tiết hoa thêu phong phú nhẹ nhàng, tạo ra sự thoải mái những bắt mắt vô cùng cho người dùng.', N'ASM20102-FILEminimizer.jpg', NULL, 1)
INSERT [dbo].[Product] ([ID], [Brand_ID], [Category_ID], [Color_ID], [Size_ID], [Material_ID], [Name], [Price], [Quantity], [Description], [Image], [Note], [Status]) VALUES (14, 6, 6, 6, 4, 3, N'BỘ CHĂN GA ASM-20102', 22230000, 5, N'1Bộ chăn ga cao cấp thêu những bông hoa và họa tiết sắc nét, bố cục rõ ràng, chặt chẽ trên nền mầu vải nhẹ nhàng và trang nhã, rât phù hợp với phòng ngủ sang trọng của bạn.', N'ASM20103-FILEminimizer.jpg', NULL, 1)
INSERT [dbo].[Product] ([ID], [Brand_ID], [Category_ID], [Color_ID], [Size_ID], [Material_ID], [Name], [Price], [Quantity], [Description], [Image], [Note], [Status]) VALUES (16, 6, 6, 7, 3, 2, N'BỘ CHĂN GA ASM-20101', 35436500, 5, N'Điểm nhấn của sản phẩm này là họa tiết những bông hoa to bản, nhỏ bé và những cành lá kết hợp đan xen chạy dọc hai bên thân và ở giữa mang đến cảm nhận có sự hòa quyện với thiên nhiên, thật gần gũi, thật dễ chịu. Chỉ cần tưởng tượng được chìm sâu vào giấc ngủ tại Bộ chăn ga đệm này thôi là chúng ta đã cảm nhận được những giấc mơ thật đẹp thật êm ái mà không cần phải thoát ra.', N'Bộ-chăn-ga-gối-Everon-ASM-19104.jpg', NULL, 1)
INSERT [dbo].[Product] ([ID], [Brand_ID], [Category_ID], [Color_ID], [Size_ID], [Material_ID], [Name], [Price], [Quantity], [Description], [Image], [Note], [Status]) VALUES (21, 2, 5, 5, 4, 3, N'BỘ CHĂN GA EVERON ASM 19105', 14280000, 5, N'Theo người Ý, màu xanh lam là biểu tượng của tầng lớp quí tộc. Khi sử dụng nó cho phòng ngủ của bạn, màu xanh lam tạo ra một không gian mạnh mẽ và có chút quý phái cùng bí ẩn. Màu xanh lam của ASM 20101 chính là một màu như vậy. Kết hợp với sắc xanh trầm mặc là cả 1 khu vườn được thêu tinh tế, tỉ mỉ từ những bông hoa nhỏ nhất tạo cho không gian sang trọng thêm phần sống động.', N'ASM20101-FILEminimizer.jpg', NULL, 1)
INSERT [dbo].[Product] ([ID], [Brand_ID], [Category_ID], [Color_ID], [Size_ID], [Material_ID], [Name], [Price], [Quantity], [Description], [Image], [Note], [Status]) VALUES (22, 4, 6, 4, 4, 2, N'BỘ CHĂN GA ASM-20104', 25440000, 5, N'Đôi khi sự đơn giản là nét riêng của bạn tuy nhiên bạn có thể chọn sự đơn giản nhàm chán hay sự đơn giản mang đến đẳng cấp. Việc chọn mua một Bộ chăn ga đệm cũng có thể đánh giá điều này và với Artemis ASM 19109 bạn sẽ có một Bộ chăn ga đệm đơn giản nhưng cực đẳng cấp và ấn tượng.

', N'Bộ-chăn-ga-gối-Everon-ASM-19109-1.jpg', NULL, 1)
INSERT [dbo].[Product] ([ID], [Brand_ID], [Category_ID], [Color_ID], [Size_ID], [Material_ID], [Name], [Price], [Quantity], [Description], [Image], [Note], [Status]) VALUES (24, 5, 5, 4, 4, 5, N'
BỘ CHĂN GA GỐI EVERON AS 1804', 12546000, 5, N'Chất liệu vải Moc60 trên nền vải đỏ hồng ánh tím đậm,họa tiết thêu cổ điển sang trọng thêu chỉ trắng và chỉ nhũ ghi bạc để điểm xuyết nổi bật bộ chăn ga,làm điểm nhấn cho bộ chăn ga thêm phần luxury.', N'ASM20104-FILEminimizer.jpg', NULL, 1)
INSERT [dbo].[Product] ([ID], [Brand_ID], [Category_ID], [Color_ID], [Size_ID], [Material_ID], [Name], [Price], [Quantity], [Description], [Image], [Note], [Status]) VALUES (25, 6, 5, 7, 4, 5, N'BỘ CHĂN GA ASM-20105', 12265000, 5, N'Hồng nhẹ là gam màu chủ đạo trên nền chăn và gối được thêu điểm những bông hoa đang đua nhau khoe sắc. Đặc biệt chất liệu vải 100% Modal (bột gỗ sồi tự nhiên) chính là điểm ưu việt nhất của bộ chăn ga Artemis Asm 19103 này. Nó mang đến một độ mềm mại lý tưởng cùng khả năng thấm hút tốt, mang đến cho bạn giấc ngủ ngon cùng những giấc mơ đẹp.', N'Bộ-chăn-ga-gối-Everon-ASM-19103.jpg', NULL, 1)
INSERT [dbo].[Product] ([ID], [Brand_ID], [Category_ID], [Color_ID], [Size_ID], [Material_ID], [Name], [Price], [Quantity], [Description], [Image], [Note], [Status]) VALUES (26, 5, 5, 4, 2, 6, N'BỘ CHĂN GA EVERON APT-20152', 9168900, 5, N'Khả năng hút ẩm xuất sắc: chạm tay vào bề mặt vải tencel mang lại cảm giác mát lạnh, hiện chất liệu tencel được úng dụng nhiều trong sản xuất chăn ga gối đệm. Điều này mang đến lợi ích tuyệt vời, tencel giúp mồ hôi và độ ẩm không khí được hút vào trong sợi vải rồi nhanh chóng chuyển hóa và tỏa vào không khí xung quanh để loại bỏ tình trạng bí bách và đẹm lại cảm giác thoáng mát nhất cho người dùng.', N'Bộ-chăn-ga-gối-Everon-ASM19107-1.jpg', NULL, 1)
INSERT [dbo].[Product] ([ID], [Brand_ID], [Category_ID], [Color_ID], [Size_ID], [Material_ID], [Name], [Price], [Quantity], [Description], [Image], [Note], [Status]) VALUES (27, 2, 6, 6, 4, 6, N'BỘ CHĂN GA EVERON ASM 19101', 5000000, 5, N'Màu vàng là màu sắc không thể thiếu trong những bộ sưu tập chăn ga gối Everon trong những năm gần đây. Gam màu này luôn được nhiều người quan tâm và sử dụng để trang trí cho những căn phòng có không gian rộng với thiết kế nội thất dát vàng sang trọng. Bộ chăn ga cao cấp Artemis ASM 19107 là sự lựa chọn hoàn hảo cho những người muốn thể hiện sự quyền quý cao sang trong phòng ngủ của mình.', N'AS-1801-OK.jpg', NULL, 1)
INSERT [dbo].[Product] ([ID], [Brand_ID], [Category_ID], [Color_ID], [Size_ID], [Material_ID], [Name], [Price], [Quantity], [Description], [Image], [Note], [Status]) VALUES (29, 4, 5, 6, 4, 4, N'BỘ CHĂN GA EVERON APT-20151', 6085000, 5, N'Hồng nhẹ là gam màu chủ đạo trên nền chăn và gối được thêu điểm những bông hoa đang đua nhau khoe sắc. Đặc biệt chất liệu vải 100% Modal (bột gỗ sồi tự nhiên) chính là điểm ưu việt nhất của bộ chăn ga Artemis Asm 19103 này. Nó mang đến một độ mềm mại lý tưởng cùng khả năng thấm hút tốt, mang đến cho bạn giấc ngủ ngon cùng những giấc mơ đẹp.', N'APT20152-FILEminimizer.jpg', NULL, 1)
INSERT [dbo].[Product] ([ID], [Brand_ID], [Category_ID], [Color_ID], [Size_ID], [Material_ID], [Name], [Price], [Quantity], [Description], [Image], [Note], [Status]) VALUES (31, 5, 6, 5, 2, 3, N'
BỘ CHĂN GA EVERON ASM 19109', 1476000, 5, N'Bộ chăn ga cao cấp Artemis ASM 19101 thuộc bộ sưu tập mới nhất năm 2019 với gam chủ đạo màu xanh ngọc nó là màu của bầu trời bao la, màu của đại dương sâu thẳm, nó tạo cho ta cảm giác rộng lớn mênh mông. Màu xanh ngọc còn thể hiện cho một tình yêu tinh khiết, chung thủy & cuộc sống hôn nhân thanh bình.', N'Bộ-chăn-ga-gối-Everon-ASM19101.jpg', NULL, 1)
SET IDENTITY_INSERT [dbo].[Product] OFF
SET IDENTITY_INSERT [dbo].[Size] ON 

INSERT [dbo].[Size] ([ID], [Size], [Note]) VALUES (2, N'FreeSize', NULL)
INSERT [dbo].[Size] ([ID], [Size], [Note]) VALUES (3, N'120x190', NULL)
INSERT [dbo].[Size] ([ID], [Size], [Note]) VALUES (4, N'150x190', NULL)
INSERT [dbo].[Size] ([ID], [Size], [Note]) VALUES (5, N'160x190', NULL)
INSERT [dbo].[Size] ([ID], [Size], [Note]) VALUES (6, N'180x190', NULL)
SET IDENTITY_INSERT [dbo].[Size] OFF
SET IDENTITY_INSERT [dbo].[StatusAccount] ON 

INSERT [dbo].[StatusAccount] ([id], [name]) VALUES (1, N'Đang hoạt động')
INSERT [dbo].[StatusAccount] ([id], [name]) VALUES (2, N'Đang chờ xét')
INSERT [dbo].[StatusAccount] ([id], [name]) VALUES (3, N'Ngừng hoạt động')
SET IDENTITY_INSERT [dbo].[StatusAccount] OFF
SET IDENTITY_INSERT [dbo].[StatusOrder] ON 

INSERT [dbo].[StatusOrder] ([id], [name]) VALUES (1, N'Đang xử lý')
INSERT [dbo].[StatusOrder] ([id], [name]) VALUES (2, N'Đang giao hàng')
INSERT [dbo].[StatusOrder] ([id], [name]) VALUES (3, N'Giao hàng thành công')
INSERT [dbo].[StatusOrder] ([id], [name]) VALUES (4, N'Đã hủy hàng')
SET IDENTITY_INSERT [dbo].[StatusOrder] OFF
SET IDENTITY_INSERT [dbo].[StatusProduct] ON 

INSERT [dbo].[StatusProduct] ([id], [name]) VALUES (1, N'Còn hàng')
INSERT [dbo].[StatusProduct] ([id], [name]) VALUES (2, N'Giảm giá')
INSERT [dbo].[StatusProduct] ([id], [name]) VALUES (3, N'Hết hàng')
INSERT [dbo].[StatusProduct] ([id], [name]) VALUES (4, N'Ngừng kinh doanh')
SET IDENTITY_INSERT [dbo].[StatusProduct] OFF
ALTER TABLE [dbo].[Account]  WITH CHECK ADD  CONSTRAINT [FK_Account_StatusAccount] FOREIGN KEY([status])
REFERENCES [dbo].[StatusAccount] ([id])
GO
ALTER TABLE [dbo].[Account] CHECK CONSTRAINT [FK_Account_StatusAccount]
GO
ALTER TABLE [dbo].[Images]  WITH CHECK ADD  CONSTRAINT [FK_Images_Product] FOREIGN KEY([Product_ID])
REFERENCES [dbo].[Product] ([ID])
GO
ALTER TABLE [dbo].[Images] CHECK CONSTRAINT [FK_Images_Product]
GO
ALTER TABLE [dbo].[OrderDetail]  WITH CHECK ADD  CONSTRAINT [FK_OrderDetail_Order] FOREIGN KEY([Order_ID])
REFERENCES [dbo].[Orders] ([ID])
GO
ALTER TABLE [dbo].[OrderDetail] CHECK CONSTRAINT [FK_OrderDetail_Order]
GO
ALTER TABLE [dbo].[Payment]  WITH CHECK ADD  CONSTRAINT [FK_Payment_Customer] FOREIGN KEY([CustomerID])
REFERENCES [dbo].[Customer] ([ID])
GO
ALTER TABLE [dbo].[Payment] CHECK CONSTRAINT [FK_Payment_Customer]
GO
ALTER TABLE [dbo].[Product]  WITH CHECK ADD  CONSTRAINT [FK_Product_Brand] FOREIGN KEY([Brand_ID])
REFERENCES [dbo].[Brand] ([ID])
GO
ALTER TABLE [dbo].[Product] CHECK CONSTRAINT [FK_Product_Brand]
GO
ALTER TABLE [dbo].[Product]  WITH CHECK ADD  CONSTRAINT [FK_Product_Category] FOREIGN KEY([Category_ID])
REFERENCES [dbo].[Category] ([ID])
GO
ALTER TABLE [dbo].[Product] CHECK CONSTRAINT [FK_Product_Category]
GO
ALTER TABLE [dbo].[Product]  WITH CHECK ADD  CONSTRAINT [FK_Product_Color] FOREIGN KEY([Color_ID])
REFERENCES [dbo].[Color] ([ID])
GO
ALTER TABLE [dbo].[Product] CHECK CONSTRAINT [FK_Product_Color]
GO
ALTER TABLE [dbo].[Product]  WITH CHECK ADD  CONSTRAINT [FK_Product_Material] FOREIGN KEY([Material_ID])
REFERENCES [dbo].[Material] ([Id])
GO
ALTER TABLE [dbo].[Product] CHECK CONSTRAINT [FK_Product_Material]
GO
ALTER TABLE [dbo].[Product]  WITH CHECK ADD  CONSTRAINT [FK_Product_Size] FOREIGN KEY([Size_ID])
REFERENCES [dbo].[Size] ([ID])
GO
ALTER TABLE [dbo].[Product] CHECK CONSTRAINT [FK_Product_Size]
GO
USE [master]
GO
ALTER DATABASE [shopdem] SET  READ_WRITE 
GO
