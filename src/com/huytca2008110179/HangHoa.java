package com.huytca2008110179;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public abstract class HangHoa {
    private String maHH;
    private String tenHH;
    private int soLuongton;
    private double dongia, tongTien;
    //private String danhgia;

    Scanner sc = new Scanner(System.in);

    public HangHoa(){
        super();
    }

    public HangHoa(String maHH, String tenHH, int soLuongton, double dongia){
        this.maHH = maHH;
        this.tenHH = tenHH;
        this.soLuongton = soLuongton;
        this.dongia = dongia;
    }

    public HangHoa(String maHH, String tenHH, int soLuongton, double dongia, double tongTien){
        this.maHH = maHH;
        this.tenHH = tenHH;
        this.soLuongton = soLuongton;
        this.dongia = dongia;
        this.tongTien = tongTien;
    }

    public String getMaHH() {
        return maHH;
    }
    public void setMaHH(String maHH) {
        this.maHH = maHH;
    }

    public String getTenHH() {
        return tenHH;
    }
    public void setTenHH(String tenHH) {
        this.tenHH = tenHH;
    }

    public int getSoLuongton() {
        return soLuongton;
    }
    public void setSoLuongton(int soLuongton) {
        this.soLuongton = soLuongton;
    }

    public void setDongia(double dongia) {
        this.dongia = dongia;
    }
    public double getDongia() {
        return dongia;
    }

    public double getTongTien() {
        return tongTien;
    }
    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public boolean kiemTraMaHang(boolean k) {
        if (this.maHH == "" || this.maHH.trim().isEmpty()) {
            System.out.println("Mã hàng không được để trống !!");
        } else {
            k = false;
        }
        return k;
    }

    public boolean kiemTraTenHang(boolean k) {
        if (this.tenHH == "" || this.tenHH.trim().isEmpty()) {
            System.out.println("Tên hàng không được để trống !!");
        } else {
            k = false;
        }
        return k;
    }

    public boolean kiemTraSoLuongTon(boolean k){
        if (this.soLuongton < 0){
            System.out.println("Số lượng tồn phải >= 0 !!");
        }
        else{
            k = false;
        }
        return k;
    }

    public boolean kiemTraDonGia(boolean k){
        if (this.dongia <= 0){
            System.out.println("Đơn giá phải > 0 !!");
        }
        else{
            k = false;
        }
        return k;
    }

    public void nhap(){
        boolean ktMH = true;
        boolean ktTH = true;
        boolean ktSL = true;
        boolean ktDG = true;
        
        do{
            System.out.print("Mã hàng: ");
            setMaHH(sc.nextLine());
        }while(kiemTraMaHang(ktMH));

        do{
            System.out.print("Tên hàng: ");
            setTenHH(sc.nextLine());
        }while(kiemTraTenHang(ktTH));

        do{
            System.out.print("Số lượng tồn: ");
            setSoLuongton(sc.nextInt());
            sc.nextLine();
        }while(kiemTraSoLuongTon(ktSL));

        do{
            System.out.print("Đơn giá: ");
            setDongia(sc.nextDouble());;
            sc.nextLine();
        }while(kiemTraDonGia(ktDG));
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        Locale localeVN = new Locale("vi", "VN");
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(localeVN);
        String strDongia = numberFormat.format(dongia);
    
        return "Mã hàng: "+maHH+", Tên hàng: "+tenHH+", Số lượng tồn: "+soLuongton+", Đơn giá(/sản phẩm): "+strDongia;
    } 
    
    public String inTTtien(){

        tongTien = dongia*soLuongton;

        Locale localeVN = new Locale("vi", "VN");
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(localeVN);
        String strDongia = numberFormat.format(dongia);
        String strTongtien = numberFormat.format(tongTien);
        
        return "Mã hàng: "+maHH+", Tên hàng: "+tenHH+", Số lượng tồn: "+soLuongton+", Đơn giá(/sản phẩm): "+strDongia+", Tổng tiền: "+strTongtien;
    }
}
