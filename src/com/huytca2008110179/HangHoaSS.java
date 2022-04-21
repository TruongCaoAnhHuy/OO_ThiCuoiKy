package com.huytca2008110179;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class HangHoaSS extends HangHoa implements TienVAT, DanhGia{

    Scanner sc = new Scanner(System.in);

    private String nhaSX;
    private Date NNK;
    //private double VAT;
    Calendar cal = Calendar.getInstance();

    public HangHoaSS(){
        super();
    }
    
    public HangHoaSS(String maHH, String tenHH, int soLuongton, double dongia, Date NNK, String nhaSX){
        super(maHH, tenHH, soLuongton, dongia);
        this.nhaSX = nhaSX;
        this.NNK = NNK;
    }

    public String getnhaSX() {
        return nhaSX;
    }
    public void setNSX(String nhSX) {
        nhaSX = nhSX;
    }

    public Date getNNK() {
        return NNK;
    }
    public void setNNK(Date nNK) {
        NNK = nNK;
    }

    public Date setStringNNK(int year, int month, int day){
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, day);
        this.NNK = calendar.getTime();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        return NNK;
    }
    
    public void nhap(){
        super.nhap();
        System.out.print("Nhà sản xuất: ");
        nhaSX = sc.nextLine();
        System.out.print("Ngày nhập kho: ");
        setStringNNK(sc.nextInt(), sc.nextInt(), sc.nextInt());
    }
    
    @Override
    public double VAT() {
        double VAT = getDongia()*0.1;
        return VAT;
    }

    public long ktDate(){
        long starValue = NNK.getTime();
        long endDate = Calendar.getInstance().getTimeInMillis();
        long tmp = Math.abs(starValue - endDate);

        long kq = tmp/(24*60*60*1000);

        return kq;
    }

    @Override
    public String danhGia() {
        String danhgia;
        if (getSoLuongton() > 50 && ktDate() > 10 ){
            
            danhgia = "Bán chậm!";
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
        String strNNK = simpleDateFormat.format(NNK);

        /*double i = getDongia();
        VAT = i*0.1;*/

        Locale localeVN = new Locale("vi", "VN");
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(localeVN);
        String strVAT = numberFormat.format(VAT());

        return super.toString()+", nhàSX: "+nhaSX+", HSD: "+strNNK+", VAT: "+strVAT+", Đánh giá: "+danhGia();
    }
}
