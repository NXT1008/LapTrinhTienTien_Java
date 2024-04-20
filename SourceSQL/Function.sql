use JAVA_DOAN_QUANLYCUAHANGXE
go

-------------------------------------------------------------------------
-- Function tự động sinh mã bảo dưỡng
create or alter function fn_SinhMaBaoDuong()
returns nvarchar(20)
as
begin
	declare @nextID nvarchar(20), @lastID nvarchar(20)
	select @lastID = ISNULL(MAX(CAST(SUBSTRING(maBaoDuong, 5, LEN(maBaoDuong) - 4) as int)) , 0) 
	from DICHVUBAODUONG

	if (@lastID < 999)
		set @nextID = 'DVBD' + RIGHT('000' + CAST(ISNULL(@lastID, 0) + 1 as nvarchar), 3)
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

	if (@LastID < 999)
		set @NextID = 'PBD' + RIGHT('000' + CAST(ISNULL(@LastID, 0) + 1 as nvarchar), 3)
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

	if (@LastID < 999)
		set @NextID = 'KH' + RIGHT('000' + CAST(ISNULL(@LastID, 0) + 1 as nvarchar), 3)
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
	if (@LastId < 999)
	begin
		set @NewId = 'PN' + RIGHT('000' + CAST(ISNULL(@LastId, 0) + 1 as nvarchar), 3)
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
	if (@LastID < 999)
	begin
		set @NewID = 'HD' + RIGHT('000' + CAST(ISNULL(@LastID, 0) + 1 as nvarchar), 3)
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
	if (@LastID < 999)
	begin
		set @NewID = 'XE' + RIGHT('000' + CAST(ISNULL(@LastID, 0) + 1 as nvarchar), 3)
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

