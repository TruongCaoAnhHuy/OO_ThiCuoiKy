package test;

public abstract class HangHoa {
    private String MaHH;
    private String TenHH;
    private double SoLuongTon;
    private double DonGia;

    public void setMaHH(String maHH) {
        MaHH = "0000";
        MaHH = maHH;
    }

    public String getMaHH() {
        return MaHH;
    }

    public void setTenHH(String tenHH) {
        tenHH = "Hang hoa";
        TenHH = tenHH;
    }

    public String getTenHH() {
        return TenHH;
    }

    public void setSoLuongTon(double soLuongTon) {
        if (soLuongTon > 0) {
            SoLuongTon = soLuongTon;

        } else {
            System.out.println("Hiện tại hàng đã hết!");
        }
        SoLuongTon = soLuongTon;
    }

    public double getSoLuongTon() {
        return SoLuongTon;
    }

    public void setDonGia(double donGia) {
        if (donGia > 0) {
            DonGia = donGia;

        }
        DonGia = donGia;
    }

    public double getDonGia() {
        return DonGia;
    }

    public HangHoa() {
    }

    public HangHoa(String maHH, String tenHH, double soLuongTon, double donGia) {
        MaHH = maHH;
        TenHH = tenHH;
        SoLuongTon = soLuongTon;
        DonGia = donGia;
    }

    @Override
    public String toString() {
        return "HangHoa [DonGia=" + DonGia + ", MaHH=" + MaHH + ", SoLuongTon=" + SoLuongTon + ", TenHH=" + TenHH + "]";
    }

}