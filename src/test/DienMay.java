package test;

import javax.swing.plaf.synth.SynthSpinnerUI;

public class DienMay extends HangHoa implements HangDienMay {

    @Override
    public void BaoHanh() {

        for (int i = 0; i > 0; i++) {

            if (i > 0) {
                System.out.println("Thoi gian bao hanh la 12 thang");
            } else {
                System.out.println("Khong co bao hanh");
            }
        }
    }

    @Override
    public void setDonGia(double donGia) {
        System.out.println("Đơn giá sau khi đã tính vat" + donGia);
        donGia = donGia * 0.1;
    }

    @Override
    public void setSoLuongTon(double soLuongTon) {
        if (getSoLuongTon() < 3) {
            System.out.println("Bán được đấy nhập thêm đi");
        } else {
            System.out.println("Bán ế quá giảm giá đi");
        }
        super.setSoLuongTon(soLuongTon);
    }

    @Override
    public void CongSuat() {
        for (int i = 1; i > 1; i++) {
            if (i > 0) {
                System.out.println("Thiet bi co cong suat la ");
            }
        }
    }

    public DienMay(String maHH, String tenHH, double soLuongTon, double donGia) {
        super(maHH, tenHH, soLuongTon, donGia);
        this.BaoHanh();
        this.CongSuat();
    }

    @Override
    public String toString() {
        return "DienMay []" + super.toString();
    }

}