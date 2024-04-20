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
	hinhAnh VARBINARY(MAX)
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
---------------------------------------
-- Function
-------------------------------------------------------------------------
-- Function tự động sinh mã bảo dưỡng
create or alter function fn_SinhMaBaoDuong()
returns nvarchar(20)
as
begin
	declare @nextID nvarchar(20), @lastID nvarchar(20)
	select @lastID = ISNULL(MAX(CAST(SUBSTRING(maBaoDuong, 5, LEN(maBaoDuong) - 4) as int)) , 0) 
	from DICHVUBAODUONG

	if (@lastID < 9999)
		set @nextID = 'DVBD' + RIGHT('000' + CAST(ISNULL(@lastID, 0) + 1 as nvarchar), 4)
	else
		set @nextID = 'DVBD' + CAST(ISNULL(@lastID, 0) + 1 as nvarchar)
	return @nextID
end
go
-- Add Contraint cho mã bảo dưỡng
alter table DICHVUBAODUONG add constraint constr_MaBaoDuong
default dbo.fn_SinhMaBaoDuong() for maBaoDuong
go
--alter table DICHVUBAODUONG drop constraint constr_MaBaoDuong
-------------------------------------------------------------------------------------------------
-- Function tự động sinh Phiếu bảo dưỡng
create or alter function fn_SinhMaPhieuBaoDuong()
returns nvarchar(20)
as
begin
	declare @NextID nvarchar(20), @LastID nvarchar(20)
	select @LastID = ISNULL(MAX(CAST(SUBSTRING(maPhieuBaoDuong, 4, LEN(maPhieuBaoDuong) - 3) as int)), 0)
	from PHIEUBAODUONG

	if (@LastID < 9999)
		set @NextID = 'PBD' + RIGHT('000' + CAST(ISNULL(@LastID, 0) + 1 as nvarchar), 4)
	else
		set @NextID = 'PBD' + CAST(ISNULL(@LastID, 0) + 1 as nvarchar)
	return @NextID
end
go
-- add contraint
alter table PHIEUBAODUONG add constraint contr_MaPhieuBaoDuong
default dbo.fn_SinhMaPhieuBaoDuong() for maPhieuBaoDuong
go

-------------------------------------------------------------------------------------------------
-- Function tự động sinh mã khách hàng
go
create or alter function fn_SinhMaKhachHang()
returns nvarchar(20)
as
begin
	declare @NextID nvarchar(20), @LastID nvarchar(20)
	select @LastID = ISNULL(MAX(CAST(SUBSTRING(maKhachHang, 3, LEN(maKhachHang) - 2) as int)), 0)
	from KHACHHANG

	if (@LastID < 9999)
		set @NextID = 'KH' + RIGHT('000' + CAST(ISNULL(@LastID, 0) + 1 as nvarchar), 4)
	else
		set @NextID = 'KH' + CAST(ISNULL(@LastID, 0) + 1 as nvarchar)
	return @NextID
end
go
-- Add Constraint cho mã Khách hàng
alter table KHACHHANG add constraint contr_MaKhachHang
default dbo.fn_SinhMaKhachHang() for maKhachHang
go
--------------------------------------------------------------------------------------------------
--Function tự động sinh mã phiếu nhập
create or alter function fn_SinhMaPhieuNhap()
returns nvarchar(20)
as
begin
	declare @NewId nvarchar(20), @LastId nvarchar(20)
	select @LastId = ISNULL(MAX(CAST(SUBSTRING(maPhieuNhap, 3, LEN(maPhieuNhap) - 2) as int)), 0)
	from PHIEUNHAP
	if (@LastId < 9999)
	begin
		set @NewId = 'PN' + RIGHT('000' + CAST(ISNULL(@LastId, 0) + 1 as nvarchar), 4)
	end
	else
	begin
		set @NewId = 'PN' + CAST(ISNULL(@LastID, 0) + 1 as nvarchar)
	end
	return @NewID
end
go
-- Add constraint 
alter table PHIEUNHAP add constraint contr_SinhMaPhieuNhap
default dbo.fn_SinhMaPhieuNhap() for maPhieuNhap
go

--------------------------------------------------------------------------------------------------
--Function sinh mã hóa đơn
create or alter function fn_SinhMaHoaDon()
returns nvarchar(20)
as
begin
	declare @NewID nvarchar(20), @LastID nvarchar(20)
	select @LastID = ISNULL(MAX(CAST(SUBSTRING(maHoaDon, 3, len(maHoaDon) - 2) as int)), 0)
	from HOADON
	if (@LastID < 9999)
	begin
		set @NewID = 'HD' + RIGHT('000' + CAST(ISNULL(@LastID, 0) + 1 as nvarchar), 4)
	end
	else
		set @NewID = 'HD' + CAST(ISNULL(@LastID, 0) + 1 as nvarchar)
	return @NewID
end
go
--Add constraint
alter table HOADON add constraint contr_SinhMaHoaDon
default dbo.fn_SinhMaHoaDon() for maHoaDon
go

------------------------------------------------------------
-- Function sinh mã Xe
create or alter function fn_SinhMaXe()
returns nvarchar(20)
as
begin
	declare @NewID nvarchar(20), @LastID nvarchar(20)
	select @LastID = ISNULL(MAX(CAST(SUBSTRING(maXe, 3, LEN(maXe) - 1) as int)), 0)
	from XE
	if (@LastID < 9999)
	begin
		set @NewID = 'XE' + RIGHT('000' + CAST(ISNULL(@LastID, 0) + 1 as nvarchar), 4)
	end
	else
	begin
		set @NewID = 'XE' + CAST(ISNULL(@LastID, 0) + 1 as nvarchar)
	end
	return @NewID
end
go
-- Add Constraint
alter table XE add constraint contr_SinhMaXe
default dbo.fn_SinhMaXe() for maXe
go
------------------------------------------------------------------
------- PHÂN TRANG HÓA ĐƠN

create or alter proc sp_ThongKeHoaDonTheoNgay @start date, @end date
as
begin
	(select hoTenKhachHang as [Họ tên khách hàng], 
	ngayLapHoaDon as [Ngày lập hóa đơn], tongTien as [Tổng tiền], 
	tinhTrang as [Tình trạng hóa đơn], hoTenNhanVien as [Nhân viên thực viện], HD.maHoaDon
	from HOADON HD
	inner join KHACHHANG KH on HD.maKhachHang = KH.maKhachHang
	inner join NHANVIEN NV on HD.maNhanVienThucHien = NV.maNhanVien
	where ngayLapHoaDon >= @start and ngayLapHoaDon <= @end)
end
go


create or alter proc sp_PhanTrangHoaDon @start date, @end date, @page int
as
begin
	declare @pageRows int = 10
	declare @selectRows int = @pageRows
	declare @exceptRows int = (@page - 1) * @pageRows

	;with tableTemp as
	(select hoTenKhachHang as [Họ tên khách hàng], 
	ngayLapHoaDon as [Ngày lập hóa đơn], tongTien as [Tổng tiền], 
	tinhTrang as [Tình trạng hóa đơn], hoTenNhanVien as [Nhân viên thực viện], HD.maHoaDon
	from HOADON HD
	inner join KHACHHANG KH on HD.maKhachHang = KH.maKhachHang
	inner join NHANVIEN NV on HD.maNhanVienThucHien = NV.maNhanVien
	where ngayLapHoaDon >= @start and ngayLapHoaDon <= @end)

	select top (@selectRows) * from tableTemp where maHoaDon not in
	(select top (@exceptRows) maHoaDon from tableTemp)
end
go

create or alter proc sp_SoLuongHoaDonTheoNgay @start date, @end date
as
begin
	(select count(*)
	from HOADON HD
	inner join KHACHHANG KH on HD.maKhachHang = KH.maKhachHang
	inner join NHANVIEN NV on HD.maNhanVienThucHien = NV.maNhanVien
	where ngayLapHoaDon >= @start and ngayLapHoaDon <= @end)
end
go
--exec sp_ThongKeHoaDonTheoNgay @start = '2003-09-08', @end = '2023-11-29'
--exec sp_PhanTrangHoaDon @start = '2003-09-08', @end = '2023-11-29', @page = 2
--exec sp_SoLuongHoaDonTheoNgay @start = '2003-09-08', @end = '2023-11-29'
------------------
--Trigger
--------------------------------------------------------------------------------
--Trigger khi nhập hàng về chi nhánh thì sẽ cập nhật vào kho
---------- Cập nhật kho xe
CREATE OR ALTER TRIGGER trg_CapNhatKhoXeKhiNhapHang
ON PHIEUNHAP
AFTER INSERT 
AS
BEGIN
    DECLARE @maXe NVARCHAR(20), @soLuong INT;
    
    -- Declare Cursor để lặp qua các dòng trong bảng inserted
    DECLARE cursor_Inserted CURSOR FOR
    SELECT maXe, soLuong
    FROM inserted;

    -- Mở Cursor
    OPEN cursor_Inserted;
    FETCH NEXT FROM cursor_Inserted INTO @maXe, @soLuong;

    -- Bắt đầu lặp qua từng dòng
    WHILE @@FETCH_STATUS = 0
    BEGIN
        IF EXISTS (SELECT 1 FROM KHOXE WHERE maXe = @maXe)
        BEGIN
            -- Nếu mã xe đã tồn tại trong bảng KHOXE, thực hiện UPDATE
            UPDATE KHOXE
            SET soLuongXeCon = soLuongXeCon + @soLuong
            WHERE maXe = @maXe;
        END
        ELSE
        BEGIN
            -- Nếu mã xe chưa tồn tại trong bảng KHOXE, thực hiện INSERT
            INSERT INTO KHOXE (maXe, soLuongXeCon)
            VALUES (@maXe, @soLuong);
        END;
        
        -- Lấy dòng tiếp theo trong Cursor
        FETCH NEXT FROM cursor_Inserted INTO @maXe, @soLuong;
    END;

    -- Đóng Cursor
    CLOSE cursor_Inserted;
    DEALLOCATE cursor_Inserted;
END;



--------------------------------------------------------------------------------
-- TRIGGER khi xuất hóa đơn mặt hàng cho khách hàng thì sẽ cập nhật lại số lượng hàng trong kho
-- Hóa đơn xe
go
CREATE OR ALTER TRIGGER trg_CapNhatKhoXeKhiBan 
ON HOADON
AFTER INSERT
AS
BEGIN
    -- Declare Cursor để lặp qua các dòng trong bảng inserted
    DECLARE cursor_Inserted CURSOR FOR
    SELECT maXe
    FROM inserted;

    -- Khai báo biến cần sử dụng trong vòng lặp
    DECLARE @maXe NVARCHAR(20);

    -- Mở Cursor
    OPEN cursor_Inserted;
    FETCH NEXT FROM cursor_Inserted INTO @maXe;

    -- Bắt đầu lặp qua từng dòng
    WHILE @@FETCH_STATUS = 0
    BEGIN
        -- Cập nhật số lượng xe trong bảng KHOXE
        UPDATE KHOXE
        SET soLuongXeCon = soLuongXeCon - 1,
            soLuongXeDaBan = soLuongXeDaBan + 1
        WHERE maXe = @maXe;

        -- Lấy dòng tiếp theo trong Cursor
        FETCH NEXT FROM cursor_Inserted INTO @maXe;
    END;

    -- Đóng Cursor
    CLOSE cursor_Inserted;
    DEALLOCATE cursor_Inserted;
END;
go
--------------------------------------------------------------------------------
---- Stored procedure
--Liệt kê thông tin nhân viên theo chi nhánh
go
create or alter proc sp_LietKeNhanVienTheoChiNhanh
@maChiNhanh nvarchar(20)
as
begin
	select * from NHANVIEN where maChiNhanh = @maChiNhanh
end
go
--exec sp_LietKeNhanVienTheoChiNhanh @maChiNhanh = 'CNHN'
-----

-----------------------------------------
--* CHINHANH
go
create or alter proc List_CHINHANH
as 
	select * from CHINHANH
go
-------
create or alter proc Insert_CHINHANH @maChiNhanh nvarchar(20), @tenChiNhanh nvarchar(50), @diaChi nvarchar(255), @soDienThoai nvarchar(20)
as 
	insert into CHINHANH (maChiNhanh, tenChiNhanh, diaChi, soDienThoai) values (@maChiNhanh, @tenChiNhanh, @diaChi, @soDienThoai)
go
-----
create or alter proc Update_CHINHANH @maChiNhanh nvarchar(20), @tenChiNhanh nvarchar(50), @diaChi nvarchar(255), @soDienThoai nvarchar(20) 
as 
	update CHINHANH set tenChiNhanh = @tenChiNhanh, diaChi = @diaChi, soDienThoai = @soDienThoai where maChiNhanh = @maChiNhanh
go
------
create or alter proc Delete_CHINHANH @maChiNhanh nvarchar(20)
as
	delete CHINHANH where maChiNhanh = @maChiNhanh
go 

----* Dich vu bao duong
go
create or alter proc List_DICHVUBAODUONG
as 
	select * from DICHVUBAODUONG

--exec list_DICHVUBAODUONG
go
-------------------------------------------------------------------
create or alter proc Insert_DICHVUBAODUONG @tenBaoDuong nvarchar(50), @loaiBaoDuong nvarchar(50), @phiBaoDuong bigint
as 
	insert into DICHVUBAODUONG (tenBaoDuong, loaiBaoDuong, phiBaoDuong) values (@tenBaoDuong, @loaiBaoDuong, @phiBaoDuong)

--exec Insert_DICHVUBAODUONG @tenBaoDuong , @loaiBaoDuong , @phiBaoDuong 
go
-------------------------------------------------------------------
create or alter proc Update_DICHVUBAODUONG @maBaoDuong nvarchar(20), @tenBaoDuong nvarchar(50), @loaiBaoDuong nvarchar(50), @phiBaoDuong bigint
as
	update DICHVUBAODUONG set tenBaoDuong = @tenBaoDuong, loaiBaoDuong = @loaiBaoDuong, phiBaoDuong = @phiBaoDuong, maBaoDuong = @maBaoDuong

--exec Update_DICHVUBAODUONG @maBaoDuong , @tenBaoDuong , @loaiBaoDuong , @phiBaoDuong 
go
-------------------------------------------------------------------
create or alter proc Delete_DICHVUBAODUONG  @maBaoDuong nvarchar(20)
as
	delete DICHVUBAODUONG where maBaoDuong =  @maBaoDuong

--exec Delete_DICHVUBAODUONG @maBaoDuong


----PHIEUBAODUONG
go
create or alter proc List_PHIEUBAODUONG
as 
	select * from PHIEUBAODUONG
go

create or alter proc Insert_PHIEUBAODUONG @maBaoDuong nvarchar(20), @ngayLapPhieu date, @tongTien bigint, @maKhachHang nvarchar(20), @maNhanVienThucHien nvarchar(20)
as
	insert into PHIEUBAODUONG (maBaoDuong, ngayLapPhieu, tongTien, maKhachHang, maNhanVienThucHien)
	values (@maBaoDuong, @ngayLapPhieu, @tongTien, @maKhachHang, @maNhanVienThucHien)

go
-------------------------------------------------------------------
create or alter proc Update_PHIEUBAODUONG @maPhieuBaoDuong nvarchar(20), @maBaoDuong nvarchar(20), @ngayLapPhieu date, @tongTien bigint, @maKhachHang nvarchar(20), @maNhanVienThucHien nvarchar(20)
as
	update PHIEUBAODUONG 
	set maBaoDuong = @maBaoDuong, ngayLapPhieu = @ngayLapPhieu, tongTien = @tongTien, 
	maKhachHang = @maKhachHang, maNhanVienThucHien = @maNhanVienThucHien 
	where  maPhieuBaoDuong =  @maPhieuBaoDuong

go
-------------------------------------------------------------------
create or alter proc Delete_PHIEUBAODUONG  @maPhieuBaoDuong nvarchar(20)
as
	delete PHIEUBAODUONG where maPhieuBaoDuong =  @maPhieuBaoDuong

-------------------------------------------------------------------
----* Hoa Don
go
create or alter proc List_HOADON
as 
	select * from HOADON

--exec list_HOADON
go
-------------------------------------------------------------------
create or alter proc Insert_HOADON @ngayLapHoaDon date, @maXe nvarchar(20), @tongTien bigint, @tinhTrang nvarchar(50), @maKhachHang nvarchar(20), @maNhanVienThucHien nvarchar(20)
as 
	insert into HOADON (ngayLapHoaDon, maXe, tongTien, tinhTrang, maKhachHang, maNhanVienThucHien) 
	values (@ngayLapHoaDon, @maXe, @tongTien, @tinhTrang, @maKhachHang, @maNhanVienThucHien)

go
-------------------------------------------------------------------
create or alter proc Update_HOADON @maHoaDon nvarchar(20), @ngayLapHoaDon date, @maXe nvarchar(20), @tongTien bigint, @tinhTrang nvarchar(50), @maKhachHang nvarchar(20), @maNhanVienThucHien nvarchar(20)
as
	update HOADON set ngayLapHoaDon = @ngayLapHoaDon, maXe = @maXe, tongTien = @tongTien, 
	tinhTrang = @tinhTrang, maKhachHang = @maKhachHang,  maNhanVienThucHien = @maNhanVienThucHien
	where  maHoaDon =  @maHoaDon

go
-------------------------------------------------------------------
create or alter proc Delete_HOADON  @maHoaDon nvarchar(20)
as
	delete HOADON where maHoaDon =  @maHoaDon
go
--exec Delete_HOADON @maHoaDon 

--- KHACH HANG
create or alter proc List_KhachHang
as
	select * from KHACHHANG
--exec List_KhachHang


go
create or alter proc Insert_KhachHang @hoTenKhachHang nvarchar(50), @ngaySinh date, @gioiTinh nvarchar(5), @CCCD nvarchar(20), @diaChi nvarchar(255), @soDienThoai nvarchar(20)
as
	insert into KHACHHANG(hoTenKhachHang, ngaySinh, gioiTinh, CCCD, diaChi, soDienThoai) values (@hoTenKhachHang, @ngaySinh, @gioiTinh, @CCCD, @diaChi, @soDienThoai)

--exec Insert_KhachHang @hoTenKhachHang , @ngaySinh , @gioiTinh , @CCCD , @diaChi , @soDienThoai

go
create or alter proc Update_KhachHang @maKhachHang nvarchar(20), @hoTenKhachHang nvarchar(50), @ngaySinh date, @gioiTinh nvarchar(5), @CCCD nvarchar(20), @diaChi nvarchar(255), @soDienThoai nvarchar(20)
as
	Update KHACHHANG set hoTenKhachHang = @hoTenKhachHang, ngaySinh = @ngaySinh, gioiTinh = @gioiTinh, CCCD = @CCCD, diaChi = @diaChi, soDienThoai = @soDienThoai where maKhachHang = @maKhachHang

--exec Update_KhachHang @maKhachHang , @hoTenKhachHang , @ngaySinh , @gioiTinh , @CCCD , @diaChi , @soDienThoai

go
create or alter proc Delete_KhachHang @maKhachHang nvarchar(20)
as
	delete KHACHHANG where maKhachHang = @maKhachHang
--exec Delete_KhachHang @maKhachHang
go

--- Nha Cung cap
create or alter proc List_NhaCungCap
as
	select * from NHACUNGCAP
--exec List_NhaCungCap

go
create or alter proc Insert_NhaCungCap @maNhaCungCap nvarchar(20), @tenNhaCungCap nvarchar(50), @diaChi nvarchar(255), @soDienThoai nvarchar(20)
as
	insert into NHACUNGCAP(maNhaCungCap, tenNhaCungCap, diaChi, soDienThoai) values(@maNhaCungCap,  @tenNhaCungCap, @diaChi, @soDienThoai)

--exec Insert_NhaCungCap @maNhaCungCap , @tenNhaCungCap , @diaChi , @soDienThoai

go
create or alter proc Update_NhaCungCap @maNhaCungCap nvarchar(20), @tenNhaCungCap nvarchar(50), @diaChi nvarchar(255), @soDienThoai nvarchar(20)
as
	Update NHACUNGCAP set tenNhaCungCap = @tenNhaCungCap, diaChi = @diaChi, soDienThoai = @soDienThoai where maNhaCungCap = @maNhaCungCap

--exec Update_NhaCungCap @maNhaCungCap , @tenNhaCungCap , @diaChi , @soDienThoai

go
create or alter proc Delete_NhaCungCap @maNhaCungCap nvarchar(20)
as
	delete NHACUNGCAP where maNhaCungCap = @maNhaCungCap
--exec Delete_NhaCungCap @maNhaCungCap 

---Phieu nhap
go
create or alter proc List_PhieuNhap
as
	select * from PHIEUNHAP
--exec List_PhieuNhap

go
create or alter proc Insert_PhieuNhap @maXe nvarchar(20), @ngayNhap date, @giaNhap bigint, @soLuong int, @maNhaCungCap nvarchar(20), @maChiNhanh nvarchar(20)
as
	insert into PHIEUNHAP (maXe, ngayNhap, giaNhap, soLuong, maNhaCungCap, maChiNhanh) 
	values(@maXe, @ngayNhap, @giaNhap, @soLuong, @maNhaCungCap, @maChiNhanh)

--exec Insert_PhieuNhap @ngayNhap , @maChiNhanh , @maNhaCungCap 


go
create or alter proc Update_PhieuNhap @maPhieuNhap nvarchar(20), @maXe nvarchar(20), @ngayNhap date, @giaNhap bigint, @soLuong int, @maNhaCungCap nvarchar(20), @maChiNhanh nvarchar(20)
as
	update PHIEUNHAP 
	set maXe = @maXe, ngayNhap = @ngayNhap, giaNhap = @giaNhap, soLuong = @soLuong,
	maChiNhanh = @maChiNhanh, maNhaCungCap = @maNhaCungCap 
	where maPhieuNhap = @maPhieuNhap

--exec Update_PhieuNhap @maPhieuNhap , @ngayNhap , @maChiNhanh , @maNhaCungCap 


go
create or alter proc Delete_PhieuNhap @maPhieuNhap nvarchar(20)
as
	delete PHIEUNHAP where maPhieuNhap = @maPhieuNhap

--exec Delete_PhieuNhap @maPhieuNhap 
go
--------------
-- Nhan Vien
go
create or alter proc List_TimKiemNhanVienTheoMaChiNhanh @maChiNhanh nvarchar(20)
as
	select * from NhanVien where maChiNhanh = @maChiNhanh

--exec List_TimKiemNhanVienTheoMaChiNhanh @maChiNhanh

go
create or alter proc List_NhanVien 
as
	select * from NHANVIEN
go

--exec List_NhanVien
create or alter proc Insert_NhanVien 
(
@maNhanVien nvarchar(50), @hoTenNhanVien nvarchar(50), @CCCD nvarchar(20), 
@ngaySinh date, @gioiTinh nvarchar(5), @diaChi nvarchar(255), @soDienThoai nvarchar(20), 
@chucVu nvarchar(50), @tinhTrangLamViec bit, @maChiNhanh nvarchar(20), @hinhAnh nvarchar(300)
)
as
begin
		insert into NHANVIEN 
		(maNhanVien, hoTenNhanVien, CCCD, ngaySinh, gioiTinh, diaChi, soDienThoai, 
		chucVu, tinhTrangLamViec, maChiNhanh, hinhAnh) 
		values (@maNhanVien, @hoTenNhanVien, @CCCD, @ngaySinh, @gioiTinh, @diaChi, 
		@soDienThoai, @chucVu, @tinhTrangLamViec, @maChiNhanh, @hinhAnh)
end
--



go
create or alter proc Update_NhanVien @maNhanVien nvarchar(20), @hoTenNhanVien nvarchar(50), @CCCD nvarchar(20), @ngaySinh date, @gioiTinh nvarchar(5), @diaChi nvarchar(255), @soDienThoai nvarchar(20), @chucVu nvarchar(50), @tinhTrangLamViec bit, @maChiNhanh nvarchar(20), @hinhAnh nvarchar(300)
as
	update NHANVIEN set hoTenNhanVien = @hoTenNhanVien, CCCD = @CCCD, ngaySinh = @ngaySinh, gioiTinh = @gioiTinh, diaChi = @diaChi, soDienThoai = @soDienThoai, chucVu = @chucVu, tinhTrangLamViec = @tinhTrangLamViec, maChiNhanh = @maChiNhanh, hinhAnh = @hinhAnh where maNhanVien = @maNhanVien

--exec Update_NhanVien @maNhanVien, @hoTenNhanVien, @CCCD, @ngaySinh, @gioiTinh, @diaChi, @soDienThoai, @chucVu, @tinhTrangLamViec, @maChiNhanh, @hinhAnh


go
create or alter proc Delete_NhanVien @maNhanVien nvarchar(20)
as
	delete NHANVIEN where maNhanVien = @maNhanVien

--exec Delete_NhanVien @maNhanVien

--------------------- XE
-- Thêm Xe
go
create or alter proc Insert_XE @tenXe nvarchar(50), @mauSac nvarchar(20), @giaBan bigint, @xuatXu nvarchar(50), 
@hangXe nvarchar(50), @phienBanXe nvarchar(50), @trongLuong int,
@congSuatDongCo int, @loaiDongCo nvarchar(50),
@chieuDai int, @chieuRong int, @chieuCao int, @hinhAnh VARBINARY(MAX)
as
begin
	insert into XE 
		(tenXe, mauSac, giaBan,xuatXu, hangXe, phienBanXe, trongLuong,congSuatDongCo,
		loaiDongCo, chieuDai, chieuRong, chieuCao, hinhAnh) 
	values (@tenXe, @mauSac, @giaBan,@xuatXu, @hangXe, @phienBanXe, @trongLuong,
			@congSuatDongCo, @loaiDongCo, @chieuDai, @chieuRong, @chieuCao, @hinhAnh)

end
go

-- Cập nhật xe
create or alter proc Update_XE @maXe nvarchar(20), @tenXe nvarchar(50), @mauSac nvarchar(20), 
@giaBan bigint, @xuatXu nvarchar(50), 
@hangXe nvarchar(50), @phienBanXe nvarchar(50), @trongLuong int,
@congSuatDongCo int, @loaiDongCo nvarchar(50),
@chieuDai int, @chieuRong int, @chieuCao int, @hinhAnh VARBINARY(MAX)
as
begin
		update XE 
		set tenXe = @tenXe, mauSac = @mauSac, giaBan = @giaBan, xuatXu = @xuatXu, hangXe = @hangXe, 
		phienBanXe = @phienBanXe, trongLuong = @trongLuong,
		congSuatDongCo = @congSuatDongCo,
		loaiDongCo = @loaiDongCo, chieuDai = @chieuDai, 
		chieuRong = @chieuRong, chieuCao = @chieuCao, hinhAnh = @hinhAnh
		where maXe = @maXe

	
end
go

--- Xóa xe
create or alter proc Delete_XE @maXe nvarchar(50)
as
begin
	delete XE where maXe = @maXe
end
go
-------------
go
create or alter proc sp_DanhSachNhanVien
as
begin
	select maNhanVien, hoTenNhanVien, ngaySinh, gioiTinh, NV.diaChi, NV.soDienThoai, tenChiNhanh from NHANVIEN NV
	inner join CHINHANH CN on NV.maChiNhanh = CN.maChiNhanh
end
go
---------------------
--create data
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
VALUES ('NVHN0001', N'Nguyễn Văn An', '123456289012', '1990-01-15', N'Nam', N'123 Đường Lê Lợi, Hà Nội', '0932345678', N'Quản lý', 'CNHN', ''),
       ('NVHN0002', N'Trần Thị Bình', '234565890123', '1992-03-20', N'Nữ', N'456 Đường Hà Trung, Hà Nội', '0982654321', N'Nhân viên thu ngân', 'CNHN', ''),
       ('NVHN0003', N'Lê Văn Cường', '345612901234', '1995-05-10', N'Nam', N'789 Đường Lý Thường Kiệt, Hà Nội', '0911234567', N'Nhân viên bảo dưỡng', 'CNHN', ''),
       ('NVHN0004', N'Phạm Thị Dương', '456789322345', '1988-07-05', N'Nữ', N'101 Đường Trần Phú, Hà Nội', '0976543310', N'Nhân viên thu ngân', 'CNHN', ''),
       ('NVHN0005', N'Hoàng Văn Em', '567890144456', '1993-09-25', N'Nam', N'222 Đường Đống Đa, Hà Nội', '0932108876', N'Nhân viên thu ngân', 'CNHN', ''),
       ('NVHN0006', N'Nguyễn Thị Dung', '678932234567', '1997-11-30', N'Nữ', N'333 Đường Nguyễn Du, Hà Nội', '0915432101', N'Nhân viên bảo dưỡng', 'CNHN', ''),
       ('NVHN0007', N'Trần Văn Giang', '789012343278', '1994-02-14', N'Nam', N'444 Đường Bà Triệu, Hà Nội', '0921498765', N'Nhân viên bảo dưỡng', 'CNHN', ''),

	   ('NVHCM0001', N'Lê Thị Hương', '123456712012', '1991-04-20', N'Nữ', N'123 Đường Lê Lai, Hồ Chí Minh', '09123325678', N'Quản lý', 'CNHCM', ''),
       ('NVHCM0002', N'Phạm Văn Hoàng', '234563490123', '1989-06-15', N'Nam', N'456 Đường Nam Kỳ Khởi Nghĩa, Hồ Chí Minh', '0987321321', N'Nhân viên thu ngân', 'CNHCM', ''),
       ('NVHCM0003', N'Nguyễn Thị Khanh', '345678910234', '1990-08-10', N'Nữ', N'789 Đường Võ Văn Tần, Hồ Chí Minh', '0901233567', N'Nhân viên thu ngân', 'CNHCM', ''),
       ('NVHCM0004', N'Nguyễn Minh Khánh', '456909012345', '1996-10-05', N'Nam', N'101 Đường Cách Mạng Tháng Tám, Hồ Chí Minh', '0976543210', N'Nhân viên thu ngân', 'CNHCM', ''),
       ('NVHCM0005', N'Lê Thị Linh', '567890893456', '1987-12-25', N'Nữ', N'222 Đường Lê Duẩn, Hồ Chí Minh', '0932109446', N'Nhân viên bảo dưỡng', 'CNHCM', ''),
       ('NVHCM0006', N'Hoàng Văn Minh', '678972234567', '1992-02-10', N'Nam', N'333 Đường Lý Thường Kiệt, Hồ Chí Minh', '0965452101', N'Nhân viên bảo dưỡng', 'CNHCM', ''),
       ('NVHCM0007', N'Trần Thị Ngân', '789012323278', '1993-05-14', N'Nữ', N'444 Đường Nguyễn Đình Chính, Hồ Chí Minh', '0921033765', N'Nhân viên bảo dưỡng', 'CNHCM', ''),

	   ('NVCT0001', N'Nguyễn Thành Nhân', '123451489012', '1991-03-20', N'Nam', N'123 Đường Hòa Bình, Cần Thơ', '0912343278', N'Quản lý', 'CNCT', ''),
       ('NVCT0002', N'Trần Thị Phương', '234567881123', '1989-05-15', N'Nữ', N'456 Đường Lê Lai, Cần Thơ', '0987654231', N'Nhân viên thu ngân', 'CNCT', ''),
       ('NVCT0003', N'Lê Văn Quang', '345678011234', '1990-07-10', N'Nam', N'789 Đường Võ Văn Kiệt, Cần Thơ', '0901674567', N'Nhân viên thu ngân', 'CNCT', ''),
       ('NVCT0004', N'Phạm Thị Quỳnh', '456229012345', '1996-09-05', N'Nữ', N'101 Đường 30/4, Cần Thơ', '0976501210', N'Nhân viên thu ngân', 'CNCT', ''),
       ('NVCT0005', N'Hoàng Văn Sáng', '569990123456', '1988-11-25', N'Nam', N'222 Đường Cách Mạng Tháng Tám, Cần Thơ', '0932108976', N'Nhân viên bảo dưỡng', 'CNCT', ''),
       ('NVCT0006', N'Nguyễn Thị Thu', '676601234567', '1992-01-10', N'Nữ', N'333 Đường Nguyễn Văn Linh, Cần Thơ', '0965434501', N'Nhân viên bảo dưỡng', 'CNCT', ''),
       ('NVCT0007', N'Trần Văn Nam', '789099345678', '1994-04-14', N'Nam', N'444 Đường 3/2, Cần Thơ', '0921198765', N'Nhân viên bảo dưỡng', 'CNCT', ''),

	   ('NVDN0001', N'Trần Đinh Xu', '123453089012', '1991-02-15', N'Nam', N'123 Đường Bạch Đằng, Đà Nẵng', '0916845678', N'Quản lý', 'CNDN', ''),
       ('NVDN0002', N'Nguyễn Thị Yến', '234590810123', '1989-04-20', N'Nữ', N'456 Đường Lê Duẩn, Đà Nẵng', '0982954321', N'Nhân viên thu ngân', 'CNDN', ''),
       ('NVDN0003', N'Phạm Văn Đồng', '345636901234', '1990-06-10', N'Nam', N'789 Đường 2/9, Đà Nẵng', '0901294567', N'Nhân viên thu ngân', 'CNDN', ''),
       ('NVDN0004', N'Trần Thị Uyên', '576789012345', '1996-08-05', N'Nữ', N'101 Đường Hùng Vương, Đà Nẵng', '0901543210', N'Nhân viên thu ngân', 'CNDN', ''),
       ('NVDN0005', N'Lê Thị Lan', '567899123456', '1988-10-25', N'Nữ', N'222 Đường Phan Đăng Lưu, Đà Nẵng', '0932148876', N'Nhân viên bảo dưỡng', 'CNDN', ''),
       ('NVDN0006', N'Hoàng Văn Mạnh', '638901234567', '1992-12-10', N'Nam', N'333 Đường Hồ Nghinh, Đà Nẵng', '0969132101', N'Nhân viên bảo dưỡng', 'CNDN', ''),
       ('NVDN0007', N'Nguyễn Băng Hà', '789012345678', '1994-03-14', N'Nam', N'444 Đường 3/2, Đà Nẵng', '0921092065', N'Nhân viên bảo dưỡng', 'CNDN', ''),

	   ('NVHUE0001', N'Lê Văn Hưng', '123456789012', '1991-05-20', N'Nam', N'123 Đường Nguyễn Huệ, Huế', '0332345678', N'Quản lý', 'CNHUE', ''),
       ('NVHUE0002', N'Trần Thị Kim Thoa', '234567890123', '1989-07-15', N'Nữ', N'456 Đường 2/9, Huế', '0987654321', N'Nhân viên thu ngân', 'CNHUE', ''),
       ('NVHUE0003', N'Nguyễn Văn Luyện', '345678901234', '1990-09-10', N'Nam', N'789 Đường Điện Biên Phủ, Huế', '0976234567', N'Nhân viên thu ngân', 'CNHUE', ''),
       ('NVHUE0004', N'Văn Thị Ngọc', '456789012345', '1996-01-22', N'Nữ', N'675 Đường Nguyễn Tất Thành, Huế', '0912346729', N'Nhân viên thu ngân', 'CNHUE', ''),
	   ('NVHUE0005', N'Hoàng Văn Thụ', '567890123456', '1988-01-25', N'Nam', N'222 Đường Trường Chinh, Huế', '0932109776', N'Nhân viên bảo dưỡng', 'CNHUE', ''),
       ('NVHUE0006', N'Lê Thị Oanh', '678901234567', '1992-03-10', N'Nữ', N'333 Đường Nguyễn Tất Thành, Huế', '0966632101', N'Nhân viên bảo dưỡng', 'CNHUE', ''),
       ('NVHUE0007', N'Nguyễn Văn Phúc', '789021345678', '1994-06-14', N'Nam', N'444 Đường Đống Đa, Huế', '0921098265', N'Nhân viên bảo dưỡng', 'CNHUE', '');
go

-- Thêm dữ liệu cho bảng TÀI KHOẢN
INSERT INTO TAIKHOAN (maNhanVien, tenDangNhap, matKhau, isAdmin)
VALUES ('NVHN0001', 'admin', '1', 1)
--	   ('2', '1', 'NVHN002'),
--	   ('3', '1', 'NVHN003'),
--	   ('4', '1', 'NVHN004'),
--	   ('5', '1', 'NVHN005'),
--	   ('6', '1', 'NVHN006'),
--	   ('7', '1', 'NVHN007');
go
-- Thêm dữ liệu cho bảng NHÀ CUNG CẤP
INSERT INTO NHACUNGCAP (maNhaCungCap, tenNhaCungCap, diaChi, soDienThoai)
VALUES ('NCC0001', N'Công ty Toyota Việt Nam', N'123 Đường X, Quận Y, TP.HCM', '0123456789'),
	   ('NCC0002', N'Công ty Honda Việt Nam', N'456 Đường P, Quận Q, TP.HCM', '0987654321'),
       ('NCC0003', N'Công ty Ford Việt Nam', N'789 Đường R, Quận S, TP.HCM', '0321654987'),
       ('NCC0004', N'Công ty Nissan Việt Nam', N'101 Đường T, Quận U, TP.HCM', '0765432198'),
       ('NCC0005', N'Công ty Hyundai Việt Nam', N'202 Đường V, Quận W, TP.HCM', '0901234567')
go

-- Nhập xe
INSERT INTO XE (maXe, tenXe, mauSac, giaBan, xuatXu, hangXe, phienBanXe, trongLuong, congSuatDongCo, loaiDongCo, chieuDai, chieuRong, chieuCao, hinhAnh)
VALUES 
	('XE0001', 'Toyota Camry', N'Bạc', 850000000, N'Nhật Bản', 'Toyota', '2.0Q', 1530, 178, 'Xăng A2AR-FE', 4885, 1839, 1440, null),
	('XE0002', 'Hyundai Santa Fe', N'Trắng', 1240000000, N'Hàn Quốc', 'Hyundai', '3.5L Premium', 1764, 277, 'Xăng Smartstream G3.5 MPI', 4785, 1890, 1720, null),
	('XE0003', 'Ford Everest', N'Đen', 1180000000, N'Mỹ', 'Ford', 'Titanium 2.0L Bi-Turbo', 2136, 210, 'Diesel Bi-Turbo', 4893, 1862, 1838, null),
	('XE0004', 'Kia Sorento', N'Xanh', 1059000000, N'Hàn Quốc', 'Kia', '2.5 Signature AWD', 1915, 281, 'Xăng Theta III 2.5L', 4810, 1900, 1700, null),
	('XE0005', 'Mazda CX-8', N'Đỏ', 1249000000, N'Nhật Bản', 'Mazda', 'Premium AWD', 1962, 230, 'Xăng Skyactiv-G 2.5L', 4900, 1840, 1730, null),
	('XE0006', 'Toyota Corolla Altis', N'Đỏ', 746000000, N'Nhật Bản', 'Toyota', '1.8G CVT', 1330, 140, 'Xăng 2ZR-FE', 4630, 1780, 1435, null),
	('XE0007', 'Honda Civic', N'Trắng', 870000000, N'Nhật Bản', 'Honda', 'RS', 1317, 174, 'Xăng 1.5L Turbo', 4678, 1800, 1415, null),
	('XE0008', 'Mazda3', N'Xanh', 669000000, N'Nhật Bản', 'Mazda', '1.5L Luxury', 1315, 110, 'Xăng Skyactiv-G 1.5L', 4660, 1795, 1440, null),
	('XE0009', 'Mitsubishi Xpander', N'Bạc', 620000000, N'Indonesia', 'Mitsubishi', 'AT Premium', 1230, 105, 'Xăng MIVEC 1.5L', 4595, 1750, 1750, null),
	('XE0010', 'Suzuki Ertiga', N'Xám', 499000000, N'Indonesia', 'Suzuki', 'Sport', 1135, 95, 'Xăng K15B 1.5L', 4395, 1735, 1690, null),
	('XE0011', 'Ford Ranger', N'Đen', 625000000, N'Thái Lan', 'Ford', 'Wildtrak 2.0L Bi-Turbo', 2310, 210, 'Diesel Bi-Turbo', 5362, 1860, 1848, null),
	('XE0012', 'Nissan Navara', N'Trắng', 945000000, N'Thái Lan', 'Nissan', 'VL Pro-4X 2.3L', 2230, 190, 'Diesel Twin-Turbo', 5255, 1850, 1825, null),
	('XE0013', 'Mitsubishi Triton', N'Xám', 885000000, N'Thái Lan', 'Mitsubishi', 'Athlete 4x4 AT', 2050, 181, 'Diesel MIVEC 2.4L', 5305, 1815, 1780, null),
	('XE0014', 'Toyota Vios', N'Đỏ', 478000000, N'Việt Nam', 'Toyota', 'E CVT', 1100, 107, 'Xăng 2NR-FE', 4410, 1730, 1475, null),
	('XE0015', 'Hyundai Accent', N'Xanh', 426000000, N'Việt Nam', 'Hyundai', '1.4 AT', 1128, 100, 'Xăng Kappa 1.4L MPI', 4440, 1729, 1470, null),
	('XE0016', 'Mercedes-Benz C-Class', N'Trắng', 1999000000, N'Đức', 'Mercedes-Benz', 'C 200 Avantgarde', 1425, 184, 'Xăng 1.5L Turbo', 4751, 1820, 1438, null),
	('XE0017', 'BMW 3 Series', N'Xanh', 2399000000, N'Đức', 'BMW', '330i M Sport', 1455, 258, 'Xăng 2.0L Turbo', 4709, 1827, 1440, null),
	('XE0018', 'Audi A4', N'Đen', 2160000000, N'Đức', 'Audi', '45 TFSI quattro', 1545, 245, 'Xăng 2.0L Turbo', 4726, 1842, 1427, null),
	('XE0019', 'Lexus ES', N'Nâu', 2890000000, N'Nhật Bản', 'Lexus', 'ES 250 Luxury', 1685, 204, 'Xăng 2.5L Hybrid', 4975, 1865, 1440, null),
	('XE0020', 'Porsche Panamera', N'Bạc', 5460000000, N'Đức', 'Porsche', '4S E-Hybrid', 2185, 560, 'Hybrid V6 2.9L Turbo', 5049, 1937, 1423, null);

go

INSERT INTO PHIEUNHAP (maPhieuNhap, maXe, ngayNhap, giaNhap, soLuong, maNhaCungCap, maChiNhanh)
VALUES ('PN0001', 'XE0001', '2023-10-01', 830000000, 5, 'NCC0001', 'CNHN'),
		('PN0002', 'XE0002', '2023-10-01', 1240000000, 5, 'NCC0002', 'CNHCM'),
		('PN0003', 'XE0003', '2023-10-01', 1180000000, 5,'NCC0003', 'CNHN'),
		('PN0004', 'XE0004', '2023-10-01', 1059000000, 5,'NCC0004', 'CNHUE'),
		('PN0005', 'XE0005', '2023-10-01', 1249000000, 5,'NCC0005', 'CNDN');
go

INSERT INTO KHACHHANG (maKhachHang, hoTenKhachHang, ngaySinh, gioiTinh, CCCD, diaChi, soDienThoai)
VALUES ('KH0001', N'Đặng Gia Thuận', '2000-01-15', N'Nam', '123456789012', N'Hà Nội', '0987654321'),
		('KH0002',N'Nguyễn Thị Lan Anh', '1995-03-20', N'Nữ', '234567890123', N'Hồ Chí Minh', '0901234567'),
		('KH0003',N'Nguyễn Việt Khoa', '1988-05-10', N'Nam', '345678901234', N'Đà Nẵng', '0971234567'),
		('KH0004',N'Phạm Thị Phương Nghi', '1992-09-08', N'Nữ', '456789012345', N'Hà Nội', '0961234567'),
		('KH0005',N'Nguyễn Xuân Thể', '1985-12-25', N'Nam', '567890123456', N'Hồ Chí Minh', '0911234567'),
		('KH0006',N'Nguyễn Hồ Thiên Thanh', '1997-06-30', N'Nữ', '678901234567', N'Đà Nẵng', '0987123456'),
		('KH0007',N'Sú Minh Luân', '1990-03-17', N'Nam', '789012345678', N'Hà Nội', '0921234567'),
		('KH0008',N'Hoàng Võ Ngọc Nguyên', '1999-08-12', N'Nam', '901234567890', N'Đà Nẵng', '0941234567'),
		('KH0009', N'Nguyễn Thị Tuyết', '1999-07-12', N'Nữ', '901234567890', N'Long An', '0941234567');
go

INSERT INTO HOADON (maHoaDon, ngayLapHoaDon, maXe, tongTien, tinhTrang, maKhachHang, maNhanVienThucHien)
VALUES ('HD0001', '2023-10-01', 'XE0001', 1250000, N'Đã thanh toán', 'KH0001', 'NVHN0001'),
		('HD0002', '2023-10-01', 'XE0002', 1250000, N'Đã thanh toán', 'KH0002', 'NVHN0002'),
		('HD0003', '2023-10-01', 'XE0003', 1250000, N'Đã thanh toán', 'KH0003', 'NVHN0003'),
		('HD0004', '2023-10-01', 'XE0004', 1250000, N'Đã thanh toán', 'KH0004', 'NVHN0004'),
		('HD0005', '2023-10-01', 'XE0005', 1250000, N'Đã thanh toán', 'KH0005', 'NVHN0005');
go

INSERT INTO DICHVUBAODUONG (maBaoDuong, tenBaoDuong, loaiBaoDuong, phiBaoDuong)
VALUES ('DVBD0001', N'Bảo dưỡng định kỳ', N'Định kỳ 5.000km', 200000),
		('DVBD0002', N'Bảo dưỡng định kỳ', N'Định kỳ 10.000km', 300000),
		('DVBD0003', N'Thay dầu máy', N'Thay dầu máy', 150000),
		('DVBD0004', N'Thay lọc gió', N'Thay lọc gió', 100000),
		('DVBD0005', N'Kiểm tra phanh', N'Kiểm tra phanh', 120000),
		('DVBD0006', N'Điều chỉnh lốp', N'Điều chỉnh lốp', 80000),
		('DVBD0007', N'Rửa xe', N'Rửa xe', 50000),
		('DVBD0008', N'Thay bugi', N'Thay bugi', 70000),
		('DVBD0009', N'Kiểm tra hệ thống điện', N'Kiểm tra hệ thống điện', 90000),
		('DVBD0010', N'Điều chỉnh đèn', N'Điều chỉnh đèn', 60000);
go

INSERT INTO PHIEUBAODUONG (maPhieuBaoDuong, maBaoDuong, ngayLapPhieu, tongTien, maKhachHang, maNhanVienThucHien)
VALUES ('PBD0001', 'DVBD0003', '2023-10-01', 150000, 'KH0001', 'NVHN0007'),
		('PBD0002', 'DVBD0003', '2023-10-01', 150000, 'KH0002', 'NVHN0007')
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
--update XE set hinhAnh = 
----------------------------------------
-- insert nhiều phiếu nhập
go
begin tran
DECLARE @startDatePHIEUNHAP DATE = '2021-01-01'; 
DECLARE @endDatePHIEUNHAP DATE = '2024-04-30';
DECLARE @maXePHIEUNHAP nvarchar(20), @giaNhap bigint, @maNhaCC nvarchar(20), @maChiNhanh nvarchar(20);
WHILE @startDatePhieuNhap <= @endDatePhieuNhap
BEGIN
	SET @maXePHIEUNHAP = (select top 1 maXe from XE ORDER BY NEWID())
	SET @giaNhap = (select giaBan from XE where maXe = @maXePHIEUNHAP) - 20000000
	set @maNhaCC = (select top 1 maNhaCungCap from NHACUNGCAP ORDER BY NEWID())
	set @maChiNhanh = (select top 1 maChiNhanh from CHINHANH ORDER BY NEWID())

    INSERT INTO PHIEUNHAP(maXe, ngayNhap, giaNhap, soLuong, maNhaCungCap, maChiNhanh)
    VALUES 
        (@maXePHIEUNHAP, @startDatePhieuNhap, @giaNhap, RAND()*9 + 1, @maNhaCC, @maChiNhanh)
    SET @startDatePhieuNhap = DATEADD(DAY, 5, @startDatePhieuNhap);
END;
rollback

----- insert nhiều hóa đơn
begin  tran
DECLARE @startDateHOADON DATE = '2021-01-01';
DECLARE @endDateHOADON DATE = '2024-04-30';
DECLARE @maXe nvarchar(20), @tongTien bigint, @maNhanVien nvarchar(20), @maKhachHang nvarchar(20)
WHILE @startDateHOADON <= @endDateHOADON
BEGIN
	SET @maXe = (select top 1 maXe from XE ORDER BY NEWID())
	SET @tongTien = (select giaBan from XE where maXe = @maXe) + 20000000
	SET @maNhanVien = (select top 1 maNhanVien from NHANVIEN ORDER BY NEWID())
	SET @maKhachHang = (select top 1 maKhachHang from KHACHHANG ORDER BY NEWID())
    INSERT INTO HOADON (ngayLapHoaDon, maXe, tongTien, tinhTrang, maKhachHang, maNhanVienThucHien)
    VALUES (@startDateHOADON, @maXe, @tongTien, N'Đã thanh toán', @maKhachHang, @maNhanVien)
    SET @startDateHOADON = DATEADD(DAY, 2, @startDateHOADON);
END;
rollback

-- Truy vấn lấy dữ liệu tạo biểu đồ
begin tran
SELECT FORMAT(ngayLapHoaDon, 'MM/yyyy') AS MonthYear, Sum(tongTien) AS TotalHoaDon 
FROM HOADON 
GROUP BY FORMAT(ngayLapHoaDon, 'MM/yyyy')
ORDER BY MIN(ngayLapHoaDon) DESC

select FORMAT(ngayNhap, 'MM/yyyy') as MonthYear, Sum(giaNhap * soLuong) as TotalPhieuNhap 
from PHIEUNHAP 
GROUP BY FORMAT(ngayNhap, 'MM/yyyy')
ORDER BY MIN(ngayNhap) DESC
rollback








