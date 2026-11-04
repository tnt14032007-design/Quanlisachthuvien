import java.time.Year;
import java.util.Locale;
import java.util.Scanner;

public class BTT5 {
    private String maSach;
    private String tenSach;
    private String tacGia;
    private int namXuatBan;
    private double giaSach;
    private int soLuong;

    public void nhap(BTT5[] ds, int soSachDaNhap, Scanner scanner) {
        // Ma sach: khong de trong va khong trung voi sach da nhap
        boolean loi;
        do {
            System.out.print("  Ma sach: ");
            maSach = scanner.nextLine().trim();
            loi = false;
            if (maSach.isEmpty()) {
                System.out.println("  Loi: Ma sach khong duoc de trong.");
                loi = true;
            } else {
                for (int i = 0; i < soSachDaNhap; i++) {
                    if (ds[i].maSach.equalsIgnoreCase(maSach)) {
                        System.out.println("  Loi: Ma sach da ton tai.");
                        loi = true;
                        break;
                    }
                }
            }
        } while (loi);

        System.out.print("  Ten sach: ");
        tenSach = scanner.nextLine();
        System.out.print("  Tac gia: ");
        tacGia = scanner.nextLine();

        int namHienTai = Year.now().getValue();
        do {
            System.out.print("  Nam xuat ban: ");
            namXuatBan = scanner.nextInt();
            if (namXuatBan < 1900 || namXuatBan > namHienTai) {
                System.out.println("  Loi: Nam xuat ban phai tu 1900 den " + namHienTai + ".");
            }
        } while (namXuatBan < 1900 || namXuatBan > namHienTai);

        do {
            System.out.print("  Don gia: ");
            giaSach = scanner.nextDouble();
            if (giaSach <= 0) {
                System.out.println("  Loi: Gia phai lon hon 0.");
            }
        } while (giaSach <= 0);

        do {
            System.out.print("  So luong: ");
            soLuong = scanner.nextInt();
            if (soLuong < 0) {
                System.out.println("  Loi: So luong phai lon hon hoac bang 0.");
            }
        } while (soLuong < 0);

        scanner.nextLine();
    }

    public double tinhThanhTien() {
        return giaSach * soLuong;
    }

    public double tinhPhiVanChuyen() {
        return tinhThanhTien() * 0.05;
    }

    public double tinhTongTienNhap() {
        return tinhThanhTien() + tinhPhiVanChuyen();
    }

    public void xuat() {
        System.out.printf("%-8s %-22s %-18s %-6d %,12.0f %6d %,14.0f%n",
                maSach, tenSach, tacGia, namXuatBan, giaSach, soLuong, tinhThanhTien());
    }

    private static void nhapDanhSach(BTT5[] ds, Scanner scanner) {
        for (int i = 0; i < ds.length; i++) {
            System.out.println("Nhap sach thu " + (i + 1) + "/" + ds.length + ":");
            ds[i] = new BTT5();
            ds[i].nhap(ds, i, scanner);
        }
    }

    private static void hienThiDanhSach(BTT5[] ds) {
        if (ds.length == 0) {
            System.out.println("Chua co sach nao. Hay chon chuc nang 1 de nhap sach.");
            return;
        }
        System.out.printf("%-8s %-22s %-18s %-6s %12s %6s %14s%n",
                "Ma", "Ten sach", "Tac gia", "Nam", "Don gia", "SL", "Thanh tien");
        for (int i = 0; i < ds.length; i++) {
            ds[i].xuat();
        }
    }

    private static void tinhTong(BTT5[] ds) {
        if (ds.length == 0) {
            System.out.println("Chua co sach nao. Hay chon chuc nang 1 de nhap sach.");
            return;
        }
        int tongSoLuong = 0;
        double tongGiaTri = 0;
        double tongTienNhap = 0;
        for (int i = 0; i < ds.length; i++) {
            tongSoLuong += ds[i].soLuong;
            tongGiaTri += ds[i].tinhThanhTien();
            tongTienNhap += ds[i].tinhTongTienNhap();
        }
        System.out.println("So dau sach     : " + ds.length);
        System.out.println("Tong so luong   : " + tongSoLuong);
        System.out.printf("Tong gia tri    : %,.0f%n", tongGiaTri);
        System.out.printf("Tong tien nhap (da gom phi van chuyen 5%%): %,.0f%n", tongTienNhap);
    }

    private static void timTheoMa(BTT5[] ds, Scanner scanner) {
        if (ds.length == 0) {
            System.out.println("Chua co sach nao. Hay chon chuc nang 1 de nhap sach.");
            return;
        }
        System.out.print("Nhap ma sach can tim: ");
        String ma = scanner.nextLine().trim();
        boolean timThay = false;
        for (int i = 0; i < ds.length; i++) {
            if (ds[i].maSach.equalsIgnoreCase(ma)) {
                System.out.println("Da tim thay sach:");
                System.out.println("  Ma sach       : " + ds[i].maSach);
                System.out.println("  Ten sach      : " + ds[i].tenSach);
                System.out.println("  Tac gia       : " + ds[i].tacGia);
                System.out.println("  Nam xuat ban  : " + ds[i].namXuatBan);
                System.out.printf("  Don gia       : %,.0f%n", ds[i].giaSach);
                System.out.println("  So luong      : " + ds[i].soLuong);
                System.out.printf("  Thanh tien    : %,.0f%n", ds[i].tinhThanhTien());
                System.out.printf("  Phi van chuyen: %,.0f%n", ds[i].tinhPhiVanChuyen());
                System.out.printf("  Tong tien nhap: %,.0f%n", ds[i].tinhTongTienNhap());
                timThay = true;
                break;
            }
        }
        if (!timThay) {
            System.out.println("Khong tim thay sach co ma \"" + ma + "\".");
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US); // nhap so thuc bang dau cham
        BTT5[] ds = new BTT5[0];
        int chon;

        do {
            System.out.println("\n===== QUAN LY SACH THU VIEN =====");
            System.out.println("1. Nhap danh sach sach");
            System.out.println("2. Hien thi danh sach");
            System.out.println("3. Tinh tong so luong va tong gia tri");
            System.out.println("4. Tim sach theo ma");
            System.out.println("0. Thoat");
            System.out.print("Chon chuc nang: ");
            chon = scanner.nextInt();
            scanner.nextLine();

            switch (chon) {
                case 1:
                    int n;
                    do {
                        System.out.print("Nhap so luong sach can nhap (n > 0): ");
                        n = scanner.nextInt();
                        scanner.nextLine();
                        if (n <= 0) {
                            System.out.println("Loi: n phai lon hon 0.");
                        }
                    } while (n <= 0);
                    ds = new BTT5[n];
                    nhapDanhSach(ds, scanner);
                    break;
                case 2:
                    hienThiDanhSach(ds);
                    break;
                case 3:
                    tinhTong(ds);
                    break;
                case 4:
                    timTheoMa(ds, scanner);
                    break;
                case 0:
                    System.out.println("Tam biet!");
                    break;
                default:
                    System.out.println("Lua chon khong hop le, vui long chon lai.");
            }
        } while (chon != 0);
    }
}
