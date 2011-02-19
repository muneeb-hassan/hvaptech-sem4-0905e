Create Database [SearchGift]
go
Use [SearchGift]
go
Create Table [Gifts]
(
	[ID] int,
	[Name] nvarchar(50),
	[Price] int,
	[Quantity] int
)
go
Insert Into [Gifts] Values (1, 'Balloon', 10, 500),
Insert Into [Gifts] Values (2, 'Flower', 15, 500),
Insert Into [Gifts] Values (3, 'Chocolate', 30, 0),
Insert Into [Gifts] Values (4, 'Toy', 25, 0),
Insert Into [Gifts] Values (5, 'Soft Toy', 45, 100)
