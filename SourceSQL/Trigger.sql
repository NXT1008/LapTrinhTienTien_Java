use JAVA_DOAN_QUANLYCUAHANGXE
go

----------------------------------------------------------------
CREATE or ALTER TRIGGER tg_ThayDoiTrangThaiHoaDon on CHITIETHOADONXE 
for update, insert as
BEGIN
	DECLARE @soTienDaTra money, @maHoaDon nvarchar(20), @tongTien money
	SELECT @soTienDaTra = ins.soTienDaTra, @maHoaDon = ins.maHoaDon FROM inserted as ins
	SElECT @tongTien = hd.tongTien FROM HOADON as hd WHERE hd.maHoaDon = @maHoaDon
	IF @tongTien <= @soTienDaTra
	BEGIN 
		UPDATE HOADON 
		SET tinhTrang = N'Đã Thanh Toán'
		WHERE maHoaDon = @maHoaDon
	END
END
go
--------------------------------------------------------------------------------
--Trigger khi nhập hàng về chi nhánh thì sẽ cập nhật vào kho
---------- Cập nhật kho xe

create or alter trigger trg_CapNhatKhoXeKhiNhapHang
on CHITIETPHIEUNHAPXE
after insert 
as
begin
	declare @maXe nvarchar(20), @soLuong int
	select @maXe = maXe, @soLuong = soLuong
	from PHIEUNHAP PN
	inner join inserted
	on PN.maPhieuNhap = inserted.maPhieuNhap

	if ((@maXe in (select maXe from KHOXE)) )
	begin
		Update KHOXE
		set soLuongXeCon = soLuongXeCon + @soLuong
		where maXe = @maXe
	end
	else
	begin
		insert into KHOXE(maXe, soLuongXeCon)
		values(@maXe, @soLuong)
	end 
end
go
--------------------------------------------------------------------------------
-- TRIGGER khi xuất hóa đơn mặt hàng cho khách hàng thì sẽ cập nhật lại số lượng hàng trong kho
-- Hóa đơn xe
create or alter trigger trg_CapNhatKhoXeKhiBan 
on CHITIETHOADONXE
after insert
as
begin
	declare @maXe nvarchar(20)
	set @maXe = (select maXe from inserted)
	update KHOXE
	set soLuongXeCon = soLuongXeCon - 1, soLuongXeDaBan = soLuongXeDaBan + 1
	where maXe = @maXe
	
end
go
--------------------------------------------------------------------------------
