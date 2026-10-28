import java.time.Year;
import java.util.Locale;
import java.util.Scanner;

public class BTT3 {
    private String maSach;
    private String tenSach;
    private String tacGia;
    private int namXuatBan;
    private double giaSach;
    private int soLuong;
    private int loaiSach;
    private double thanhTien;
    private double phiVanChuyen;
    private double tongTien;

    // Nhap thong tin (tuan 3) + chon loai sach (bai 4)
    public void nhapThongTin() {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);
        System.out.print("Nhap ma sach: ");
        maSach = scanner.nextLine();
        System.out.print("Nhap ten sach: ");
        tenSach = scanner.nextLine();
        System.out.print("Nhap tac gia: ");
        tacGia = scanner.nextLine();
        System.out.print("Nhap nam xuat ban: ");
        namXuatBan = scanner.nextInt();
        System.out.print("Nhap don gia: ");
        giaSach = scanner.nextDouble();
        System.out.print("Nhap so luong: ");
        soLuong = scanner.nextInt();
        System.out.println("Chon loai sach:");
        System.out.println("1. Sach giao khoa");
        System.out.println("2. Sach tham khao");
        System.out.println("3. Sach chuyen nganh");
        System.out.println("4. Sach khac");
        System.out.print("Nhap lua chon (1-4): ");
        loaiSach = scanner.nextInt();
    }

    // Bai 1: Kiem tra du lieu hop le
    public boolean kiemTraHopLe() {
        boolean hopLe = true;
        int namHienTai = Year.now().getValue();

        if (giaSach <= 0) {
            System.out.println("Loi: Gia phai lon hon 0.");
            hopLe = false;
        }
        if (soLuong < 0) {
            System.out.println("Loi: So luong phai lon hon hoac bang 0.");
            hopLe = false;
        }
        if (namXuatBan < 1900 || namXuatBan > namHienTai) {
            System.out.println("Loi: Nam xuat ban phai tu 1900 den " + namHienTai + ".");
            hopLe = false;
        }
        return hopLe;
    }

    // Bai 2: Phan loai gia
    public String phanLoaiGia() {
        if (giaSach < 50000) {
            return "Sach gia thap";
        } else if (giaSach <= 100000) {
            return "Sach gia trung binh";
        } else if (giaSach <= 200000) {
            return "Sach gia cao";
        } else {
            return "Sach gia dac biet";
        }
    }

    // Bai 3: Phan loai ton kho
    public String phanLoaiTonKho() {
        if (soLuong == 0) {
            return "Het sach";
        } else if (soLuong <= 5) {
            return "Sap het";
        } else if (soLuong <= 20) {
            return "Con it";
        } else {
            return "Con nhieu";
        }
    }

    // Bai 4: Dung switch chon loai sach
    public String tenLoaiSach() {
        String ketQua;
        switch (loaiSach) {
            case 1:
                ketQua = "Sach giao khoa";
                break;
            case 2:
                ketQua = "Sach tham khao";
                break;
            case 3:
                ketQua = "Sach chuyen nganh";
                break;
            case 4:
                ketQua = "Sach khac";
                break;
            default:
                ketQua = "Lua chon khong hop le";
        }
        return ketQua;
    }

    // Tinh tien (tuan 3)
    public void tinhTien() {
        thanhTien = giaSach * soLuong;
        phiVanChuyen = thanhTien * 0.05;
        tongTien = thanhTien + phiVanChuyen;
    }

    public void xuatThongTin() {
        System.out.println("\n---Thong tin sach---");
        System.out.println("Ma sach: " + maSach);
        System.out.println("Ten sach: " + tenSach);
        System.out.println("Tac gia: " + tacGia);
        System.out.println("Nam xuat ban: " + namXuatBan);
        System.out.println("Don gia: " + giaSach);
        System.out.println("So luong: " + soLuong);
        System.out.println("Thanh tien: " + thanhTien);
        System.out.println("Phi van chuyen: " + phiVanChuyen);
        System.out.println("Tong tien nhap: " + tongTien);
        System.out.println("Phan loai gia: " + phanLoaiGia());
        System.out.println("Ton kho: " + phanLoaiTonKho());
        System.out.println("Loai sach: " + tenLoaiSach());
    }

    public static void main(String[] args) {
        BTT3 sach = new BTT3();
        sach.nhapThongTin();
        if (sach.kiemTraHopLe()) {
            sach.tinhTien();
            sach.xuatThongTin();
        } else {
            System.out.println("Du lieu khong hop le, vui long nhap lai.");
        }
    }
}
