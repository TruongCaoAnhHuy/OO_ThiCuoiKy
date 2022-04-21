package com.huytca2008110179;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class HangHoaDM extends HangHoa implements TienVAT, DanhGia, Serializable{

    Scanner sc = new Scanner(System.in);

    private int tgBaohanh, congSuat;

    public HangHoaDM(){
        super();
    }

    public HangHoaDM(String maHH, String tenHH, int soLuongTon, double dongia, int tgBaohanh, int congSuat){
        super(maHH, tenHH, soLuongTon, dongia);
        this.tgBaohanh = tgBaohanh;
        this.congSuat = congSuat;
    }

    public int getTgBaohanh() {
        return tgBaohanh;
    }
    public void setTgBaohanh(int tgBaoHanh) {
        this.tgBaohanh = tgBaoHanh;
    }

    public int getCongSuat() {
        return congSuat;
    }
    public void setCongSuat(int CongSuat) {
        this.congSuat = CongSuat;
    }

    public boolean kiemTraBaoHanh(boolean k){
        if (this.getTgBaohanh() <= 0){
            System.out.println("Thời gian bảo hành phải >= 0(tháng) !!");
        }
        else{
            k = false;
        }
        return k;
    }

    public boolean kiemTraCongSuat(boolean k){
        if (this.getCongSuat() < 0){
            System.out.println("Công suất phải >= 0(KW) !!");
        }
        else{
            k = false;
        }
        return k;
    }

    public void nhap(){
        super.nhap();

        boolean ktBH = true;
        boolean ktCS = true;

        do{
            System.out.print("Thời gian bảo hành: ");
            tgBaohanh = sc.nextInt();
            sc.nextLine();
        }while(kiemTraBaoHanh(ktBH));

        do{
            System.out.print("Công suất: ");
            congSuat = sc.nextInt();
            sc.nextLine();
        }while(kiemTraCongSuat(ktCS));
    }

    @Override
    public double VAT() {
        double VAT = getDongia()*0.1;
        return VAT;
    }

    @Override
    public String danhGia() {
        String danhgia;
        if (getSoLuongton() < 3) {
            
            danhgia = "Bán được";
        }
        else{
            danhgia="";
        }
        return danhgia;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        Locale localeVN = new Locale("vi", "VN");
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(localeVN);
        String strVAT = numberFormat.format(VAT());

        return super.toString()+", TG bảo hành: "+tgBaohanh+"tháng"+", Công suất: "+congSuat+"KW"+", VAT: "+strVAT+", Đánh giá: "+danhGia();
    }
}
