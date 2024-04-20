use JAVA_DOAN_QUANLYCUAHANGXE
go

-- Thêm dữ liệu cho bảng CHI NHÁNH
INSERT INTO CHINHANH (maChiNhanh, tenChiNhanh, diaChi, soDienThoai)
VALUES ('CNHN', N'Chi nhánh Hà Nội', N'Số 25, Đường Lê Lợi, Quận Hai Bà Trưng, Hà Nội', '0674536125'),
       ('CNHCM', N'Chi nhánh Hồ Chí Minh', N'456 Đường B, Quận 2, TP.HCM', '0387562341'),
       ('CNHUE', N'Chi nhánh Huế', N'555 Đường Hà Khánh, Thành phố Huế', '0784657389'),
       ('CNCT', N'Chi nhánh Cần Thơ', N'222 Đường Trần Phú, Quận Ninh Kiều, Cần Thơ', '0697812345'),
       ('CNDN', N'Chi nhánh Đà Nẵng', N' 789 Đường 2/9, Quận Hải Châu, Đà Nẵng', '0794532165');
go

-- Thêm dữ liệu cho bảng NHÂN VIÊN
INSERT INTO NHANVIEN (maNhanVien, hoTenNhanVien, CCCD, ngaySinh, gioiTinh, diaChi, soDienThoai, chucVu, maChiNhanh, hinhAnh)
VALUES ('NVHN001', N'Nguyễn Văn An', '123456289012', '1990-01-15', N'Nam', N'123 Đường Lê Lợi, Hà Nội', '0932345678', N'Quản lý', 'CNHN', ''),
       ('NVHN002', N'Trần Thị Bình', '234565890123', '1992-03-20', N'Nữ', N'456 Đường Hà Trung, Hà Nội', '0982654321', N'Nhân viên thu ngân', 'CNHN', ''),
       ('NVHN003', N'Lê Văn Cường', '345612901234', '1995-05-10', N'Nam', N'789 Đường Lý Thường Kiệt, Hà Nội', '0911234567', N'Nhân viên bảo dưỡng', 'CNHN', ''),
       ('NVHN004', N'Phạm Thị Dương', '456789322345', '1988-07-05', N'Nữ', N'101 Đường Trần Phú, Hà Nội', '0976543310', N'Nhân viên thu ngân', 'CNHN', ''),
       ('NVHN005', N'Hoàng Văn Em', '567890144456', '1993-09-25', N'Nam', N'222 Đường Đống Đa, Hà Nội', '0932108876', N'Nhân viên thu ngân', 'CNHN', ''),
       ('NVHN006', N'Nguyễn Thị Dung', '678932234567', '1997-11-30', N'Nữ', N'333 Đường Nguyễn Du, Hà Nội', '0915432101', N'Nhân viên bảo dưỡng', 'CNHN', ''),
       ('NVHN007', N'Trần Văn Giang', '789012343278', '1994-02-14', N'Nam', N'444 Đường Bà Triệu, Hà Nội', '0921498765', N'Nhân viên bảo dưỡng', 'CNHN', ''),

	   ('NVHCM001', N'Lê Thị Hương', '123456712012', '1991-04-20', N'Nữ', N'123 Đường Lê Lai, Hồ Chí Minh', '09123325678', N'Quản lý', 'CNHCM', ''),
       ('NVHCM002', N'Phạm Văn Hoàng', '234563490123', '1989-06-15', N'Nam', N'456 Đường Nam Kỳ Khởi Nghĩa, Hồ Chí Minh', '0987321321', N'Nhân viên thu ngân', 'CNHCM', ''),
       ('NVHCM003', N'Nguyễn Thị Khanh', '345678910234', '1990-08-10', N'Nữ', N'789 Đường Võ Văn Tần, Hồ Chí Minh', '0901233567', N'Nhân viên thu ngân', 'CNHCM', ''),
       ('NVHCM004', N'Nguyễn Minh Khánh', '456909012345', '1996-10-05', N'Nam', N'101 Đường Cách Mạng Tháng Tám, Hồ Chí Minh', '0976543210', N'Nhân viên thu ngân', 'CNHCM', ''),
       ('NVHCM005', N'Lê Thị Linh', '567890893456', '1987-12-25', N'Nữ', N'222 Đường Lê Duẩn, Hồ Chí Minh', '0932109446', N'Nhân viên bảo dưỡng', 'CNHCM', ''),
       ('NVHCM006', N'Hoàng Văn Minh', '678972234567', '1992-02-10', N'Nam', N'333 Đường Lý Thường Kiệt, Hồ Chí Minh', '0965452101', N'Nhân viên bảo dưỡng', 'CNHCM', ''),
       ('NVHCM007', N'Trần Thị Ngân', '789012323278', '1993-05-14', N'Nữ', N'444 Đường Nguyễn Đình Chính, Hồ Chí Minh', '0921033765', N'Nhân viên bảo dưỡng', 'CNHCM', ''),

	   ('NVCT001', N'Nguyễn Thành Nhân', '123451489012', '1991-03-20', N'Nam', N'123 Đường Hòa Bình, Cần Thơ', '0912343278', N'Quản lý', 'CNCT', ''),
       ('NVCT002', N'Trần Thị Phương', '234567881123', '1989-05-15', N'Nữ', N'456 Đường Lê Lai, Cần Thơ', '0987654231', N'Nhân viên thu ngân', 'CNCT', ''),
       ('NVCT003', N'Lê Văn Quang', '345678011234', '1990-07-10', N'Nam', N'789 Đường Võ Văn Kiệt, Cần Thơ', '0901674567', N'Nhân viên thu ngân', 'CNCT', ''),
       ('NVCT004', N'Phạm Thị Quỳnh', '456229012345', '1996-09-05', N'Nữ', N'101 Đường 30/4, Cần Thơ', '0976501210', N'Nhân viên thu ngân', 'CNCT', ''),
       ('NVCT005', N'Hoàng Văn Sáng', '569990123456', '1988-11-25', N'Nam', N'222 Đường Cách Mạng Tháng Tám, Cần Thơ', '0932108976', N'Nhân viên bảo dưỡng', 'CNCT', ''),
       ('NVCT006', N'Nguyễn Thị Thu', '676601234567', '1992-01-10', N'Nữ', N'333 Đường Nguyễn Văn Linh, Cần Thơ', '0965434501', N'Nhân viên bảo dưỡng', 'CNCT', ''),
       ('NVCT007', N'Trần Văn Nam', '789099345678', '1994-04-14', N'Nam', N'444 Đường 3/2, Cần Thơ', '0921198765', N'Nhân viên bảo dưỡng', 'CNCT', ''),

	   ('NVDN001', N'Trần Đinh Xu', '123453089012', '1991-02-15', N'Nam', N'123 Đường Bạch Đằng, Đà Nẵng', '0916845678', N'Quản lý', 'CNDN', ''),
       ('NVDN002', N'Nguyễn Thị Yến', '234590810123', '1989-04-20', N'Nữ', N'456 Đường Lê Duẩn, Đà Nẵng', '0982954321', N'Nhân viên thu ngân', 'CNDN', ''),
       ('NVDN003', N'Phạm Văn Đồng', '345636901234', '1990-06-10', N'Nam', N'789 Đường 2/9, Đà Nẵng', '0901294567', N'Nhân viên thu ngân', 'CNDN', ''),
       ('NVDN004', N'Trần Thị Uyên', '576789012345', '1996-08-05', N'Nữ', N'101 Đường Hùng Vương, Đà Nẵng', '0901543210', N'Nhân viên thu ngân', 'CNDN', ''),
       ('NVDN005', N'Lê Thị Lan', '567899123456', '1988-10-25', N'Nữ', N'222 Đường Phan Đăng Lưu, Đà Nẵng', '0932148876', N'Nhân viên bảo dưỡng', 'CNDN', ''),
       ('NVDN006', N'Hoàng Văn Mạnh', '638901234567', '1992-12-10', N'Nam', N'333 Đường Hồ Nghinh, Đà Nẵng', '0969132101', N'Nhân viên bảo dưỡng', 'CNDN', ''),
       ('NVDN007', N'Nguyễn Băng Hà', '789012345678', '1994-03-14', N'Nam', N'444 Đường 3/2, Đà Nẵng', '0921092065', N'Nhân viên bảo dưỡng', 'CNDN', ''),

	   ('NVHUE001', N'Lê Văn Hưng', '123456789012', '1991-05-20', N'Nam', N'123 Đường Nguyễn Huệ, Huế', '0332345678', N'Quản lý', 'CNHUE', ''),
       ('NVHUE002', N'Trần Thị Kim Thoa', '234567890123', '1989-07-15', N'Nữ', N'456 Đường 2/9, Huế', '0987654321', N'Nhân viên thu ngân', 'CNHUE', ''),
       ('NVHUE003', N'Nguyễn Văn Luyện', '345678901234', '1990-09-10', N'Nam', N'789 Đường Điện Biên Phủ, Huế', '0976234567', N'Nhân viên thu ngân', 'CNHUE', ''),
       ('NVHUE004', N'Văn Thị Ngọc', '456789012345', '1996-01-22', N'Nữ', N'675 Đường Nguyễn Tất Thành, Huế', '0912346729', N'Nhân viên thu ngân', 'CNHUE', ''),
	   ('NVHUE005', N'Hoàng Văn Thụ', '567890123456', '1988-01-25', N'Nam', N'222 Đường Trường Chinh, Huế', '0932109776', N'Nhân viên bảo dưỡng', 'CNHUE', ''),
       ('NVHUE006', N'Lê Thị Oanh', '678901234567', '1992-03-10', N'Nữ', N'333 Đường Nguyễn Tất Thành, Huế', '0966632101', N'Nhân viên bảo dưỡng', 'CNHUE', ''),
       ('NVHUE007', N'Nguyễn Văn Phúc', '789021345678', '1994-06-14', N'Nam', N'444 Đường Đống Đa, Huế', '0921098265', N'Nhân viên bảo dưỡng', 'CNHUE', '');
go

-- Thêm dữ liệu cho bảng TÀI KHOẢN
--INSERT INTO TAIKHOAN (maNhanVien, tenDangNhap, matKhau)
--VALUES ('1', '1', 'NVHN001'),
--	   ('2', '1', 'NVHN002'),
--	   ('3', '1', 'NVHN003'),
--	   ('4', '1', 'NVHN004'),
--	   ('5', '1', 'NVHN005'),
--	   ('6', '1', 'NVHN006'),
--	   ('7', '1', 'NVHN007');
go
-- Thêm dữ liệu cho bảng NHÀ CUNG CẤP
INSERT INTO NHACUNGCAP (maNhaCungCap, tenNhaCungCap, diaChi, soDienThoai)
VALUES ('NCC001', N'Công ty Toyota Việt Nam', N'123 Đường X, Quận Y, TP.HCM', '0123456789'),
	   ('NCC002', N'Công ty Honda Việt Nam', N'456 Đường P, Quận Q, TP.HCM', '0987654321'),
       ('NCC003', N'Công ty Ford Việt Nam', N'789 Đường R, Quận S, TP.HCM', '0321654987'),
       ('NCC004', N'Công ty Nissan Việt Nam', N'101 Đường T, Quận U, TP.HCM', '0765432198'),
       ('NCC005', N'Công ty Hyundai Việt Nam', N'202 Đường V, Quận W, TP.HCM', '0901234567')
go

-- Nhập xe
INSERT INTO XE (maXe, tenXe, mauSac, giaBan, xuatXu, hangXe, phienBanXe, trongLuong, congSuatDongCo, loaiDongCo, chieuDai, chieuRong, chieuCao, hinhAnh)
VALUES 
	('XE001', 'Toyota Camry', N'Bạc', 850000000, N'Nhật Bản', 'Toyota', '2.0Q', 1530, 178, 'Xăng A2AR-FE', 4885, 1839, 1440, 'https://example.com/xe/camry.jpg'),
	('XE002', 'Hyundai Santa Fe', N'Trắng', 1240000000, N'Hàn Quốc', 'Hyundai', '3.5L Premium', 1764, 277, 'Xăng Smartstream G3.5 MPI', 4785, 1890, 1720, 'https://example.com/xe/santafe.jpg'),
	('XE003', 'Ford Everest', N'Đen', 1180000000, N'Mỹ', 'Ford', 'Titanium 2.0L Bi-Turbo', 2136, 210, 'Diesel Bi-Turbo', 4893, 1862, 1838, 'https://example.com/xe/everest.jpg'),
	('XE004', 'Kia Sorento', N'Xanh', 1059000000, N'Hàn Quốc', 'Kia', '2.5 Signature AWD', 1915, 281, 'Xăng Theta III 2.5L', 4810, 1900, 1700, 'https://example.com/xe/sorento.jpg'),
	('XE005', 'Mazda CX-8', N'Đỏ', 1249000000, N'Nhật Bản', 'Mazda', 'Premium AWD', 1962, 230, 'Xăng Skyactiv-G 2.5L', 4900, 1840, 1730, 'https://example.com/xe/cx8.jpg'),
	('XE006', 'Toyota Corolla Altis', N'Đỏ', 746000000, N'Nhật Bản', 'Toyota', '1.8G CVT', 1330, 140, 'Xăng 2ZR-FE', 4630, 1780, 1435, 'https://example.com/xe/corollaaltis.jpg'),
	('XE007', 'Honda Civic', N'Trắng', 870000000, N'Nhật Bản', 'Honda', 'RS', 1317, 174, 'Xăng 1.5L Turbo', 4678, 1800, 1415, 'https://example.com/xe/civic.jpg'),
	('XE008', 'Mazda3', N'Xanh', 669000000, N'Nhật Bản', 'Mazda', '1.5L Luxury', 1315, 110, 'Xăng Skyactiv-G 1.5L', 4660, 1795, 1440, 'https://example.com/xe/mazda3.jpg'),
	('XE009', 'Mitsubishi Xpander', N'Bạc', 620000000, N'Indonesia', 'Mitsubishi', 'AT Premium', 1230, 105, 'Xăng MIVEC 1.5L', 4595, 1750, 1750, 'https://example.com/xe/xpander.jpg'),
	('XE010', 'Suzuki Ertiga', N'Xám', 499000000, N'Indonesia', 'Suzuki', 'Sport', 1135, 95, 'Xăng K15B 1.5L', 4395, 1735, 1690, 'https://example.com/xe/ertiga.jpg'),
	('XE011', 'Ford Ranger', N'Đen', 625000000, N'Thái Lan', 'Ford', 'Wildtrak 2.0L Bi-Turbo', 2310, 210, 'Diesel Bi-Turbo', 5362, 1860, 1848, 'https://example.com/xe/ranger.jpg'),
	('XE012', 'Nissan Navara', N'Trắng', 945000000, N'Thái Lan', 'Nissan', 'VL Pro-4X 2.3L', 2230, 190, 'Diesel Twin-Turbo', 5255, 1850, 1825, 'https://example.com/xe/navara.jpg'),
	('XE013', 'Mitsubishi Triton', N'Xám', 885000000, N'Thái Lan', 'Mitsubishi', 'Athlete 4x4 AT', 2050, 181, 'Diesel MIVEC 2.4L', 5305, 1815, 1780, 'https://example.com/xe/triton.jpg'),
	('XE014', 'Toyota Vios', N'Đỏ', 478000000, N'Việt Nam', 'Toyota', 'E CVT', 1100, 107, 'Xăng 2NR-FE', 4410, 1730, 1475, 'https://example.com/xe/vios.jpg'),
	('XE015', 'Hyundai Accent', N'Xanh', 426000000, N'Việt Nam', 'Hyundai', '1.4 AT', 1128, 100, 'Xăng Kappa 1.4L MPI', 4440, 1729, 1470, 'https://example.com/xe/accent.jpg'),
	('XE016', 'Mercedes-Benz C-Class', N'Trắng', 1999000000, N'Đức', 'Mercedes-Benz', 'C 200 Avantgarde', 1425, 184, 'Xăng 1.5L Turbo', 4751, 1820, 1438, 'https://example.com/xe/cclass.jpg'),
	('XE017', 'BMW 3 Series', N'Xanh', 2399000000, N'Đức', 'BMW', '330i M Sport', 1455, 258, 'Xăng 2.0L Turbo', 4709, 1827, 1440, 'https://example.com/xe/3series.jpg'),
	('XE018', 'Audi A4', N'Đen', 2160000000, N'Đức', 'Audi', '45 TFSI quattro', 1545, 245, 'Xăng 2.0L Turbo', 4726, 1842, 1427, 'https://example.com/xe/a4.jpg'),
	('XE019', 'Lexus ES', N'Nâu', 2890000000, N'Nhật Bản', 'Lexus', 'ES 250 Luxury', 1685, 204, 'Xăng 2.5L Hybrid', 4975, 1865, 1440, 'https://example.com/xe/es.jpg'),
	('XE020', 'Porsche Panamera', N'Bạc', 5460000000, N'Đức', 'Porsche', '4S E-Hybrid', 2185, 560, 'Hybrid V6 2.9L Turbo', 5049, 1937, 1423, 'https://example.com/xe/panamera.jpg');

go

INSERT INTO PHIEUNHAP (maPhieuNhap, maXe, ngayNhap, giaNhap, soLuong, maNhaCungCap, maChiNhanh)
VALUES ('PN001', 'XE001', '2023-10-01', 830000000, 5, 'NCC001', 'CNHN'),
		('PN002', 'XE002', '2023-10-01', 1240000000, 5, 'NCC002', 'CNHCM'),
		('PN003', 'XE003', '2023-10-01', 1180000000, 5,'NCC003', 'CNHN'),
		('PN004', 'XE004', '2023-10-01', 1059000000, 5,'NCC004', 'CNHUE'),
		('PN005', 'XE005', '2023-10-01', 1249000000, 5,'NCC005', 'CNDN');
go

INSERT INTO KHACHHANG (maKhachHang, hoTenKhachHang, ngaySinh, gioiTinh, CCCD, diaChi, soDienThoai)
VALUES ('KH001', N'Đặng Gia Thuận', '2000-01-15', N'Nam', '123456789012', N'Hà Nội', '0987654321'),
		('KH002',N'Nguyễn Thị Lan Anh', '1995-03-20', N'Nữ', '234567890123', N'Hồ Chí Minh', '0901234567'),
		('KH003',N'Nguyễn Việt Khoa', '1988-05-10', N'Nam', '345678901234', N'Đà Nẵng', '0971234567'),
		('KH004',N'Phạm Thị Phương Nghi', '1992-09-08', N'Nữ', '456789012345', N'Hà Nội', '0961234567'),
		('KH005',N'Nguyễn Xuân Thể', '1985-12-25', N'Nam', '567890123456', N'Hồ Chí Minh', '0911234567'),
		('KH006',N'Nguyễn Hồ Thiên Thanh', '1997-06-30', N'Nữ', '678901234567', N'Đà Nẵng', '0987123456'),
		('KH007',N'Sú Minh Luân', '1990-03-17', N'Nam', '789012345678', N'Hà Nội', '0921234567'),
		('KH008',N'Hoàng Võ Ngọc Nguyên', '1999-08-12', N'Nam', '901234567890', N'Đà Nẵng', '0941234567'),
		('KH009', N'Nguyễn Thị Tuyết', '1999-07-12', N'Nữ', '901234567890', N'Long An', '0941234567');
go

INSERT INTO HOADON (maHoaDon, ngayLapHoaDon, maXe, tongTien, tinhTrang, maKhachHang, maNhanVienThucHien)
VALUES ('HD001', '2023-10-01', 'XE001', 1250000, N'Đã thanh toán', 'KH001', 'NVHN001'),
		('HD002', '2023-10-01', 'XE002', 1250000, N'Đã thanh toán', 'KH002', 'NVHN002'),
		('HD003', '2023-10-01', 'XE003', 1250000, N'Đã thanh toán', 'KH003', 'NVHN003'),
		('HD004', '2023-10-01', 'XE004', 1250000, N'Đã thanh toán', 'KH004', 'NVHN004'),
		('HD005', '2023-10-01', 'XE005', 1250000, N'Đã thanh toán', 'KH005', 'NVHN005');
go

INSERT INTO DICHVUBAODUONG (maBaoDuong, tenBaoDuong, loaiBaoDuong, phiBaoDuong)
VALUES ('DVBD001', N'Bảo dưỡng định kỳ', N'Định kỳ 5.000km', 200000),
		('DVBD002', N'Bảo dưỡng định kỳ', N'Định kỳ 10.000km', 300000),
		('DVBD003', N'Thay dầu máy', N'Thay dầu máy', 150000),
		('DVBD004', N'Thay lọc gió', N'Thay lọc gió', 100000),
		('DVBD005', N'Kiểm tra phanh', N'Kiểm tra phanh', 120000),
		('DVBD006', N'Điều chỉnh lốp', N'Điều chỉnh lốp', 80000),
		('DVBD007', N'Rửa xe', N'Rửa xe', 50000),
		('DVBD008', N'Thay bugi', N'Thay bugi', 70000),
		('DVBD009', N'Kiểm tra hệ thống điện', N'Kiểm tra hệ thống điện', 90000),
		('DVBD010', N'Điều chỉnh đèn', N'Điều chỉnh đèn', 60000);
go

INSERT INTO PHIEUBAODUONG (maPhieuBaoDuong, maBaoDuong, ngayLapPhieu, tongTien, maKhachHang, maNhanVienThucHien)
VALUES ('PBD001', 'DVBD003', '2023-10-01', 150000, 'KH001', 'NVHN007'),
		('PBD002', 'DVBD003', '2023-10-01', 150000, 'KH002', 'NVHN007')
go



select * from CHINHANH
select * from NHANVIEN
select * from TAIKHOAN
select * from NHACUNGCAP
select * from XE
select * from PHIEUNHAP
select * from KHACHHANG
select * from HOADON
select * from DICHVUBAODUONG
select * from PHIEUBAODUONG
select * from KHOXE

-- C:\aDrop_Box\Job\Study_21110927\2023-2024\Ki_1\Winform\CuoiKy\DBMS_CodeDoAn\Image
update XE set hinhAnh = 'C:\aDrop_Box\Job\Study_21110927\2023-2024\Ki_1\Winform\CuoiKy\DBMS_CodeDoAn\Image\New_Toyota_Corolla_Cross_already_kitted_out_in_subtle_accessories__-_CAR_Magazine-removebg-preview.png'

----- insert nhiều hóa đơn
--begin  tran
--DECLARE @startDate DATE = '2024-01-01';
--DECLARE @endDate DATE = '2024-12-31';
--WHILE @startDate <= @endDate
--BEGIN
--    INSERT INTO HOADON (ngayLapHoaDon, tongTien, maKhachHang, maNhanVienThucHien)
--    VALUES 
--        (@startDate,
--         ROUND(RAND() * 10000000 + 1000000, -3), -- Giá trị tổng tiền được tạo ngẫu nhiên từ 1 triệu đến 10 triệu
--         'KH00' + CONVERT(NVARCHAR(2), CAST(RAND() * 9 + 1 AS INT)),
--         'NVHN00' + CONVERT(NVARCHAR(2), CAST(RAND() * 7 + 1 AS INT)))
--    SET @startDate = DATEADD(DAY, 5, @startDate);
--END;
--rollback
----update HOADON set tinhTrang = N'Đã Thanh Toán'


---- insert nhiều phiếu nhập
--begin  tran
--DECLARE @startDatePhieuNhap DATE = '2024-01-01';
--DECLARE @endDatePhieuNhap DATE = '2024-12-31';
--DECLARE @maChiNhanh nvarchar(50);
--DECLARE @maNhaCC nvarchar(50);
--WHILE @startDatePhieuNhap <= @endDatePhieuNhap
--BEGIN
--	set @maChiNhanh = (select top 1 maChiNhanh from CHINHANH ORDER BY NEWID())
--	set @maNhaCC = (select top 1 maNhaCungCap from NHACUNGCAP ORDER BY NEWID())

--    INSERT INTO PHIEUNHAP(ngayNhap, maNhaCungCap, maChiNhanh)
--    VALUES 
--        (@startDatePhieuNhap,
--         @maNhaCC, -- Giá trị tổng tiền được tạo ngẫu nhiên từ 1 triệu đến 10 triệu
--         @maChiNhanh)
--    SET @startDatePhieuNhap = DATEADD(DAY, 5, @startDatePhieuNhap);
--END;
--rollback

---- Insert nhiều CHITIETPHIEUNHAPXE
--begin  tran
--DECLARE @cnt int = 1;
--DECLARE @maXe nvarchar(50), @maPhieuNhap nvarchar(50);
--DECLARE @giaNhap bigint;
--WHILE @cnt <= 100
--BEGIN
--	set @maXe = (select top 1 maXe from XE ORDER BY NEWID())
--	set @maPhieuNhap = (select top 1 maPhieuNhap from PHIEUNHAP ORDER BY NEWID())
--	set @giaNhap = (select (giaBan + 20000000) from XE where maXe = @maXe)

--	insert into CHITIETPHIEUNHAPXE(maXe, maPhieuNhap, giaNhap, soLuong)
--	values
--	(@maXe, @maPhieuNhap, @giaNhap, RAND() * 9 + 1);

--	set @cnt = @cnt + 1;
--END;
--rollback


---- Truy vấn lấy dữ liệu tạo biểu đồ
--begin tran
--SELECT FORMAT(ngayLapHoaDon, 'MM/yyyy') AS MonthYear, Sum(tongTien) AS TotalHoaDon 
--FROM HOADON 
--GROUP BY FORMAT(ngayLapHoaDon, 'MM/yyyy')
--ORDER BY MIN(ngayLapHoaDon) DESC

--select FORMAT(ngayNhap, 'MM/yyyy') as MonthYear, Sum(giaNhap * soLuong) as TotalPhieuNhap 
--from PHIEUNHAP pn 
--inner join CHITIETPHIEUNHAPXE cttpnx
--on pn.maPhieuNhap = cttpnx.maPhieuNhap
--GROUP BY FORMAT(ngayNhap, 'MM/yyyy')
--ORDER BY MIN(ngayNhap) DESC
--rollback