
import java.time.Year;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class BTT5 {

    // ================= BAI 1 =================
    private static void bai1(Scanner scanner) {
        int[] soLuong = new int[5];

        // Nhap so luong 5 cuon sach
        for (int i = 0; i < 5; i++) {
            System.out.print("Nhap so luong sach thu " + (i + 1) + ": ");
            soLuong[i] = scanner.nextInt();
        }

        // Hien thi so luong
        System.out.println("So luong 5 cuon sach:");
        int tong = 0;
        int max = soLuong[0];

        for (int i = 0; i < 5; i++) {
            System.out.println("Sach " + (i + 1) + ": " + soLuong[i]);

            tong += soLuong[i];

            if (soLuong[i] > max) {
                max = soLuong[i];
            }
        }

        System.out.println("Tong so luong: " + tong);
        System.out.println("So luong lon nhat: " + max);

        scanner.nextLine();
    }

    // ================= NHAP THONG TIN SACH =================
    private static String nhapSach(String ma, Scanner scanner) {
        System.out.print("  Ten sach: ");
        String tenSach = scanner.nextLine().replace(';', ',');

        System.out.print("  Tac gia: ");
        String tacGia = scanner.nextLine().replace(';', ',');

        int namHienTai = Year.now().getValue();
        int namXuatBan;

        do {
            System.out.print("  Nam xuat ban: ");
            namXuatBan = scanner.nextInt();

            if (namXuatBan < 1900 || namXuatBan > namHienTai) {
                System.out.println("  Nam xuat ban khong hop le.");
            }
        } while (namXuatBan < 1900 || namXuatBan > namHienTai);

        double giaSach;

        do {
            System.out.print("  Don gia: ");
            giaSach = scanner.nextDouble();

            if (giaSach <= 0) {
                System.out.println("  Gia phai lon hon 0.");
            }
        } while (giaSach <= 0);

        int soLuong;

        do {
            System.out.print("  So luong: ");
            soLuong = scanner.nextInt();

            if (soLuong < 0) {
                System.out.println("  So luong khong duoc am.");
            }
        } while (soLuong < 0);

        scanner.nextLine();

        return ma + ";" + tenSach + ";" + tacGia + ";"
                + namXuatBan + ";" + giaSach + ";" + soLuong;
    }

    // ================= THEM SACH =================
    private static void themSach(ArrayList<String> dsMa,
            ArrayList<String> danhSachSach, Scanner scanner) {

        String ma;
        boolean loi;

        do {
            System.out.print("Ma sach: ");
            ma = scanner.nextLine().trim().toUpperCase();

            loi = false;

            if (ma.isEmpty()) {
                System.out.println("Ma sach khong duoc de trong.");
                loi = true;
            } else if (dsMa.contains(ma)) {
                System.out.println("Ma sach da ton tai.");
                loi = true;
            }
        } while (loi);

        danhSachSach.add(nhapSach(ma, scanner));
        dsMa.add(ma);

        System.out.println("Da them sach.");
    }

    // ================= HIEN THI SACH =================
    private static void hienThiSach(ArrayList<String> danhSachSach) {

        if (danhSachSach.isEmpty()) {
            System.out.println("Danh sach rong.");
            return;
        }

        System.out.printf("%-8s %-22s %-18s %-6s %12s %6s %14s%n",
                "Ma", "Ten sach", "Tac gia", "Nam",
                "Don gia", "SL", "Thanh tien");

        for (int i = 0; i < danhSachSach.size(); i++) {
            String[] t = danhSachSach.get(i).split(";");

            double gia = Double.parseDouble(t[4]);
            int sl = Integer.parseInt(t[5]);

            System.out.printf("%-8s %-22s %-18s %-6s %,12.0f %6d %,14.0f%n",
                    t[0], t[1], t[2], t[3], gia, sl, gia * sl);
        }
    }

    // ================= TIM SACH =================
    private static void timSach(ArrayList<String> dsMa,
            ArrayList<String> danhSachSach, Scanner scanner) {

        System.out.print("Nhap ma sach can tim: ");
        String ma = scanner.nextLine().trim().toUpperCase();

        int vt = dsMa.indexOf(ma);

        if (vt == -1) {
            System.out.println("Khong tim thay sach.");
        } else {
            String[] t = danhSachSach.get(vt).split(";");

            System.out.println("Ma sach: " + t[0]);
            System.out.println("Ten sach: " + t[1]);
            System.out.println("Tac gia: " + t[2]);
            System.out.println("Nam xuat ban: " + t[3]);
            System.out.println("Don gia: " + t[4]);
            System.out.println("So luong: " + t[5]);
        }
    }

    // ================= XOA SACH =================
    private static void xoaSach(ArrayList<String> dsMa,
            ArrayList<String> danhSachSach, Scanner scanner) {

        System.out.print("Nhap ma sach can xoa: ");
        String ma = scanner.nextLine().trim().toUpperCase();

        int vt = dsMa.indexOf(ma);

        if (vt == -1) {
            System.out.println("Khong tim thay sach.");
        } else {
            dsMa.remove(vt);
            danhSachSach.remove(vt);

            System.out.println("Da xoa sach.");
        }
    }

    // ================= SUA SACH =================
    private static void suaSach(ArrayList<String> dsMa,
            ArrayList<String> danhSachSach, Scanner scanner) {

        System.out.print("Nhap ma sach can sua: ");
        String ma = scanner.nextLine().trim().toUpperCase();

        int vt = dsMa.indexOf(ma);

        if (vt == -1) {
            System.out.println("Khong tim thay sach.");
        } else {
            System.out.println("Nhap thong tin moi:");

            danhSachSach.set(vt, nhapSach(ma, scanner));

            System.out.println("Da cap nhat sach.");
        }
    }

    // ================= TINH TONG SO LUONG =================
    private static void tinhTongSoLuong(ArrayList<String> dsMa,
            ArrayList<String> danhSachSach) {

        if (danhSachSach.isEmpty()) {
            System.out.println("Danh sach rong.");
            return;
        }

        int[] soLuong = new int[danhSachSach.size()];

        for (int i = 0; i < soLuong.length; i++) {
            String[] t = danhSachSach.get(i).split(";");
            soLuong[i] = Integer.parseInt(t[5]);
        }

        int tong = 0;
        int vtMax = 0;

        for (int i = 0; i < soLuong.length; i++) {
            tong += soLuong[i];

            if (soLuong[i] > soLuong[vtMax]) {
                vtMax = i;
            }
        }

        System.out.println("Tong so luong sach: " + tong);

        System.out.println("So luong lon nhat: "
                + soLuong[vtMax] + " (Ma sach: " + dsMa.get(vtMax) + ")");
    }

    // ================= TINH TONG GIA TRI =================
    private static void tinhTongGiaTri(ArrayList<String> danhSachSach) {

        if (danhSachSach.isEmpty()) {
            System.out.println("Danh sach rong.");
            return;
        }

        double tongGiaTri = 0;

        for (int i = 0; i < danhSachSach.size(); i++) {
            String[] t = danhSachSach.get(i).split(";");

            double gia = Double.parseDouble(t[4]);
            int sl = Integer.parseInt(t[5]);

            tongGiaTri += gia * sl;
        }

        System.out.printf("Tong gia tri: %,.0f%n", tongGiaTri);

        double tongTienNhap = tongGiaTri * 1.05;

        System.out.printf("Tong tien nhap (gom phi van chuyen 5%%): %,.0f%n",
                tongTienNhap);
    }

    // ================= MENU CHINH =================
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);

        ArrayList<String> dsMa = new ArrayList<>();
        ArrayList<String> danhSachSach = new ArrayList<>();

        int chon;

        do {
            System.out.println("\n===== QUAN LY SACH THU VIEN =====");
            System.out.println("1. Them sach");
            System.out.println("2. Hien thi sach");
            System.out.println("3. Tim sach");
            System.out.println("4. Xoa sach");
            System.out.println("5. Sua sach");
            System.out.println("6. Tinh tong so luong");
            System.out.println("7. Tinh tong gia tri");
            System.out.println("8. Thoat");
            System.out.print("Chon chuc nang: ");

            chon = scanner.nextInt();
            scanner.nextLine();

            switch (chon) {
                case 1:
                    themSach(dsMa, danhSachSach, scanner);
                    break;

                case 2:
                    hienThiSach(danhSachSach);
                    break;

                case 3:
                    timSach(dsMa, danhSachSach, scanner);
                    break;

                case 4:
                    xoaSach(dsMa, danhSachSach, scanner);
                    break;

                case 5:
                    suaSach(dsMa, danhSachSach, scanner);
                    break;

                case 6:
                    tinhTongSoLuong(dsMa, danhSachSach);
                    break;

                case 7:
                    tinhTongGiaTri(danhSachSach);
                    break;

                case 8:
                    System.out.println("Tam biet!");
                    break;

                default:
                    System.out.println("Lua chon khong hop le.");
            }

        } while (chon != 8);
    }
}
