use JAVA_DOAN_QUANLYCUAHANGXE
go

-- Thêm dữ liệu cho bảng CHI NHÁNH
INSERT INTO CHINHANH (maChiNhanh, tenChiNhanh, diaChi)
VALUES ('CNHN', N'Chi nhánh Hà Nội', N'Số 25, Đường Lê Lợi, Quận Hai Bà Trưng, Hà Nội'),
       ('CNHCM', N'Chi nhánh Hồ Chí Minh', N'456 Đường B, Quận 2, TP.HCM'),
       ('CNHUE', N'Chi nhánh Huế', N'555 Đường Hà Khánh, Thành phố Huế'),
       ('CNCT', N'Chi nhánh Cần Thơ', N'222 Đường Trần Phú, Quận Ninh Kiều, Cần Thơ'),
       ('CNDN', N'Chi nhánh Đà Nẵng', N' 789 Đường 2/9, Quận Hải Châu, Đà Nẵng');
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
INSERT INTO TAIKHOAN (tenDangNhap, matKhau,maNhanVien)
VALUES ('1', '1', 'NVHN001'),
	   ('2', '1', 'NVHN002'),
	   ('3', '1', 'NVHN003'),
	   ('4', '1', 'NVHN004'),
	   ('5', '1', 'NVHN005'),
	   ('6', '1', 'NVHN006'),
	   ('7', '1', 'NVHN007');
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
INSERT INTO XE (maXe, tenXe, mauSac, giaBan, soChoNgoi, xuatXu, hangXe, loaiXe, phienBanXe, trongLuong,
             loaiNhienLieu, congSuatDongCo, dungTichDongCo, loaiDongCo, khoangSangGam, 
			 chieuDai, chieuRong, chieuCao, hinhAnh)
VALUES ('XE001', 'Mazda CX-5', N'Đen', 1400000, 5, N'Nhật Bản', 'Mazda', 'SUV', 'Grand Touring', 1680,
        N'Xăng', 225, 1998, N'4 xi-lanh', 195, 
		179, 72, 167, ''),
		('XE002', 'Volkswagen Golf', N'Xám', 1250000, 5, N'Đức', 'Volkswagen', 'Hatchback', 'Highline', 1450,
        N'Xăng', 180, 1395, N'4 xi-lanh', 175, 
		179, 70, 157, ''),
		('XE003', 'Subaru Outback', N'Xanh', 1380000, 5, N'Nhật Bản', 'Subaru', 'Crossover', 'Limited', 1700,
        N'Xăng', 256, 2498, N'6 xi-lanh', 200, 
		167, 72, 174, ''),
		('XE004', 'Mercedes-Benz E-Class', N'Bạc', 1500000, 5, N'Đức', 'Mercedes-Benz', 'Sedan', 'E350', 1800,
        N'Xăng', 292, 2999, N'6 xi-lanh', 188, 
		146, 73, 155, ''),
		('XE005', 'BMW X5', N'Đen', 1600000, 5, N'Đức', 'BMW', 'SUV', 'xDrive40i', 2000,
        N'Xăng', 335, 2998, N'6 xi-lanh', 194, 
		176, 79, 172, ''),
		('XE006', 'Audi Q7', N'Trắng', 1550000, 7, N'Đức', 'Audi', 'SUV', 'Premium Plus', 2100,
        N'Xăng', 335, 2995, N'6 xi-lanh', 200, 
		174, 77, 169, ''),
		('XE007', 'Lexus RX', N'Xám', 1450000, 5, N'Nhật Bản', 'Lexus', 'SUV', 'RX350', 1900,
		N'Xăng', 295, 3456, N'6 xi-lanh', 193, 
		168, 74, 171, ''),
		('XE008', 'Volvo XC90', 'Trắng', 1700000, 7, N'Thụy Điển', 'Volvo', 'SUV', 'T8 Inscription', 2150,
		N'Xăng', 400, 1969, N'4 xi-lanh', 194, 
		176, 77, 174, ''),
		('XE009', 'Jeep Grand Cherokee', N'Đỏ', 1480000, 5, N'Mỹ', 'Jeep', 'SUV', 'Limited', 2000,
        N'Xăng', 360, 3600, '6 xi-lanh', 189, 
		180, 69, 165, ''),
		('XE010', 'Tesla Model X', N'Trắng', 1800000, 7, N'Mỹ', 'Tesla', 'SUV', 'Long Range', 2200,
        N'Điện', 670, 0, N'Điện', 198, 
		168, 78, 168, '');
go

INSERT INTO PHIEUNHAP (maNhaCungCap, maChiNhanh, ngayNhap)
VALUES ('NCC001', 'CNHN', '2023-10-01')
INSERT INTO PHIEUNHAP (maNhaCungCap, maChiNhanh, ngayNhap)
VALUES ('NCC002', 'CNHCM', '2023-10-02')
INSERT INTO PHIEUNHAP (maNhaCungCap, maChiNhanh, ngayNhap)
VALUES ('NCC003', 'CNHN', '2023-10-03')
INSERT INTO PHIEUNHAP (maNhaCungCap, maChiNhanh, ngayNhap)
VALUES ('NCC004', 'CNHUE', '2023-10-04')
INSERT INTO PHIEUNHAP (maNhaCungCap, maChiNhanh, ngayNhap)
VALUES ('NCC005', 'CNDN', '2023-10-05')
go

INSERT INTO CHITIETPHIEUNHAPXE (maXe, maPhieuNhap, giaNhap, soLuong)
VALUES ('XE001', 'PN001', 1200000, 5)
INSERT INTO CHITIETPHIEUNHAPXE (maXe, maPhieuNhap, giaNhap, soLuong)
VALUES ('XE001', 'PN001', 1300000, 6)
INSERT INTO CHITIETPHIEUNHAPXE (maXe, maPhieuNhap, giaNhap, soLuong)
VALUES ('XE002', 'PN002', 1100000, 2)
INSERT INTO CHITIETPHIEUNHAPXE (maXe, maPhieuNhap, giaNhap, soLuong)
VALUES ('XE002', 'PN002', 1400000, 1)
INSERT INTO CHITIETPHIEUNHAPXE (maXe, maPhieuNhap, giaNhap, soLuong)
VALUES ('XE003', 'PN003', 1250000, 6)
INSERT INTO CHITIETPHIEUNHAPXE (maXe, maPhieuNhap, giaNhap, soLuong)
VALUES ('XE003', 'PN003', 1350000, 9)
INSERT INTO CHITIETPHIEUNHAPXE (maXe, maPhieuNhap, giaNhap, soLuong)
VALUES ('XE004', 'PN004', 1150000, 10)
INSERT INTO CHITIETPHIEUNHAPXE (maXe, maPhieuNhap, giaNhap, soLuong)
VALUES ('XE004', 'PN004', 1500000, 11)
INSERT INTO CHITIETPHIEUNHAPXE (maXe, maPhieuNhap, giaNhap, soLuong)
VALUES ('XE005', 'PN005', 1280000, 13)
INSERT INTO CHITIETPHIEUNHAPXE (maXe, maPhieuNhap, giaNhap, soLuong)
VALUES ('XE005', 'PN005', 1380000, 4)
go


INSERT INTO KHACHHANG (hoTenKhachHang, ngaySinh, gioiTinh, CCCD, diaChi, soDienThoai)
VALUES (N'Đặng Gia Thuận', '2000-01-15', N'Nam', '123456789012', N'Hà Nội', '0987654321')
INSERT INTO KHACHHANG (hoTenKhachHang, ngaySinh, gioiTinh, CCCD, diaChi, soDienThoai)
VALUES (N'Nguyễn Thị Lan Anh', '1995-03-20', N'Nữ', '234567890123', N'Hồ Chí Minh', '0901234567')
INSERT INTO KHACHHANG (hoTenKhachHang, ngaySinh, gioiTinh, CCCD, diaChi, soDienThoai)
VALUES (N'Nguyễn Việt Khoa', '1988-05-10', N'Nam', '345678901234', N'Đà Nẵng', '0971234567')
INSERT INTO KHACHHANG (hoTenKhachHang, ngaySinh, gioiTinh, CCCD, diaChi, soDienThoai)
VALUES (N'Phạm Thị Phương Nghi', '1992-09-08', N'Nữ', '456789012345', N'Hà Nội', '0961234567')
INSERT INTO KHACHHANG (hoTenKhachHang, ngaySinh, gioiTinh, CCCD, diaChi, soDienThoai)
VALUES (N'Nguyễn Xuân Thể', '1985-12-25', N'Nam', '567890123456', N'Hồ Chí Minh', '0911234567')
INSERT INTO KHACHHANG (hoTenKhachHang, ngaySinh, gioiTinh, CCCD, diaChi, soDienThoai)
VALUES (N'Nguyễn Hồ Thiên Thanh', '1997-06-30', N'Nữ', '678901234567', N'Đà Nẵng', '0987123456')
INSERT INTO KHACHHANG (hoTenKhachHang, ngaySinh, gioiTinh, CCCD, diaChi, soDienThoai)
VALUES (N'Sú Minh Luân', '1990-03-17', N'Nam', '789012345678', N'Hà Nội', '0921234567')
INSERT INTO KHACHHANG (hoTenKhachHang, ngaySinh, gioiTinh, CCCD, diaChi, soDienThoai)
VALUES (N'Hoàng Võ Ngọc Nguyên', '1999-08-12', N'Nam', '901234567890', N'Đà Nẵng', '0941234567')
go

INSERT INTO HOADON (maKhachHang, maNhanVienThucHien, tongTien, tinhTrang)
VALUES ('KH001', 'NVHN004', 1250000, N'Chưa thanh toán')
INSERT INTO HOADON (maKhachHang, maNhanVienThucHien, tongTien, tinhTrang)
VALUES ('KH002', 'NVHN004', 1350000, N'Chưa thanh toán')
INSERT INTO HOADON (maKhachHang, maNhanVienThucHien, tongTien, tinhTrang)
VALUES ('KH003', 'NVHN004', 1150000, N'Chưa thanh toán')
INSERT INTO HOADON (maKhachHang, maNhanVienThucHien, tongTien, tinhTrang)
VALUES ('KH004', 'NVHN004', 1400000, N'Chưa thanh toán')
INSERT INTO HOADON (maKhachHang, maNhanVienThucHien, tongTien, tinhTrang)
VALUES ('KH005', 'NVHN004', 1200000, N'Chưa thanh toán')
go

INSERT INTO CHITIETHOADONXE (maHoaDon, maXe, ngayNhanXe, soTienDaTra, phiDangKyBienSo, phiDangKiem, phiTruocBa, phiBaoHiemTrachNhiemDanSu, phiSuDungDuongBo)
VALUES ('HD001', 'XE001', '2023-10-01', 1250000, 100, 50, 30, 40, 20)
INSERT INTO CHITIETHOADONXE (maHoaDon, maXe, ngayNhanXe, soTienDaTra, phiDangKyBienSo, phiDangKiem, phiTruocBa, phiBaoHiemTrachNhiemDanSu, phiSuDungDuongBo)
VALUES       ('HD002', 'XE002', '2023-10-02', 1350000, 110, 55, 35, 45, 25)
INSERT INTO CHITIETHOADONXE (maHoaDon, maXe, ngayNhanXe, soTienDaTra, phiDangKyBienSo, phiDangKiem, phiTruocBa, phiBaoHiemTrachNhiemDanSu, phiSuDungDuongBo)
VALUES       ('HD003', 'XE001', '2023-10-03', 1150000, 90, 45, 25, 35, 15)
INSERT INTO CHITIETHOADONXE (maHoaDon, maXe, ngayNhanXe, soTienDaTra, phiDangKyBienSo, phiDangKiem, phiTruocBa, phiBaoHiemTrachNhiemDanSu, phiSuDungDuongBo)
VALUES       ('HD004', 'XE001', '2023-10-04', 1400000, 120, 60, 40, 50, 30)
INSERT INTO CHITIETHOADONXE (maHoaDon, maXe, ngayNhanXe, soTienDaTra, phiDangKyBienSo, phiDangKiem, phiTruocBa, phiBaoHiemTrachNhiemDanSu, phiSuDungDuongBo)
VALUES       ('HD005', 'XE001', '2023-10-05', 1200000, 105, 52, 32, 42, 22)
go

INSERT INTO DICHVUBAODUONG (tenBaoDuong, loaiBaoDuong, phiBaoDuong)
VALUES (N'Bảo dưỡng định kỳ', N'Định kỳ 5.000km', 200000)
INSERT INTO DICHVUBAODUONG (tenBaoDuong, loaiBaoDuong, phiBaoDuong)
VALUES       (N'Bảo dưỡng định kỳ', N'Định kỳ 10.000km', 300000)
INSERT INTO DICHVUBAODUONG (tenBaoDuong, loaiBaoDuong, phiBaoDuong)
VALUES      (N'Thay dầu máy', N'Thay dầu máy', 150000)
INSERT INTO DICHVUBAODUONG (tenBaoDuong, loaiBaoDuong, phiBaoDuong)
VALUES       (N'Thay lọc gió', N'Thay lọc gió', 100000)
INSERT INTO DICHVUBAODUONG (tenBaoDuong, loaiBaoDuong, phiBaoDuong)
VALUES       (N'Kiểm tra phanh', N'Kiểm tra phanh', 120000)
INSERT INTO DICHVUBAODUONG (tenBaoDuong, loaiBaoDuong, phiBaoDuong)
VALUES       (N'Điều chỉnh lốp', N'Điều chỉnh lốp', 80000)
INSERT INTO DICHVUBAODUONG (tenBaoDuong, loaiBaoDuong, phiBaoDuong)
VALUES       (N'Rửa xe', N'Rửa xe', 50000)
INSERT INTO DICHVUBAODUONG (tenBaoDuong, loaiBaoDuong, phiBaoDuong)
VALUES       (N'Thay bugi', N'Thay bugi', 70000)
INSERT INTO DICHVUBAODUONG (tenBaoDuong, loaiBaoDuong, phiBaoDuong)
VALUES       (N'Kiểm tra hệ thống điện', N'Kiểm tra hệ thống điện', 90000)
INSERT INTO DICHVUBAODUONG (tenBaoDuong, loaiBaoDuong, phiBaoDuong)
VALUES       (N'Điều chỉnh đèn', N'Điều chỉnh đèn', 60000)
go

INSERT INTO PHIEUBAODUONG (maKhachHang, maNhanVienThucHien, tongTien)
VALUES ('KH001', 'NVHN007', 150000)
INSERT INTO PHIEUBAODUONG (maKhachHang, maNhanVienThucHien, tongTien)
VALUES       ('KH002', 'NVHN007', 150000)
go

INSERT INTO CHITIETPHIEUBAODUONG(maBaoDuong, maPhieuBaoDuong, thanhTien)
VALUES ('DVBD003', 'PBD001', 150000)
INSERT INTO CHITIETPHIEUBAODUONG(maBaoDuong, maPhieuBaoDuong, thanhTien)
VALUES       ('DVBD003', 'PBD002', 150000)


select * from CHINHANH
select * from NHANVIEN
select * from TAIKHOAN
select * from NHACUNGCAP
select * from XE
select * from PHIEUNHAP
select * from CHITIETPHIEUNHAPXE
select * from KHACHHANG
select * from HOADON
select * from CHITIETHOADONXE
select * from DICHVUBAODUONG
select * from PHIEUBAODUONG
select * from CHITIETPHIEUBAODUONG
select * from KHOXE

-- C:\aDrop_Box\Job\Study_21110927\2023-2024\Ki_1\Winform\CuoiKy\DBMS_CodeDoAn\Image
update XE set hinhAnh = 'C:\aDrop_Box\Job\Study_21110927\2023-2024\Ki_1\Winform\CuoiKy\DBMS_CodeDoAn\Image\New_Toyota_Corolla_Cross_already_kitted_out_in_subtle_accessories__-_CAR_Magazine-removebg-preview.png'
