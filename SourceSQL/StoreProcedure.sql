use JAVA_DOAN_QUANLYCUAHANGXE
go

--Liệt kê thông tin nhân viên theo chi nhánh
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
	values(@maXe, @ngayNhap, @giaNhap, @soLuong, @maChiNhanh, @maNhaCungCap)

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
@chieuDai int, @chieuRong int, @chieuCao int, @hinhAnh nvarchar(300)
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
@chieuDai int, @chieuRong int, @chieuCao int, @hinhAnh nvarchar(300)
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

