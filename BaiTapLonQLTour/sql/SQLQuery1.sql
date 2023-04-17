INSERT INTO Tour 
values ('DL230323', N'Đà Lạt','2023-03-23 17:05:00', 3, 10, 5000000,(SELECT * FROM OPENROWSET(BULK N'T:\img\hinh1.jpg', SINGLE_BLOB) as img))
go

select * from Tour 

INSERT INTO Tour 
values ('DN230503', N'Đà Nẵng','2023-05-03 12:30:00', 4, 14, 7000000,(SELECT * FROM OPENROWSET(BULK N'T:\img\hinh2.jpg', SINGLE_BLOB) as img))
INSERT INTO Tour 
values ('TN230423', N'Tây Ninh','2023-04-23 07:30:00', 2, 9, 3000000,(SELECT * FROM OPENROWSET(BULK N'T:\img\hinh3.jpg', SINGLE_BLOB) as img))
INSERT INTO Tour 
values ('HN230727', N'Hà Nội','2023-07-23 08:00:00', 5, 10, 5500000,(SELECT * FROM OPENROWSET(BULK N'T:\img\hinh1.jpg', SINGLE_BLOB) as img))
INSERT INTO Tour 
values ('BG230511', N'Bắc Giang','2023-05-11 14:30:00', 6, 14, 9000000,(SELECT * FROM OPENROWSET(BULK N'T:\img\hinh2.jpg', SINGLE_BLOB) as img))
INSERT INTO Tour 
values ('VT230418', N'Vũng Tàu','2023-04-18 8:30:00', 2, 8, 3000000,(SELECT * FROM OPENROWSET(BULK N'T:\img\hinh3.jpg', SINGLE_BLOB) as img))
