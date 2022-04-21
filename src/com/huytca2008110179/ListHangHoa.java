package com.huytca2008110179;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class ListHangHoa extends HangHoa {

    List<HangHoaTP> listTP = new ArrayList<>();
    List<HangHoaDM> listDM = new ArrayList<>();
    List<HangHoaSS> listSS = new ArrayList<>();

    List<HangHoa> list = new ArrayList<>();
    
    HangHoaTP htp = new HangHoaTP();
    HangHoaDM hdm = new HangHoaDM();
    HangHoaSS hss= new HangHoaSS();
    
    public void readyList() {
        listTP.add(new HangHoaTP("TP01", "Bánh mì", 5, 3000, htp.setStringNXS(2022, 4, 14), htp.setStringHSD(2022, 4, 18), "tiệm bánh ABC"));
        listTP.add(new HangHoaTP("TP02", "Trứng", 20, 5000, htp.setStringNXS(2022, 3, 17), htp.setStringHSD(2022, 9, 17), "Select"));
        listTP.add(new HangHoaTP("TP03", "Thịt hộp", 5, 3000, htp.setStringNXS(2022, 2, 25), htp.setStringHSD(2022, 5, 25), "Select"));
        listTP.add(new HangHoaTP("TP04", "Pizza", 5, 30000, htp.setStringNXS(2022, 4, 19), htp.setStringHSD(2022, 4, 20), "Domino"));
        listDM.add(new HangHoaDM("DM01", "Tivi", 2, 50000000, 24, 32));
        listDM.add(new HangHoaDM("DM02", "Điện thoại", 50, 3000000, 3, 10));
        listDM.add(new HangHoaDM("DM03", "Laptop", 10, 20000000, 12, 24));
        listSS.add(new HangHoaSS("SS01", "Bình gốm", 51, 3000000, hss.setStringNNK(2022, 4, 7), "Cửa hàng gốm"));
        listSS.add(new HangHoaSS("SS02", "Tô sứ", 20, 30000, hss.setStringNNK(2022, 3, 1), "Cửa hàng tô sứ"));
        listSS.add(new HangHoaSS("SS03", "Ly thủy tinh", 100, 20000, hss.setStringNNK(2022, 4, 15), "Cửa hàng ly"));
        
        list.addAll(listTP);
        list.addAll(listDM);
        list.addAll(listSS);        
    }

    public int findID(){
        System.out.print("Nhập mã hàng: ");
        String timID = sc.nextLine();

        int x = -1;        
            for (HangHoa HangHoa : list) {
                if(timID.equalsIgnoreCase(HangHoa.getMaHH())){
                    x = list.indexOf(HangHoa);
                }
            }
        return x;
    } 

    public Double sumPrice(){
        double sumTP = 0;
        for (HangHoa hangHoa : list) {
            sumTP = hangHoa.getDongia()*getSoLuongton(); 
        }
        return sumTP;
    }


    //*********************************************************************************** *//


    //thêm hàng hóa
    public void Add(HangHoa hangHoa){
                int choose2;
                System.out.println("-> 1. Hàng thực phẩm");
                System.out.println("-> 2. Hàng điện máy");
                System.out.println("-> 3. Hàng sành sứ");
                System.out.print("Chọn loại hàng: ");
                choose2 = sc.nextInt();
                if(choose2 == 1){
                    HangHoaTP htp = new HangHoaTP();
                    htp.nhap();
                    list.add(new HangHoaTP(htp.getMaHH(), htp.getTenHH(), htp.getSoLuongton(), htp.getDongia(), htp.getNSX(), htp.getHSD(), htp.getNhaCungcap()));
                }
                if(choose2 == 2){
                    HangHoaDM hdm = new HangHoaDM();
                    hdm.nhap();
                    list.add(new HangHoaDM(hdm.getMaHH(), hdm.getTenHH(), hdm.getSoLuongton(), hdm.getDongia(), hdm.getTgBaohanh(), hdm.getCongSuat()));
                }
                if(choose2 == 2){
                    HangHoaSS hss = new HangHoaSS();
                    hss.nhap();
                    list.add(new HangHoaSS(hss.getMaHH(), hss.getTenHH(), hss.getSoLuongton(), hss.getDongia(), hss.getNNK(), hss.getnhaSX()));
                }
                System.out.println("Đã thêm hàng hóa!");
                sc.nextLine();
    }

    //xóa hàng hóa
    public void Remove(){
        int x = findID();
        if(x != -1){
            list.remove(x);
            System.out.println("Đã xóa hàng hóa");
        }
        else{
            System.out.println("Không có mã hàng này này!!");
        }
        sc.nextLine();
    }

    //sửa hàng hóa
    public void Update(){
        //System.out.println("đang phát triển");
        System.out.print("Nhập mã hàng cần sửa: ");
        String timID2 = sc.nextLine();

        int x = -1;

        for (HangHoa HangHoaFix : list) {
            if(timID2.equalsIgnoreCase(HangHoaFix.getMaHH())){
                x = list.indexOf(HangHoaFix);
            }
        }
        //sc.nextLine();

        for (int j = 0; j < list.size(); j++){
            if(j == x ){
                System.out.println("Mã hàng: "+timID2);
                System.out.print("Tên hàng sửa: ");
                String tenHHfix = sc.nextLine();
                System.out.print("Số lượng tồn sửa: ");
                int soLuongTonfix = sc.nextInt();
                sc.nextLine();
                System.out.print("Đơn giá sửa: ");
                double dongiaFix = sc.nextDouble();
                sc.nextLine();

                listTP.get(j).setMaHH(timID2);
                listTP.get(j).setTenHH(tenHHfix);
                listTP.get(j).setDongia(dongiaFix);
                listTP.get(j).setSoLuongton(soLuongTonfix);

                if( timID2.substring(0, 2).equalsIgnoreCase("TP")){
                    
                        System.out.print("Ngày sản xuất sửa: ");
                        Date NSXfix = htp.setStringNXS(sc.nextInt(), sc.nextInt(), sc.nextInt());
                        sc.nextLine();
                        System.out.print("Hạn sử dụng sửa: ");
                        Date HSDfix = htp.setStringHSD(sc.nextInt(), sc.nextInt(), sc.nextInt());
                        sc.nextLine();
                        System.out.print("Nhà cung cấp sửa: ");
                        String nhaCungcapFix = sc.nextLine();
                        
                        listTP.get(j).setNSX(NSXfix);
                        listTP.get(j).setHSD(HSDfix);
                        listTP.get(j).setNhaCungcap(nhaCungcapFix);
                    
                }

                if(timID2.substring(0, 2).equalsIgnoreCase("DM")){
                    
                        System.out.print("Thời gian bảo hành sửa: ");
                        int tgBaohanhFix = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Công suất sửa: ");
                        int congSuatfix = sc.nextInt();
                        sc.nextLine();
                        
                        listDM.get(j).setTgBaohanh(tgBaohanhFix);
                        listDM.get(j).setCongSuat(congSuatfix);
                    
                }

                if(timID2.substring(0, 2).equalsIgnoreCase("SS")){
                    
                        System.out.print("Nhà sản xuất sửa: ");
                        String nhaSXfix = sc.nextLine();
                        System.out.print("Ngày xuất kho sửa: ");
                        Date NNKfix = hss.setStringNNK(sc.nextInt(), sc.nextInt(), sc.nextInt());
                        sc.nextLine();

                        listSS.get(j).setNSX(nhaSXfix);
                        listSS.get(j).setNNK(NNKfix);
                    
                }
            }
        }
        System.out.println("Đã sửa thông tin hàng hóa "+timID2);
    }

    //tìm kiếm theo mã
    public void inFindID(){
        boolean k = false;
        System.out.print("Nhập mã hàng: ");
        String timID = sc.nextLine();      
            for (HangHoa HangHoa : list) {
                if(timID.equalsIgnoreCase(HangHoa.getMaHH())){
                   System.out.println(HangHoa);
                   k = true;
                }
            }
            if(k == false){
                System.out.println("Không tìm thấy!!");
            }
    }

    //tìm kiếm theo loại
    public void inFindType(){
        //boolean k = false;
        System.out.println("   -> 1. Theo loại hàng \"Điện máy\"");
        System.out.println("   -> 2. Theo loại hàng \"Thực phẩm\"");
        System.out.println("   -> 3. Theo loại hàng \"Sành sứ\"");
        System.out.print("Chọn loại hàng: ");
        int timType = sc.nextInt();  

        if(timType == 1){
            for (HangHoa hangHoaTP : listTP) {
                System.out.println(hangHoaTP);
            }
        }
        if(timType == 2){
            for (HangHoa hangHoaDM : listDM) {
                System.out.println(hangHoaDM);
            }
        }
        if(timType == 3){
            for (HangHoa hangHoaSS : listSS) {
                System.out.println(hangHoaSS);
            }
        }
    }

    //sắp xếp theo giá tiền
    public void sortPrice(){
        System.out.println("   -> Chọn 1 để sắp xếp tăng dần ");
        System.out.println("   -> Chọn 2 để sắp xếp giảm dần ");
        System.out.print("Chọn cách sắp xếp: ");
        int sort = sc.nextInt();

        if(sort == 1){  // tăng dần
            
            Comparator comparator = new Comparator<HangHoa>() {

                @Override
                public int compare(HangHoa o1, HangHoa o2) {
                    
                    return Double.compare(o1.getDongia(), o2.getDongia());
                }
                
            };
            list.sort(comparator);

            for (int i = 0; i < list.size(); i++){
                System.out.println(list.get(i).toString());
            }

        }

        if(sort == 2){  //giảm dần
            Comparator comparator = new Comparator<HangHoa>(){
                @Override
                public int compare(HangHoa o1, HangHoa o2) {
                    return Double.compare(o2.getDongia(), o1.getDongia());
                }
            };                
            list.sort(comparator);
            
            for (int i = 0; i < list.size(); i++){
                System.out.println(list.get(i).toString());
            }
        }
    }

    //sắp xếp thep số lượng tồn
    public void sortNumber(){
        System.out.println("   -> Chọn 1 để sắp xếp tăng dần ");
        System.out.println("   -> Chọn 2 để sắp xếp giảm dần ");
        System.out.print("Chọn cách sắp xếp: ");
        int sort = sc.nextInt();

        if(sort == 1){  // tăng dần
            
            Comparator comparator = new Comparator<HangHoa>() {

                @Override
                public int compare(HangHoa o1, HangHoa o2) {
                    
                    return Double.compare(o1.getSoLuongton(), o2.getSoLuongton());
                }
                
            };
            list.sort(comparator);

            for (int i = 0; i < list.size(); i++){
                System.out.println(list.get(i).toString());
            }

        }

        if(sort == 2){  //giảm dần
            Comparator comparator = new Comparator<HangHoa>(){
                @Override
                public int compare(HangHoa o1, HangHoa o2) {
                    return Double.compare(o2.getSoLuongton(), o1.getSoLuongton());
                }
            };                
            list.sort(comparator);
            
            for (int i = 0; i < list.size(); i++){
                System.out.println(list.get(i).toString());
            }
        }
    }

    //thống kê
    public void Total(){
        //System.out.println("---Loại hàng thực phẩm---");
        for (int i = 0; i < list.size(); i++){
            System.out.println(list.get(i).toString());
        }
        System.out.println("Tổng số hàng hóa: "+list.size()+" hàng hóa");
    }

    //tổng giá trị
    public void TotalPrice(){
        double sum = sumPrice();

        for (HangHoa hangHoa : list) {
            sum += hangHoa.getDongia();
        }

        Locale localeVN = new Locale("vi", "VN");
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(localeVN);
        String strSum = numberFormat.format(sum);

        for (int i = 0; i < list.size(); i++){
            System.out.println(list.get(i).inTTtien());
        }

        System.out.println("Tổng giá trị tất cả hàng hóa: "+strSum);
    }

    //thống kê số lượng theo loại
    public void TotalType(){
        System.out.println("   -> 1. Theo loại hàng \"Thực phẩm\"");
        System.out.println("   -> 2. Theo loại hàng \"Điện máy\"");
        System.out.println("   -> 3. Theo loại hàng \"Sành sứ\"");
        System.out.print("Chọn loại hàng: ");
        int timType = sc.nextInt();  

        if(timType == 1){
            for (HangHoa hangHoaTP : listTP) {
                System.out.println(hangHoaTP);
            }
            System.out.println("Tổng số hàng hóa \"Thực phẩm: \""+listTP.size()+" hàng hóa");
        }

        if(timType == 2){
            for (HangHoa hangHoaDM : listDM) {
                System.out.println(hangHoaDM);
            }
            System.out.println("Tổng số hàng hóa \"Điện máy: \""+listDM.size()+" hàng hóa");

        }

        if(timType == 3){
            for (HangHoa hangHoaSS : listSS) {
                System.out.println(hangHoaSS);
            }
            System.out.println("Tổng số hàng hóa \"Sành sứ: \""+listDM.size()+" hàng hóa");

        }
    }
}
