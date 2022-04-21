package com.huytca2008110179;

import java.util.Scanner;

public class HangHoaTestDrive {
    public static void main(String[] args) {

        ListHangHoa listHH = new ListHangHoa();
        Scanner sc = new Scanner(System.in);

        listHH.readyList();
   
        int choose;

        do{
            System.out.println("=================== Menu ====================");
            System.out.println("- 1.  Nhập thêm hàng hóa                    -");
            System.out.println("- 2.  Xóa thông tin hàng hóa                -");
            System.out.println("- 3.  Sửa thông tin hàng hóa                -");
            System.out.println("- 4.  Tìm kiếm hàng hóa theo mã             -");
            System.out.println("- 5.  Tìm kiếm hàng hóa theo loại           -");
            System.out.println("- 6.  Sắp xếp hàng hóa theo giá             -");
            System.out.println("- 7.  Sắp xếp hàng hóa theo số lượng        -");
            System.out.println("- 8.  Thống kê tổng số hàng hóa             -");
            System.out.println("- 9.  Thống kê số lượng từng loại hàng hóa  -");
            System.out.println("- 10. Thống kê giá trị tất cả hàng hóa      -");
            System.out.println("- 0.  Thoát                                 -");
            System.out.println("=============================================");
            System.out.print("Chọn chức năng: ");
            choose = sc.nextInt();
            switch (choose){
                case 1 :
                    listHH.Add(listHH);
                    break;

                case 2: 
                    listHH.Remove();
                    break;

                case 3:
                    listHH.Update();
                    break;

                case 4:
                    listHH.inFindID();
                    break;

                case 5:
                    listHH.inFindType();
                    break;

                case 6:
                    listHH.sortPrice();
                    break;

                case 7:
                    listHH.sortNumber();
                    break;

                case 8 :
                    listHH.Total();
                    break;

                case 9:
                    listHH.TotalType();
                    break;

                case 10:
                    listHH.TotalPrice();
                    break;

                default:
                    System.out.println("Sai cú pháp !!");
            }
        }while(choose != 0);

    }
}
