--drop database JAVA_DOAN_QUANLYCUAHANGXE
create database JAVA_DOAN_QUANLYCUAHANGXE
go
use JAVA_DOAN_QUANLYCUAHANGXE
go

-- Tạo bảng chi nhánh
create table CHINHANH(
	maChiNhanh nvarchar(20) primary key,
	tenChiNhanh nvarchar(50),
	diaChi nvarchar(255),
	soDienThoai nvarchar(20)
)

go

-- Tạo bảng nhân viên 
create table NHANVIEN( 
	maNhanVien nvarchar(20) primary key,
	hoTenNhanVien nvarchar(50) not null,
	CCCD nvarchar(20),
	ngaySinh date,
	gioiTinh nvarchar(5),
	diaChi nvarchar(255),
	soDienThoai nvarchar(20),
	chucVu nvarchar(50),
	tinhTrangLamViec bit default 1,
	maChiNhanh nvarchar(20),
	hinhAnh nvarchar(300),
	foreign key (maChiNhanh) references CHINHANH(maChiNhanh)
)
go


-- Tạo bảng Tài khoản
create table TAIKHOAN(
	maNhanVien nvarchar(20) primary key,
	tenDangNhap nvarchar(20),	
	matKhau nvarchar(50),
	isAdmin bit default 0,
	foreign key (maNhanVien) references NHANVIEN(maNhanVien)
	on delete cascade -- Nhân viên xóa thì tải khoản cũng sẽ xóa
)
go


-- Tạo bảng NHÀ CUNG CẤP
create table NHACUNGCAP(
	maNhaCungCap nvarchar(20) primary key,
	tenNhaCungCap nvarchar(50) not null,
	diaChi nvarchar(255) not null,
	soDienThoai nvarchar(20),
)
go

-- Tạo bảng LÔ XE
create table XE(
	maXe nvarchar(20) primary key,
	tenXe nvarchar(50), 
	mauSac nvarchar(20), 
	giaBan bigint, 
	xuatXu nvarchar(50), 
	hangXe nvarchar(50), 
	phienBanXe nvarchar(50),
	trongLuong int,
	congSuatDongCo int, 
	loaiDongCo nvarchar(50), 
	chieuDai int, 
	chieuRong int, 
	chieuCao int, 
	hinhAnh nvarchar(300)
)
go
-- Tạo bảng PHIẾU NHẬP
create table PHIEUNHAP(
	maPhieuNhap nvarchar(20) primary key,
	maXe nvarchar(20),
	ngayNhap date default GETDATE(),
	giaNhap bigint,
	soLuong int,
	maNhaCungCap nvarchar(20),
	maChiNhanh nvarchar(20),
	foreign key (maXe) references XE(maXe),
	foreign key (maNhaCungCap) references NHACUNGCAP(maNhaCungCap),
	foreign key (maChiNhanh) references CHINHANH(maChiNhanh)
)
go

-- Tạo bảng KHÁCH HÀNG
CREATE TABLE KHACHHANG
(
	maKhachHang nvarchar(20) primary key,
	hoTenKhachHang nvarchar(50) not null, 
	ngaySinh date, 
	gioiTinh nvarchar(5), 
	CCCD nvarchar(20), 
	diaChi nvarchar(255), 
	soDienThoai nvarchar(20),
)
go

-- Tạo bảng hóa đơn
create table HOADON(
	maHoaDon nvarchar(20) primary key,
	ngayLapHoaDon date default GETDATE(),
	maXe nvarchar(20),
	tongTien bigint,
	tinhTrang nvarchar(50),
	maKhachHang nvarchar(20), 
	maNhanVienThucHien nvarchar(20),
	foreign key (maXe) references XE(maXe),
	foreign key (maKhachHang) references KHACHHANG(maKhachHang),
	foreign key (maNhanVienThucHien) references NHANVIEN(maNhanVien)
)
go

-- Tạo bảng DỊCH VỤ BẢO DƯỠNG
CREATE TABLE DICHVUBAODUONG(
	maBaoDuong nvarchar(20) primary key, 
	tenBaoDuong nvarchar(50), 
	loaiBaoDuong nvarchar(50),
	phiBaoDuong bigint,
)
go

-- Tạo bảng PHIẾU BẢO DƯỠNG
CREATE TABLE PHIEUBAODUONG(
	maPhieuBaoDuong nvarchar(20) primary key, 
	maBaoDuong nvarchar(20),
	ngayLapPhieu date default GetDate(), 
	tongTien bigint,
	maKhachHang nvarchar(20), 
	maNhanVienThucHien nvarchar(20), 
	foreign key (maBaoDuong) references DICHVUBAODUONG(maBaoDuong),
	foreign key (maKhachHang) references KHACHHANG(maKhachHang),
	foreign key (maNhanVienThucHien) references NHANVIEN(maNhanVien)
)
go

----
create table KHOXE
(
	maXe nvarchar(20),
	soLuongXeCon int default 0,
	soLuongXeDaBan int default 0,
	primary key (maXe),
	foreign key (maXe) references XE(maXe)
)
go







