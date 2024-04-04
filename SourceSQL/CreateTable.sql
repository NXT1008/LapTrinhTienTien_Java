--drop database JAVA_DOAN_QUANLYCUAHANGXE
create database JAVA_DOAN_QUANLYCUAHANGXE
go
use JAVA_DOAN_QUANLYCUAHANGXE
go

-- Tạo bảng chi nhánh
create table CHINHANH(
	maChiNhanh nvarchar(20) primary key,
	tenChiNhanh nvarchar(50) not null,
	diaChi nvarchar(255) not null,
)
go

-- Tạo bảng nhân viên 
-- => Trigger kiểm tra NHÂN VIÊN: CCCD là số, >=18 tuổi
	create table NHANVIEN( 
	maNhanVien nvarchar(20) primary key,
	hoTenNhanVien nvarchar(50) not null,
	CCCD nvarchar(20) constraint contr_NhanVien_checkLenCCCD check (len(CCCD) = 12),
	ngaySinh date constraint contr_NhanVien_checkOld check (DateDiff(year, ngaySinh, GetDate()) >= 18),
	gioiTinh nvarchar(5),
	diaChi nvarchar(255),
	soDienThoai nvarchar(20) constraint contr_NHANVIEN_checkLenSDT check (len(soDienThoai) = 10 or len(soDienThoai) = 11),
	chucVu nvarchar(50),
	tinhTrangLamViec bit default 1,
	maChiNhanh nvarchar(20),
	hinhAnh nvarchar(300),
	foreign key (maChiNhanh) references CHINHANH(maChiNhanh),
	constraint contr_NhanVien_conflictCCCD unique (CCCD),
	constraint contr_NhanVien_conflictSDT unique (soDienThoai)
)
go

-- Tạo bảng Tài khoản
create table TAIKHOAN(
	tenDangNhap nvarchar(20) primary key,	
	matKhau nvarchar(50) not null,
	maNhanVien nvarchar(20),
	foreign key (maNhanVien) references NHANVIEN(maNhanVien)
	on delete cascade -- Nhân viên xóa thì tải khoản cũng sẽ xóa
)
go

-- Tạo bảng NHÀ CUNG CẤP
create table NHACUNGCAP(
	maNhaCungCap nvarchar(20) primary key,
	tenNhaCungCap nvarchar(50) not null,
	diaChi nvarchar(255) not null,
	soDienThoai nvarchar(20) constraint contr_NHACUNGCAP_checkLenSDT check (len(soDienThoai) = 10 or len(soDienThoai) = 11),
)
go

-- Tạo bảng LÔ XE
create table XE(
	maXe nvarchar(20) primary key,
	tenXe nvarchar(50), 
	mauSac nvarchar(20), 
	giaBan float constraint contr_XE_checkGiaBan check (giaBan > 0), 
	soChoNgoi int constraint contr_XE_checkSoChoNgoi check (soChoNgoi >= 2) default 4, 
	xuatXu nvarchar(50), 
	hangXe nvarchar(50), 
	loaiXe nvarchar(50), 
	phienBanXe nvarchar(50),
	trongLuong int constraint contr_XE_checkTrongLuong check (trongLuong > 0),
	loaiNhienLieu nvarchar(50), 
	congSuatDongCo int constraint contr_XE_checkCongSuatDongCo check (congSuatDongCo > 0), 
	dungTichDongCo int constraint contr_XE_checkDungTichDongCo check (dungTichDongCo >= 0), 
	loaiDongCo nvarchar(50), 
	khoangSangGam int constraint contr_XE_checkKhoangSangGam check (khoangSangGam > 0), 
	chieuDai int constraint contr_XE_checkChieuDai check (chieuDai > 0), 
	chieuRong int constraint contr_XE_checkChieuRong check (chieuRong > 0), 
	chieuCao int constraint contr_XE_checkChieuCao check (chieuCao > 0), 
	hinhAnh nvarchar(300)
)
go
-- Tạo bảng PHIẾU NHẬP
create table PHIEUNHAP(
	maPhieuNhap nvarchar(20) primary key,
	ngayNhap date default GETDATE(),
	maNhaCungCap nvarchar(20),
	maChiNhanh nvarchar(20),
	foreign key (maNhaCungCap) references NHACUNGCAP(maNhaCungCap),
	foreign key (maChiNhanh) references CHINHANH(maChiNhanh)
)
go

-- Tạo bảng CHI TIẾT PHIẾU NHẬP XE
create table CHITIETPHIEUNHAPXE(
	maChiTietPhieuNhapXe nvarchar(20) primary key,
	maXe nvarchar(20),
	maPhieuNhap nvarchar(20),
	giaNhap float check (giaNhap > 0),
	soLuong int check(soLuong > 0),
	foreign key (maXe) references XE(maXe),
	foreign key (maPhieuNhap) references PHIEUNHAP(maPhieuNhap)
)
go

-- Tạo bảng KHÁCH HÀNG
CREATE TABLE KHACHHANG(
	maKhachHang nvarchar(20) primary key,
	hoTenKhachHang nvarchar(50) not null, 
	ngaySinh date constraint contr_KHACHHANG_checkOld check (DateDiff(year, ngaySinh, GetDate()) >= 18), 
	gioiTinh nvarchar(5), 
	CCCD nvarchar(20) constraint contr_KHACHHANG_checkLenCCCD check (len(CCCD) = 12) unique, 
	diaChi nvarchar(255), 
	soDienThoai nvarchar(20) constraint contr_KHACHHANG_checkLenSDT check (len(soDienThoai) = 10 or len(soDienThoai) = 11) unique,
)
go

-- Tạo bảng hóa đơn
create table HOADON(
	maHoaDon nvarchar(20) primary key,
	ngayLapHoaDon date default GETDATE(),
	tongTien float check (tongTien > 0),
	tinhTrang nvarchar(50) constraint contr_HOADON_checkStatus Check (tinhTrang = N'Chưa thanh toán' or tinhTrang = N'Đã thanh toán') default N'Chưa thanh toán',
	maKhachHang nvarchar(20), 
	maNhanVienThucHien nvarchar(20)
	foreign key (maKhachHang) references KHACHHANG(maKhachHang),
	foreign key (maNhanVienThucHien) references NHANVIEN(maNhanVien)
)
go

-- Tạo bảng CHI TIẾT HÓA ĐƠN XE
create table CHITIETHOADONXE(
	maChiTietHoaDonXe nvarchar(20) primary key,
	maHoaDon nvarchar(20), 
	maXe nvarchar(20),
	ngayNhanXe date,
	soTienDaTra float check (soTienDaTra >= 0),
	phiDangKyBienSo float check (phiDangKyBienSo >= 0),
	phiDangKiem float check (phiDangKiem >= 0),
	phiTruocBa float check (phiTruocBa >= 0),
	phiBaoHiemTrachNhiemDanSu float check (phiBaoHiemTrachNhiemDanSu >= 0),
	phiSuDungDuongBo float check (phiSuDungDuongBo >= 0),
	foreign key (maHoaDon) references HOADON(maHoaDon),
	foreign key (maXe) references XE(maXe)
)
go


-- Tạo bảng DỊCH VỤ BẢO DƯỠNG
CREATE TABLE DICHVUBAODUONG(
	maBaoDuong nvarchar(20) primary key, 
	tenBaoDuong nvarchar(50) not null, 
	loaiBaoDuong nvarchar(50) not null,
	phiBaoDuong float check (phiBaoDuong >= 0),
)
go

-- Tạo bảng PHIẾU BẢO DƯỠNG
CREATE TABLE PHIEUBAODUONG(
	maPhieuBaoDuong nvarchar(20) primary key, 
	ngayLapPhieu date default GetDate(), 
	tongTien float check (tongTien >= 0),
	maKhachHang nvarchar(20), 
	maNhanVienThucHien nvarchar(20), 
	foreign key (maKhachHang) references KHACHHANG(maKhachHang),
	foreign key (maNhanVienThucHien) references NHANVIEN(maNhanVien)
)
go

-- Tạo bảng HÓA ĐƠN BẢO DƯỠNG
create table CHITIETPHIEUBAODUONG(
	maChiTietPhieuBaoDuong nvarchar(20) primary key,
	maBaoDuong nvarchar(20),
	maPhieuBaoDuong nvarchar(20),
	thanhTien float check (thanhTien >= 0),
	foreign key (maBaoDuong) references DICHVUBAODUONG(maBaoDuong),
	foreign key (maPhieuBaoDuong) references PHIEUBAODUONG(maPhieuBaoDuong)
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







