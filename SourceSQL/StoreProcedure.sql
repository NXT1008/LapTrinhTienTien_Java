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
create or alter proc Insert_CHINHANH @maChiNhanh nvarchar(20), @tenChiNhanh nvarchar(50), @diaChi nvarchar(255)
as 
	insert into CHINHANH (maChiNhanh, tenChiNhanh, diaChi) values (@maChiNhanh, @tenChiNhanh, @diaChi)
go
-----
create or alter proc Update_CHINHANH @tenChiNhanh nvarchar(50), @diaChi nvarchar(255), @maChiNhanh nvarchar(20)
as 
	update CHINHANH set tenChiNhanh = @tenChiNhanh, diaChi = @diaChi where maChiNhanh = @maChiNhanh
go
------
create or alter proc Delete_CHINHANH @maChiNhanh nvarchar(20)
as
	delete CHINHANH where maChiNhanh = @maChiNhanh
go 

----* Chi tiết hóa đơn xe
go
create or alter proc List_CHITIETHOADONXE
as 
	select * from CHITIETHOADONXE
go
-------------------------------------------------------------------
create or alter proc Insert_CHITIETHOADONXE  @maHoaDon nvarchar(20), @maXe nvarchar(20), @ngayNhanXe nvarchar(50), @soTienDaTra money, @phiDangKyBienSo money  ,@phiDangKiem money , @phiTruocBa money, @phiBaoHiemTrachNhiemDanSu money, @phiSuDungDuongBo money
as 
	insert into CHITIETHOADONXE (maHoaDon, maXe, ngayNhanXe, soTienDaTra, phiDangKyBienSo, phiDangKiem, phiTruocBa, phiBaoHiemTrachNhiemDanSu, phiSuDungDuongBo)
	values (@maHoaDon, @maXe, @ngayNhanXe, @soTienDaTra, @phiDangKyBienSo, @phiDangKiem, @phiTruocBa, @phiBaoHiemTrachNhiemDanSu, @phiSuDungDuongBo)

--exec Insert_CHITIETHOADONXE @maHoaDon , @maXe , @ngayNhanXe , @soTienDaTra, @phiDangKyBienSo, @phiDangKiem, @phiTruocBa, @phiBaoHiemTrachNhiemDanSu, @phiSuDungDuongBo
go
-------------------------------------------------------------------
create or alter proc Update_CHITIETHOADONXE @maChiTietHoaDonXe nvarchar(20), @maHoaDon nvarchar(20), @maXe nvarchar(20),  @ngayNhanXe nvarchar(50),   @soTienDaTra money, @phiDangKyBienSo money, @phiDangKiem money, @phiTruocBa money, @phiBaoHiemTrachNhiemDanSu money, @phiSuDungDuongBo money
as 
	update CHITIETHOADONXE set maHoaDon = @maHoaDon, maXe = @maXe, ngayNhanXe = @ngayNhanXe, soTienDaTra = @soTienDaTra, phiDangKyBienSo = @phiDangKyBienSo, phiDangKiem = @phiDangKiem, phiTruocBa = @phiTruocBa, phiBaoHiemTrachNhiemDanSu = @phiBaoHiemTrachNhiemDanSu, phiSuDungDuongBo = @phiSuDungDuongBo where maChiTietHoaDonXe = @maChiTietHoaDonXe

-------------------------------------------------------------------
go
create or alter proc Delete_CHITIETHOADONXE @maChiTietHoaDonXe nvarchar(20)
as
	delete CHITIETHOADONXE where maChiTietHoaDonXe = @maChiTietHoaDonXe

--* Chi tiết phiếu bảo dương
go
create or alter proc List_CHITIETPHIEUBAODUONG
as 
	select * from CHITIETPHIEUBAODUONG

--exec list_CHITIETPHIEUBAODUONG
go
-------------------------------------------------------------------
create or alter proc Insert_CHITIETPHIEUBAODUONG @maBaoDuong nvarchar(20), @maPhieuBaoDuong nvarchar(20), @thanhTien float
as 
	insert into CHITIETPHIEUBAODUONG (maBaoDuong, maPhieuBaoDuong, thanhTien) values (@maBaoDuong, @maPhieuBaoDuong, @thanhTien)

--exec Insert_CHITIETPHIEUBAODUONG @maBaoDuong , @maPhieuBaoDuong , @thanhTien 
-------------------------------------------------------------------
go
create or alter proc Update_CHITIETPHIEUBAODUONG @maChiTietPhieuBaoDuong nvarchar(20), @maBaoDuong nvarchar(20), @maPhieuBaoDuong nvarchar(20), @thanhTien float
as
	update CHITIETPHIEUBAODUONG set maBaoDuong = @maBaoDuong, maPhieuBaoDuong = @maPhieuBaoDuong, thanhTien = @thanhTien where maChiTietPhieuBaoDuong = @maChiTietPhieuBaoDuong

--exec Update_CHITIETPHIEUBAODUONG @maChiTietPhieuBaoDuong , @maBaoDuong , @maPhieuBaoDuong , @thanhTien 
go
-------------------------------------------------------------------
create or alter proc Delete_CHITIETPHIEUBAODUONG @maChiTietPhieuBaoDuong nvarchar(20)
as
	delete CHITIETPHIEUBAODUONG where maChiTietPhieuBaoDuong = @maChiTietPhieuBaoDuong


-----* Chi tiet phieu nhap xe
go
create or alter proc List_CHITIETPHIEUNHAPXE
as 
	select * from CHITIETPHIEUNHAPXE
go
-------------------------------------------------------------------
create or alter proc Insert_CHITIETPHIEUNHAPXE @maXe  nvarchar(20), @maPhieuNhap nvarchar(20), @giaNhap float, @soLuong int
as 
	insert into CHITIETPHIEUNHAPXE (maXe, maPhieuNhap, giaNhap, soLuong) values (@maXe, @maPhieuNhap, @giaNhap, @soLuong)

go
-------------------------------------------------------------------
create or alter proc Update_CHITIETPHIEUNHAPXE  @maChiTietPhieuNhapXe nvarchar(20), @maXe nvarchar(20), @maPhieuNhap nvarchar(20), @giaNhap float, @soLuong int
as
	update CHITIETPHIEUNHAPXE set maXe = @maXe, maPhieuNhap = @maPhieuNhap, giaNhap = @giaNhap, soLuong = @soLuong where maChiTietPhieuNhapXe = @maChiTietPhieuNhapXe

--exec Update_CHITIETPHIEUNHAPXE @maChiTietPhieuNhapXe , @maXe , @maPhieuNhap , @giaNhap , @soLuong 
go
-------------------------------------------------------------------
create or alter proc Delete_CHITIETPHIEUNHAPXE  @maChiTietPhieuNhapXe nvarchar(20)
as
	delete CHITIETPHIEUNHAPXE where maChiTietPhieuNhapXe =  @maChiTietPhieuNhapXe

--exec Delete_CHITIETPHIEUNHAPXE @maChiTietPhieuNhapXe 

----* Dich vu bao duong
go
create or alter proc List_DICHVUBAODUONG
as 
	select * from DICHVUBAODUONG

--exec list_DICHVUBAODUONG
go
-------------------------------------------------------------------
create or alter proc Insert_DICHVUBAODUONG @tenBaoDuong nvarchar(50), @loaiBaoDuong nvarchar(50), @phiBaoDuong float
as 
	insert into DICHVUBAODUONG (tenBaoDuong, loaiBaoDuong, phiBaoDuong) values (@tenBaoDuong, @loaiBaoDuong, @phiBaoDuong)

--exec Insert_DICHVUBAODUONG @tenBaoDuong , @loaiBaoDuong , @phiBaoDuong 
go
-------------------------------------------------------------------
create or alter proc Update_DICHVUBAODUONG @maBaoDuong nvarchar(20), @tenBaoDuong nvarchar(50), @loaiBaoDuong nvarchar(50), @phiBaoDuong float
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

create or alter proc Insert_PHIEUBAODUONG @ngayLapPhieu date, @tongTien float, @maKhachHang nvarchar(20), @maNhanVienThucHien nvarchar(20)
as
	insert into PHIEUBAODUONG (ngayLapPhieu, tongTien, maKhachHang, maNhanVienThucHien) values (@ngayLapPhieu, @tongTien, @maKhachHang, @maNhanVienThucHien)

go
-------------------------------------------------------------------
create or alter proc Update_PHIEUBAODUONG @maPhieuBaoDuong nvarchar(20), @ngayLapPhieu date, @tongTien float, @maKhachHang nvarchar(20), @maNhanVienThucHien nvarchar(20)
as
	update PHIEUBAODUONG set ngayLapPhieu = @ngayLapPhieu, tongTien = @tongTien, maKhachHang = @maKhachHang,  maNhanVienThucHien = @maNhanVienThucHien where  maPhieuBaoDuong =  @maPhieuBaoDuong

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
create or alter proc Insert_HOADON @ngayLapHoaDon date, @tongTien float, @tinhTrang nvarchar(50), @maKhachHang nvarchar(20), @maNhanVienThucHien nvarchar(20)
as 
	insert into HOADON (ngayLapHoaDon, tongTien, tinhTrang, maKhachHang, maNhanVienThucHien) values (@ngayLapHoaDon, @tongTien, @tinhTrang, @maKhachHang, @maNhanVienThucHien)

go
-------------------------------------------------------------------
create or alter proc Update_HOADON @maHoaDon nvarchar(20), @ngayLapHoaDon date, @tongTien float, @tinhTrang nvarchar(50), @maKhachHang nvarchar(20), @maNhanVienThucHien nvarchar(20)
as
	update HOADON set ngayLapHoaDon = @ngayLapHoaDon, tongTien = @tongTien, tinhTrang = @tinhTrang, maKhachHang = @maKhachHang,  maNhanVienThucHien = @maNhanVienThucHien where  maHoaDon =  @maHoaDon

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
create or alter proc Insert_PhieuNhap @ngayNhap date, @maChiNhanh nvarchar(20), @maNhaCungCap nvarchar(20)
as
	insert into PHIEUNHAP(ngayNhap, maChiNhanh, maNhaCungCap) values(@ngayNhap, @maChiNhanh, @maNhaCungCap)

--exec Insert_PhieuNhap @ngayNhap , @maChiNhanh , @maNhaCungCap 


go
create or alter proc Update_PhieuNhap @maPhieuNhap nvarchar(20), @ngayNhap date, @maChiNhanh nvarchar(20), @maNhaCungCap nvarchar(20)
as
	update PHIEUNHAP set ngayNhap = @ngayNhap, maChiNhanh = @maChiNhanh, maNhaCungCap = @maNhaCungCap where maPhieuNhap = @maPhieuNhap

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
@hoTenNhanVien nvarchar(50), @CCCD nvarchar(20), 
@ngaySinh date, @gioiTinh nvarchar(5), @diaChi nvarchar(255), @soDienThoai nvarchar(20), 
@chucVu nvarchar(50), @tinhTrangLamViec bit, @maChiNhanh nvarchar(20), @hinhAnh nvarchar(300)
)
as
begin
	begin try
		insert into NHANVIEN 
		(hoTenNhanVien, CCCD, ngaySinh, gioiTinh, diaChi, soDienThoai, 
		chucVu, tinhTrangLamViec, maChiNhanh, hinhAnh) 
		values (@hoTenNhanVien, @CCCD, @ngaySinh, @gioiTinh, @diaChi, 
		@soDienThoai, @chucVu, @tinhTrangLamViec, @maChiNhanh, @hinhAnh)
	end try

	begin catch
		DECLARE @errorMessage NVARCHAR(4000)
		SET @errorMessage = ERROR_MESSAGE();
		IF @errorMessage LIKE '%contr_NHANVIEN_checkLenSDT%'
			RAISERROR(N'Số điện thoại phải có 10 hoặc 11 chữ số', 16, 1)
		ELSE IF @errorMessage LIKE '%contr_NhanVien_checkLenCCCD%'
			RAISERROR(N'CCCD phải có 12 chữ số', 16, 1)
		ELSE IF @errorMessage LIKE '%contr_NhanVien_conflictCCCD%'
			RAISERROR(N'CCCD bị trùng với nhân viên khác', 16, 1)
		ELSE IF @errorMessage LIKE '%contr_NhanVien_conflictSDT%'
			RAISERROR(N'Số điện thoại bị trùng với nhân viên khác', 16, 1)
	end catch

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
create or alter proc Insert_XE @tenXe nvarchar(50), @mauSac nvarchar(20), @giaBan float, @soChoNgoi int, @xuatXu nvarchar(50), 
@hangXe nvarchar(50), @loaiXe nvarchar(50), @phienBanXe nvarchar(50), @trongLuong int,
@loaiNhienLieu nvarchar(50), @congSuatDongCo int, @dungTichDongCo int, @loaiDongCo nvarchar(50), @khoangSangGam int, 
@chieuDai int, @chieuRong int, @chieuCao int, @hinhAnh nvarchar(300)
as
begin
	begin try
		insert into XE 
		(tenXe, mauSac, giaBan, soChoNgoi, xuatXu, hangXe, 
		loaiXe, phienBanXe, trongLuong, loaiNhienLieu, congSuatDongCo,
		dungTichDongCo, loaiDongCo, khoangSangGam, chieuDai, chieuRong, chieuCao, hinhAnh) 
		values (@tenXe, @mauSac, @giaBan, @soChoNgoi, @xuatXu, @hangXe, @loaiXe, @phienBanXe, @trongLuong,
				@loaiNhienLieu, @congSuatDongCo, @dungTichDongCo, @loaiDongCo, @khoangSangGam, 
				@chieuDai, @chieuRong, @chieuCao, @hinhAnh)
	end try

	begin catch
		DECLARE @errorMessage NVARCHAR(4000)
		SET @errorMessage = ERROR_MESSAGE();
		IF @errorMessage LIKE '%contr_XE_checkGiaBan%'
			RAISERROR(N'Giá bán phải lớn hơn 0', 16, 1)
		ELSE IF @errorMessage LIKE '%contr_XE_checkSoChoNgoi%'
			RAISERROR(N'Số chỗ ngồi phải lớn hơn 2', 16, 1)
		ELSE IF @errorMessage LIKE '%contr_XE_checkTrongLuong%'
			RAISERROR(N'Trọng lượng xe phải lớn hơn 0', 16, 1)
		ELSE IF @errorMessage LIKE '%contr_XE_checkCongSuatDongCo%'
			RAISERROR(N'Công suất động cơ phải lớn hơn 0', 16, 1)
		ELSE IF @errorMessage LIKE '%contr_XE_checkDungTichDongCo%'
			RAISERROR(N'Dung tích động cơ phải lớn hơn 0', 16, 1)
			ELSE IF @errorMessage LIKE '%contr_XE_checkKhoangSangGam%'
			RAISERROR(N'Khoảng sáng gầm phải lớn hơn 0', 16, 1)
		ELSE IF @errorMessage LIKE '%contr_XE_checkChieuDai%'
			RAISERROR(N'Chiều dài xe phải lớn hơn 0', 16, 1)
			ELSE IF @errorMessage LIKE '%contr_XE_checkChieuRong%'
			RAISERROR(N'Chiều rộng xe phải lớn hơn 0', 16, 1)
		ELSE IF @errorMessage LIKE '%contr_XE_checkChieuCao%'
			RAISERROR(N'Chiều cao xe phải lớn hơn 0', 16, 1)
	end catch
end
go

-- Cập nhật xe
create or alter proc Update_XE @maXe nvarchar(20), @tenXe nvarchar(50), @mauSac nvarchar(20), @giaBan float, @soChoNgoi int, @xuatXu nvarchar(50), 
@hangXe nvarchar(50), @loaiXe nvarchar(50), @phienBanXe nvarchar(50), @trongLuong int,
@loaiNhienLieu nvarchar(50), @congSuatDongCo int, @dungTichDongCo int, @loaiDongCo nvarchar(50), @khoangSangGam int, 
@chieuDai int, @chieuRong int, @chieuCao int, @hinhAnh nvarchar(300)
as
begin
	begin try
		update XE 
		set tenXe = @tenXe, mauSac = @mauSac, giaBan = @giaBan, soChoNgoi = @soChoNgoi, xuatXu = @xuatXu, hangXe = @hangXe, 
		loaiXe = @loaiXe, phienBanXe = @phienBanXe, trongLuong = @trongLuong,
		loaiNhienLieu = @loaiNhienLieu, congSuatDongCo = @congSuatDongCo, dungTichDongCo = @dungTichDongCo, 
		loaiDongCo = @loaiDongCo, khoangSangGam = @khoangSangGam, chieuDai = @chieuDai, 
		chieuRong = @chieuRong, chieuCao = @chieuCao, hinhAnh = @hinhAnh
		where maXe = @maXe
	end try

	begin catch
		DECLARE @errorMessage NVARCHAR(4000)
		SET @errorMessage = ERROR_MESSAGE();
		IF @errorMessage LIKE '%contr_XE_checkGiaBan%'
			RAISERROR(N'Giá bán phải lớn hơn 0', 16, 1)
		ELSE IF @errorMessage LIKE '%contr_XE_checkSoChoNgoi%'
			RAISERROR(N'Số chỗ ngồi phải lớn hơn 2', 16, 1)
		ELSE IF @errorMessage LIKE '%contr_XE_checkTrongLuong%'
			RAISERROR(N'Trọng lượng xe phải lớn hơn 0', 16, 1)
		ELSE IF @errorMessage LIKE '%contr_XE_checkCongSuatDongCo%'
			RAISERROR(N'Công suất động cơ phải lớn hơn 0', 16, 1)
		ELSE IF @errorMessage LIKE '%contr_XE_checkDungTichDongCo%'
			RAISERROR(N'Dung tích động cơ phải lớn hơn 0', 16, 1)
			ELSE IF @errorMessage LIKE '%contr_XE_checkKhoangSangGam%'
			RAISERROR(N'Khoảng sáng gầm phải lớn hơn 0', 16, 1)
		ELSE IF @errorMessage LIKE '%contr_XE_checkChieuDai%'
			RAISERROR(N'Chiều dài xe phải lớn hơn 0', 16, 1)
			ELSE IF @errorMessage LIKE '%contr_XE_checkChieuRong%'
			RAISERROR(N'Chiều rộng xe phải lớn hơn 0', 16, 1)
		ELSE IF @errorMessage LIKE '%contr_XE_checkChieuCao%'
			RAISERROR(N'Chiều cao xe phải lớn hơn 0', 16, 1)
	end catch
end
go

--- Xóa xe
create or alter proc Delete_XE @maXe nvarchar(50)
as
begin
	delete XE where maXe = @maXe
end
go

----------------
-- Proc thống kê hóa đơn
create or alter proc sp_HoaDon @maHoaDon nvarchar(20)
as
begin
	select HD.maHoaDon, NV.hoTenNhanVien, HD.ngayLapHoaDon, 
	KH.hoTenKhachHang, KH.diaChi, KH.soDienThoai, XE.tenXe, Xe.xuatXu, Xe.hangXe, 
	XE.loaiXe, CTX.ngayNhanXe, CTX.soTienDaTra, HD.tongTien
	from HOADON HD 
	inner join CHITIETHOADONXE CTX on HD.maHoaDon = CTX.maHoaDon 
	inner join KHACHHANG KH on HD.maKhachHang = KH.maKhachHang
	inner join NHANVIEN NV on HD.maNhanVienThucHien = NV.maNhanVien 
	inner join XE on CTX.maXe = XE.maXe
	where HD.maHoaDon = @maHoaDon
end
go

go
create or alter proc sp_DanhSachNhanVien
as
begin
	select maNhanVien, hoTenNhanVien, ngaySinh, gioiTinh, NV.diaChi, soDienThoai, tenChiNhanh from NHANVIEN NV
	inner join CHINHANH CN on NV.maChiNhanh = CN.maChiNhanh
end
go

-----
create or alter proc sp_PHIEUNHAP @maPhieuNhap nvarchar(20)
as
begin
	select PN.maPhieuNhap, PN.ngayNhap,  CN.tenChiNhanh, NCC.tenNhaCungCap, 
	XE.tenXe, giaNhap, soLuong, giaNhap*soLuong as tongTien
	from PHIEUNHAP PN
	inner join CHITIETPHIEUNHAPXE CTPNX on PN.maPhieuNhap = CTPNX.maPhieuNhap
	inner join NHACUNGCAP NCC on PN.maNhaCungCap = NCC.maNhaCungCap
	inner join CHINHANH CN on PN.maChiNhanh = CN.maChiNhanh
	inner join XE on CTPNX.maXe = XE.maXe
	where PN.maPhieuNhap = @maPhieuNhap
end
go

