package com.huytca2008110179;

import java.io.Serializable;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class HangHoaTP extends HangHoa implements TienVAT, DanhGia, Serializable {
   
    Scanner sc = new Scanner(System.in);

    private Date NSX, HSD;
    private String nhaCungcap;

    public HangHoaTP(){
        super();
    }
    
    public HangHoaTP(String maHH, String tenHH, int soLuongTon, double dongia, Date NSX, Date HSD, String nhaCungcap){
        super(maHH, tenHH, soLuongTon, dongia);
        this.NSX = NSX;
        this.HSD = HSD;
        this.nhaCungcap = nhaCungcap;
    }

    public String getNhaCungcap() {
        return nhaCungcap;
    }
    public void setNhaCungcap(String nhaCungcap) {
        this.nhaCungcap = nhaCungcap;
    }

    public Date getNSX() {
        return NSX;
    }
    public void setNSX(Date nSX) {
        this.NSX = nSX;
    }

    public Date getHSD() {
        return HSD;
    }
    public void setHSD(Date hSD) {
        this.HSD = hSD;
    }

    public boolean ktNSXvsHSD( boolean kt){
        if (this.getNSX().compareTo(this.getHSD()) < 0){
            kt = false;
        }else{
            System.out.println("NSX phải trước HSD!!!");
        }
        return kt;
    }

    public boolean ktHSD(boolean kt){
        Date today = new Date();
        today.getTime();
        if (this.getHSD().compareTo(today) < 0){
            //System.out.println("Hết hạn");
            kt = true;
        }else{
            kt = false;
        }
        return kt;
    }

    public Date setStringNXS(int year, int month, int day){
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, day);
        this.NSX = calendar.getTime();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        return NSX;
    }

    public Date setStringHSD(int year, int month, int day){
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, day);
        this.HSD = calendar.getTime();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        return HSD;
    }

    public void nhap(){
        super.nhap();

        boolean ktHSD = true ;
        
        do{
            System.out.print("Ngày sản xuất: ");
            setStringNXS(sc.nextInt(), sc.nextInt(), sc.nextInt());
            sc.nextLine();
            System.out.print("Ngày hết hạn: ");
            setStringHSD(sc.nextInt(), sc.nextInt(), sc.nextInt());
            sc.nextLine();
        }while(ktNSXvsHSD(ktHSD));

        System.out.print("Nhà cung cấp: ");
        nhaCungcap = sc.nextLine();
    }

    @Override
    public double VAT() {
        double VAT = getDongia()*0.1;
        return VAT;
    }

    @Override
    public String danhGia() {
        String danhgia;
        if (getSoLuongton() > 0 && ktHSD(true)) {
            
            danhgia = "Khó bán";
        }
        else{
            danhgia="";
        }
        return danhgia;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String strNSX = simpleDateFormat.format(NSX);
        String strHSD = simpleDateFormat.format(HSD);

        Locale localeVN = new Locale("vi", "VN");
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(localeVN);
        String strVAT = numberFormat.format(VAT());

        return super.toString()+", NSX: "+strNSX+", HSD: "+strHSD+", Nhà cung cấp: "+nhaCungcap+", VAT: "+strVAT+", Đánh giá: "+danhGia();
    }
}
