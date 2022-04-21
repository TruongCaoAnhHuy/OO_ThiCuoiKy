package test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import javax.swing.JFrame;

public class HangHoaClient extends JFrame {
    private static final String HangHoa = null;

    public static void main(String[] args) throws IOException {
        try

        {
            FileOutputStream outFile = new FileOutputStream("data.HangHoa");
            ObjectOutputStream objOut = new ObjectOutputStream(outFile);
            System.out.println(HangHoa);
            objOut.close();
        } finally {
            FileOutputStream outFile = new FileOutputStream("data.HangHoa");
            ObjectOutputStream objOut = new ObjectOutputStream(outFile);
            objOut.writeObject(HangHoa);
            System.out.println();
            objOut.close();
        }
        Scanner in = new Scanner(System.in);
        DSHangHoa dHoa = new DSHangHoa();
        while (dHoa != null) {
            try {
                System.out.println("Nhập vào mã hàng hóa:");
                String maHH = in.nextLine();
                System.out.println("Nhập tên hàng hóa:");
                String tenHH = in.nextLine();
                System.out.println("Nhập số lượng tồn kho:");
                double soLuongTon = in.nextDouble();
                System.out.println("Nhập đơn giá của hàng hóa:");
                double donGia = in.nextDouble();
                System.out.println("Hàng hóa Thucpham_1/DienMay_2/SanhSu_3 >>");
                int loai = in.nextInt();
                HangHoa hangHoa;

                if (loai == 1) {

                    System.out.println("Nhập thông tin của hàng thực phẩm cần thêm");
                    int nsx = in.nextInt();
                    int hsd = in.nextInt();
                    hangHoa = new ThucPham(maHH, tenHH, soLuongTon, donGia, nsx, hsd);
                } else if (loai == 2) {
                    System.out.println("Nhập thông tin cua hàng điện máy cần thêm");
                    hangHoa = new DienMay(maHH, tenHH, soLuongTon, donGia);
                } else {
                    System.out.println("Nhập thông tin hàng sanh sứ cần thêm vào");
                    hangHoa = new SanhSu(maHH, tenHH, soLuongTon, donGia);

                }
            } catch (Exception e) {
                System.out.println("Nhap ky tu ban ơi");
                e.printStackTrace();
            } finally {
                System.out.println("Nhập vào mã hàng hóa:");
                String maHH = in.nextLine();
                System.out.println("Nhập tên hàng hóa:");
                String tenHH = in.nextLine();
                System.out.println("Nhập số lượng tồn kho:");
                double soLuongTon = in.nextDouble();
                System.out.println("Nhập đơn giá của hàng hóa:");
                double donGia = in.nextDouble();
                System.out.println("Hàng hóa Thucpham_1/DienMay_2/SanhSu_3 >>");
                int loai = in.nextInt();
                HangHoa hangHoa;

                if (loai == 1) {

                    System.out.println("Nhập thông tin của hàng thực phẩm cần thêm");
                    int nsx = in.nextInt();
                    int hsd = in.nextInt();
                    hangHoa = new ThucPham(maHH, tenHH, soLuongTon, donGia, nsx, hsd);
                } else if (loai == 2) {
                    System.out.println("Nhập thông tin cua hàng điện máy cần thêm");
                    hangHoa = new DienMay(maHH, tenHH, soLuongTon, donGia);
                } else {
                    System.out.println("Nhập thông tin hàng sanh sứ cần thêm vào");
                    hangHoa = new SanhSu(maHH, tenHH, soLuongTon, donGia);

                }

            }
            return;
        }
        System.out.println("Ban co nhap tiep không y/n");
        int nhap = in.nextInt();
        int x = in.nextInt();

        do {
            System.out.println("----------MENU----------------");
            System.out.println("\n|1.Them hang hoa|");
            System.out.println("\n|2.in ra danh sach hang hoa|");
            System.out.println("\n|3. Xoa hang hoa|");
            System.out.println("\n|4. Tim vi tri hang hoa|");
            System.out.println("\n|5. Sua thong tin hang hoa|");

            System.out.println("\n|0. Ket thuc chuong trinh|");

            switch (x) {
                case 1:

                    dHoa.Them(null);

                    break;
                case 2:
                    dHoa.inDanhSach();
                    break;
                case 3:
                    dHoa.xoaGiaoDich(null);
                    break;
                case 4:
                    dHoa.viTri(true);
                    break;
                case 5:
                    dHoa.suaGiaoDich(HangHoa);
                    break;

                default:
                    break;
            }
        } while (x != 0);
        FileInputStream inFile = new FileInputStream("HangHoa");
        ObjectInputStream objIn = new ObjectInputStream(inFile);
        System.out.println(dHoa);
        objIn.close();
        HangHoaClient myWindow = new HangHoaClient();
        myWindow.setSize(400, 540);
        myWindow.setLocationRelativeTo(null);
        myWindow.setVisible(true);
    }

    public HangHoaClient() {
        super();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}