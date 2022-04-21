package test;

public class SanhSu extends HangHoa implements HangSanhSu {

    @Override
    public void NhaSX() {
        System.out.println("Nha san xuat la:");
    }

    @Override
    public void NgayNK() {
        System.out.println("Ngày sản xuất là:");
    }

    @Override
    public void setDonGia(double donGia) {
        donGia = donGia * 0.1;
        System.out.println("Đơn giá sau khi đã tính cả vat" + donGia);
    }

    @Override
    public void setSoLuongTon(double soLuongTon) {
        if (getSoLuongTon() > 50) {
            System.out.println("Bán chậm quá đừng nhập nữa");
        } else {
            System.out.println("Hết hàng rồi nhập thêm đi");
        }
        super.setSoLuongTon(soLuongTon);
    }

    public SanhSu(String maHH, String tenHH, double soLuongTon, double donGia) {
        super(maHH, tenHH, soLuongTon, donGia);
        this.NgayNK();
        this.NhaSX();
    }

    @Override
    public String toString() {
        return "SanhSu []" + super.toString();
    }

}