use JAVA_DOAN_QUANLYCUAHANGXE
go

go
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

--create or alter trigger trg_CapNhatKhoXeKhiBan 
--on CHITIETHOADONXE
--after insert
--as
--begin
--	declare @maXe nvarchar(20)
--	set @maXe = (select maXe from inserted)
--	update KHOXE
--	set soLuongXeCon = soLuongXeCon - 1, soLuongXeDaBan = soLuongXeDaBan + 1
--	where maXe = @maXe
	
--end
--go
--------------------------------------------------------------------------------
