import java.util.ArrayList;
import java.util.Scanner;

public class test {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Sach> danhSach = new ArrayList<>();

    static int timViTri(String ma) {
        for (int i = 0; i < danhSach.size(); i++) {
        if (danhSach.get(i).getMaSach().equalsIgnoreCase(ma)) {
            return i;
            }
        }
        return -1;
    }

    static void themSach() {
        System.out.print("Ma sach: ");
        String ma = sc.nextLine();
        if (timViTri(ma) != -1) {
            System.out.println("ma sach da ton tai!");
            return;
        }
        System.out.print("Tieu de: ");
        String tieuDe = sc.nextLine();
        System.out.print("TTac gia: ");
        String tacGia = sc.nextLine();
        System.out.print("Nam xuat ban: ");
        int nam = Integer.parseInt(sc.nextLine());
        System.out.print("So luong: ");
        int sl = Integer.parseInt(sc.nextLine());
        danhSach.add(new Sach(ma, tieuDe, tacGia, nam, sl));
        System.out.println("Đa them sach.");
    }

    static void hienThiSach() {
        if (danhSach.isEmpty()) {
            System.out.println("Danh sach trong.");
            return;
        }
        for (Sach s : danhSach) {
            s.hienThiThongTin();
        }
    }

    static void timSach() {
        System.out.print("nhap ma sach can tim: ");
        int vt = timViTri(sc.nextLine());
        if (vt == -1) {
            System.out.println("Khong tim thay sach.");
        } else {
            danhSach.get(vt).hienThiThongTin();
        }
    }

    static void xoaSach() {
        System.out.print("nhap ma sach can xoa: ");
        int vt = timViTri(sc.nextLine());
        if (vt == -1) {
            System.out.println("Khong tim thay sach.");
        } else {
            danhSach.remove(vt);
            System.out.println("Da xoa sach.");
        }
    }

    public static void main(String[] args) {
        Sach s1 = new Sach("S001", "Lap trinh Java", "Nguyen van A", 2022, 10);
        s1.hienThiThongTin();

        danhSach.add(s1);
        danhSach.add(new Sach("S002", "Co so du lieu", "Tran Thi B", 2021, 5));
        danhSach.add(new Sach("S003", "Thiet ke web", "Le Van C", 2023, 8));

        int chon;
        do {
            System.out.println("\n===== QUAN LI SACH =====");
            System.out.println("1. Them sach");
            System.out.println("2. Hien thi sach");
            System.out.println("3. Tim sach");
            System.out.println("4. Xoa sach");
            System.out.println("0. Thoat");
            System.out.print("Chon chuc nang: ");
            chon = Integer.parseInt(sc.nextLine());

            switch (chon) {
                case 1: themSach(); break;
                case 2: hienThiSach(); break;
                case 3: timSach(); break;
                case 4: xoaSach(); break;
                case 0: System.out.println("tam biet"); break;
                default: System.out.println("Lua chon khong hop le!");
            }
        } while (chon != 0);
    }
}
