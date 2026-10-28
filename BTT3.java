import java.util.Locale;
import java.util.Scanner;

public class BTT3 {
    private String maSach;
    private String tenSach;
    private String tacGia;
    private int namXuatBan;
    private double giaSach;
    private int soLuong;
    private double thanhTien;
    private double phiVanChuyen;
    private double tongTien;

    // Bai 1: Nhap thong tin
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
    }

    // Bai 2: Thanh tien = don gia x so luong
    public double tinhTien() {
        thanhTien = giaSach * soLuong;
        return thanhTien;
    }

    // Bai 3: Phi van chuyen = 5% gia tri sach
    public double tinhPhiVanChuyen() {
        phiVanChuyen = thanhTien * 0.05;
        return phiVanChuyen;
    }

    // Bai 4: Tong tien nhap = thanh tien + phi van chuyen
    public double tinhTongTien() {
        tongTien = thanhTien + phiVanChuyen;
        return tongTien;
    }

    public void xuatThongTin() {
        System.out.println("---Thong tin sach---");
        System.out.println("Ma sach: " + maSach);
        System.out.println("Ten sach: " + tenSach);
        System.out.println("Tac gia: " + tacGia);
        System.out.println("Nam xuat ban: " + namXuatBan);
        System.out.println("Don gia: " + giaSach);
        System.out.println("So luong: " + soLuong);
        System.out.println("Thanh tien: " + thanhTien);
        System.out.println("Phi van chuyen: " + phiVanChuyen);
        System.out.println("Tong tien nhap: " + tongTien);
    }

    public static void main(String[] args) {
        QuanliSach sach = new QuanliSach();
        sach.nhapThongTin();
        sach.tinhTien();
        sach.tinhPhiVanChuyen();
        sach.tinhTongTien();
        sach.xuatThongTin();
    }
}
