CREATE DATABASE QLCuaHangBanLKDT

DROP DATABASE QLCuaHangBanLKDT

USE QLCuaHangBanLKDT

CREATE TABLE DangNhap
(
    TaiKhoan VARCHAR(30) NOT NULL,
    MatKhau VARCHAR(300) NOT NULL,
    CONSTRAINT Pr_key PRIMARY KEY (TaiKhoan,MatKhau),
    Quyen VARCHAR(30),
    NhoMatKhau BIT
)


DROP TABLE DangNhap

SELECT *
FROM DangNhap

INSERT INTO DangNhap (TaiKhoan, MatKhau, Quyen, NhoMatKhau) VALUES
    ('duyhieu', 'hvlKxczGhIC8bYRiUfesaA==', 'ADMIN', 0),
    ('nhanvien', '9Q8qqDCOK9jEZZyKmmi/MQ==', 'USER', 0);



CREATE TABLE LinhKien
(
    MaLK VARCHAR(10) PRIMARY KEY,
    TenLK NVARCHAR(100),
    Loai NVARCHAR(100),
    SoLuong INT,
    GiaBan FLOAT,
    Hang NVARCHAR(100),
    HanBaoHanh  NVARCHAR(100),
)

DROP TABLE LinhKien

SELECT * FROM LinhKien

INSERT INTO LinhKien (MaLK, TenLK, SoLuong, Loai, GiaBan, Hang, HanBaoHanh) VALUES
    ('MA01', N'Main A',10 , N'Main', 100000, N'Iphone', N'14 ngày'),
    ('MA02', N'Main B',10 , N'Main', 100000, N'SamSung', N'14 ngày'),
    ('PI01', N'Pin A',12 , N'Pin', 300000, N'Iphone', N'14 ngày'),
    ('PI02', N'Pin B',15 , N'Pin', 500000, N'SamSung', N'14 ngày'),
    ('CA01', N'Camera A',30 , N'Camera', 150000, N'Iphone', N'14 ngày'),
    ('CA02', N'Camera B',21, N'Camera', 300000, N'SamSung', N'14 ngày'),
    ('MH01', N'Màn hình B',21, N'Màn hình', 300000, N'Iphone', N'14 ngày'),
    ('MH02', N'Màn hình B',21, N'Màn hình', 300000, N'SamSung', N'14 ngày'),
    ('VO01', N'Vỏ A',30 , N'Vỏ', 150000, N'Iphone', N'14 ngày'),
    ('VO02', N'Vỏ B',21, N'Vỏ', 300000, N'SamSung', N'14 ngày');

DELETE FROM LinhKien WHERE MaLK = 'LK01'


DROP TABLE LinhKien

SELECT * FROM LinhKien

CREATE TABLE LinhKienNhap
(
    MaNhap VARCHAR(10) PRIMARY KEY,
    MaLK VARCHAR(10) NOT NULL,
    CONSTRAINT Fr_MaLK_LinhKienNhap FOREIGN KEY (MaLK) REFERENCES LinhKien(MaLK),
    SoLuong INT,
    GiaNhap FLOAT,
    TongTien FLOAT,
    NgayNhap DATE,
    NguonNhap NVARCHAR(300),
    NguoiNhap NVARCHAR(100),
)

INSERT INTO LinhKienNhap (MaNhap, MaLK, SoLuong, GiaNhap, TongTien, NgayNhap, NguonNhap, NguoiNhap) VALUES
    ('NH02', 'LK01',10 , 100000,  0, '2022-06-01', N'Công ty A', N'Hiếu');

SELECT * FROM LinhKienNhap

DROP TABLE LinhKienNhap

---Cập nhật tổng tiền nhập khi insert

GO 

CREATE TRIGGER Trigger_Insert_LinhKienNhap ON LinhKienNhap FOR INSERT 
AS 
BEGIN
    DECLARE @GiaNhap FLOAT;
    SELECT @GiaNhap = GiaNhap
        FROM LinhKienNhap
        WHERE MaNhap = (SELECT MaNhap
                            FROM INSERTED)

    UPDATE LinhKienNhap 
		SET TongTien = @GiaNhap * (SELECT SoLuong FROM INSERTED)
		WHERE MaNhap = (SELECT MaNhap
                            FROM INSERTED)
END

DROP TRIGGER Trigger_Insert_LinhKienNhap


---Cập nhật số lượng linh kiện, tổng tiền nhập khi update

GO

CREATE PROC CapNhatGia_SoLuong_LinhKien
    @MaNhap VARCHAR(10),
    @MaLK VARCHAR(10),
    @SoLuong INT,
    @GiaNhap FLOAT,
    @NgayNhap DATE,
    @NguonNhap NVARCHAR(300),
    @NguoiNhap NVARCHAR(100)
AS
BEGIN
    DECLARE @SoLuong_old FLOAT

    SELECT @SoLuong_old = SoLuong
        FROM LinhKienNhap
        WHERE MaNhap = @MaNhap

    UPDATE LinhKienNhap 
		SET SoLuong = @SoLuong , GiaNhap = @GiaNhap , NgayNhap = @NgayNhap, NguonNhap = @NguonNhap,
         NguoiNhap = @NguoiNhap
        WHERE MaNhap = @MaNhap;


    UPDATE LinhKienNhap 
		SET TongTien = @GiaNhap * @SoLuong
	    WHERE MaNhap = @MaNhap;

    UPDATE LinhKien 
		SET SoLuong = SoLuong - @SoLuong_old
		WHERE MaLK = @MaLK

    UPDATE LinhKien 
		SET SoLuong = SoLuong + @SoLuong
		WHERE MaLK = @MaLK
END

DROP PROC CapNhatGia_SoLuong_LinhKien

    
CREATE TABLE HoaDon
(
    MaHD VARCHAR(10) PRIMARY KEY,
    MaLK VARCHAR(10) NOT NULL,
    CONSTRAINT Fr_MaLK_HoaDon FOREIGN KEY (MaLK) REFERENCES LinhKien(MaLK),
    SoLuong INT,
    TongTien FLOAT,
    NgayMua DATE,
    HinhThuc NVARCHAR(100),
    MaGiamGia VARCHAR(50),
    CONSTRAINT Fr_MaGiamGia_HoaDon FOREIGN KEY (MaGiamGia) REFERENCES MaGiamGia(Ma),
)

INSERT INTO HoaDon (MaHD, MaLK, SoLuong, TongTien, NgayMua, HinhThuc, MaGiamGia) VALUES
    ('HD01', 'LK01',10 , 0, '2022-06-01', N'Tiền mặt', null);



SELECT *  FROM HoaDon

DROP TABLE HoaDon

SELECT MaHD, LinhKien.TenLK, HoaDon.SoLuong, LinhKien.GiaBan, TongTien, NgayMua, HanBaoHanh, HinhThuc
    FROM HoaDon, LinhKien 
    WHERE HoaDon.MaLK = LinhKien.MaLK AND MaHD = 'HD04';

--- Tính tổng tiền khi insert HoaDon
GO 

CREATE TRIGGER Trigger_Insert_HoaDon ON HoaDon FOR INSERT 
AS 
BEGIN
    DECLARE @GiaBan FLOAT;
    SELECT @GiaBan = GiaBan
        FROM LinhKien
        WHERE MaLK = (SELECT MaLK
                            FROM INSERTED)


   UPDATE HoaDon 
                SET TongTien = @GiaBan * (SELECT SoLuong FROM INSERTED) 
                WHERE MaHD = (SELECT MaHD
                                    FROM INSERTED)

    if( (SELECT (1.0 -PhanTram / 100.0) FROM MaGiamGia 
                WHERE Ma = (SELECT MaGiamGia FROM INSERTED)) != 0)
        BEGIN
            UPDATE HoaDon 
            SET TongTien = @GiaBan * (SELECT SoLuong FROM INSERTED) * (SELECT (1.0 -PhanTram / 100.0) FROM MaGiamGia 
                    WHERE Ma = (SELECT MaGiamGia FROM INSERTED))
            WHERE MaHD = (SELECT MaHD
                                FROM INSERTED)
        END

    UPDATE LinhKien 
        SET SoLuong = SoLuong - (SELECT SoLuong FROM INSERTED)
        WHERE MaLK = (SELECT MaLK FROM INSERTED)
         
END


DROP TRIGGER Trigger_Insert_HoaDon

---Cập nhật số lượng linh kiện, tổng tiền nhập khi update HoaDon

GO

CREATE PROC CapNhatGia_SoLuong_HoaDon
    @MaHD VARCHAR(10),
    @MaLK VARCHAR(10),
    @SoLuong INT,
    @TongTien FLOAT,
    @NgayMua DATE,
    @HinhThuc NVARCHAR(100),
    @MaGiamGia VARCHAR(50)
AS
BEGIN
    DECLARE @SoLuong_old FLOAT

    SELECT @SoLuong_old = SoLuong
        FROM HoaDon
        WHERE MaHD = @MaHD;

    UPDATE HoaDon 
		SET SoLuong = @SoLuong, NgayMua = @NgayMua, HinhThuc = @HinhThuc
        WHERE MaHD = @MaHD;


    UPDATE HoaDon 
		SET TongTien = @SoLuong * (SELECT GiaBan FROM LinhKien WHERE MaLK = @MaLK)
	    WHERE MaHD = @MaHD;

    UPDATE LinhKien
		SET SoLuong = SoLuong + @SoLuong_old
		WHERE MaLK = @MaLK

    UPDATE LinhKien 
		SET SoLuong = SoLuong - @SoLuong
		WHERE MaLK = @MaLK

    UPDATE LinhKienDaBan
		SET SoLuong = SoLuong - @SoLuong_old
		WHERE MaLK = @MaLK

    UPDATE LinhKienDaBan 
		SET SoLuong = SoLuong + @SoLuong
		WHERE MaLK = @MaLK

    UPDATE LinhKienDaBan 
		SET TongTien = SoLuong * (SELECT GiaBan FROM LinhKien WHERE MaLK = @MaLK)
		WHERE MaLK = @MaLK
END

DROP PROC CapNhatGia_SoLuong_HoaDon




CREATE TABLE LinhKienDaBan
(
    ID INT IDENTITY(1,1) PRIMARY KEY,
    MaLK VARCHAR(10) NOT NULL,
    CONSTRAINT Fr_MaLK_LinhKienDaBan FOREIGN KEY (MaLK) REFERENCES LinhKien(MaLK),
    SoLuong INT,
    TongTien FLOAT,
)

INSERT INTO LinhKienDaBan (MaLK, SoLuong, TongTien) VALUES
    ('LK01', 10 , 0);

SELECT * FROM LinhKienDaBan

DROP TABLE LinhKienDaBan

SELECT LinhKienDaBan.MaLK, TenLK, LinhKienDaBan.SoLuong, GiaBan, TongTien 
    FROM LinhKienDaBan, LinhKien
    WHERE LinhKienDaBan.MaLK = LinhKien.MaLK AND LinhKienDaBan.MaLK = 'LK01'

SELECT LinhKienDaBan.MaLK, TenLK, LinhKienDaBan.SoLuong, GiaBan, TongTien 
    FROM LinhKienDaBan, LinhKien
    WHERE LinhKienDaBan.MaLK = LinhKien.MaLK AND TongTien = (SELECT MAX(TongTien) FROM LinhKienDaBan)

--- Tính tổng tiền khi insert LinhKienDaBan
GO 

CREATE TRIGGER Trigger_Insert_LinhKienDaBan ON LinhKienDaBan FOR INSERT 
AS 
BEGIN
    DECLARE @GiaBan FLOAT;
    SELECT @GiaBan = GiaBan
        FROM LinhKien
        WHERE MaLK = (SELECT MaLK
                            FROM INSERTED)

    UPDATE LinhKienDaBan 
		SET TongTien = @GiaBan * (SELECT SoLuong FROM INSERTED)
		WHERE MaLK = (SELECT MaLK
                            FROM INSERTED)
END

DROP TRIGGER Trigger_Insert_LinhKienDaBan




CREATE TABLE MaGiamGia
(
    Ma VARCHAR(50) PRIMARY KEY,
    Ten NVARCHAR(100) NOT NULL,
    PhanTram INT,
    HieuLuc DATE,
)

INSERT INTO MaGiamGia (Ma, Ten, PhanTram, HieuLuc) VALUES
    ('ddd',  N'Giảm 5 phần trăm', 5, '2022-06-01'),
    ('aaa',  N'Giảm 5 phần trăm', 5, '2022-12-01');

SELECT * FROM MaGiamGia

DROP TABLE MaGiamGia



-- CREATE TABLE BaoHanh
-- (
--     MaBH VARCHAR(10) PRIMARY KEY,
--     MaHD VARCHAR(10) NOT NULL,
--     CONSTRAINT Fr_MaHD_BaoHanh FOREIGN KEY (MaHD) REFERENCES HoaDon(MaHD),
--     LyDoBaoHanh NVARCHAR(500),
--     NgayBaoHanh DATE,
-- )

-- INSERT INTO BaoHanh (MaBH, MaHD, LyDoBaoHanh, NgayBaoHanh) VALUES
--     ('NH02' ,'HD01' ,N'Lỗi' , '2022-06-01');

-- SELECT * FROM BaoHanh

-- DROP TABLE BaoHanh



CREATE TABLE ThongKe
(
    MaThongKe VARCHAR(10) PRIMARY KEY,
    TenThongKe NVARCHAR(100),
    GhiChu NVARCHAR(1000),
    TongTien FLOAT,
)


SELECT *
FROM ThongKe

DROP TABLE ThongKe

INSERT INTO ThongKe (MaThongKe, TenThonKe, GhiChu, DoanhThu) VALUES

---Select tổng doanh thu theo tháng

GO

CREATE PROC Select_TongDoanhThu_Thang
    @ThangBD INT,
    @ThangKT INT,
    @NamBD INT,
    @NamKT INT
AS
BEGIN

    SELECT SUM(TongTien)
        FROM HoaDon
        WHERE MONTH(NgayMua) >= @ThangBD AND MONTH(NgayMua) <= @ThangKT 
        AND YEAR(NgayMua) >= @NamBD AND YEAR(NgayMua) <= @NamKT
END

DROP PROC Select_TongDoanhThu_Thang 

EXEC Select_TongDoanhThu_Thang @ThangBD = 01, @ThangKT = 12, @NamBD = 2022, @NamKT= 2022


---Select tổng doanh thu theo tháng

GO

CREATE PROC Select_TongDoanhThu_Nam
    @NamBD INT,
    @NamKT INT
AS
BEGIN
    SELECT SUM(TongTien)
        FROM HoaDon
        WHERE YEAR(NgayMua) >= @NamBD AND YEAR(NgayMua) <= @NamKT
END

DROP PROC Select_TongDoanhThu_Nam

---Select tổng Chi tiêu theo tháng

GO

CREATE PROC Select_TongChiTieu_Thang
    @ThangBD INT,
    @ThangKT INT,
    @NamBD INT,
    @NamKT INT
AS
BEGIN
SELECT SUM(TongTien)
        FROM LinhKienNhap
        WHERE MONTH(NgayNhap) >= @ThangBD AND MONTH(NgayNhap) <= @ThangKT 
        AND YEAR(NgayNhap) >= @NamBD AND YEAR(NgayNhap) <= @NamKT
END

EXEC Select_TongChiTieu_Thang @ThangBD = 01, @ThangKT = 12, @NamBD = 2022, @NamKT= 2022

DROP PROC Select_TongChiTieu_Thang



---Select tổng Chi tiêu theo tháng

GO

CREATE PROC Select_TongChiTieu_Nam
    @NamBD INT,
    @NamKT INT
AS
BEGIN
SELECT SUM(TongTien)
        FROM LinhKienNhap
        WHERE YEAR(NgayNhap) >= @NamBD AND YEAR(NgayNhap) <= @NamKT
END

EXEC Select_TongChiTieu_Nam  @NamBD = 2022, @NamKT= 2022

DROP PROC Select_TongChiTieu_Nam
