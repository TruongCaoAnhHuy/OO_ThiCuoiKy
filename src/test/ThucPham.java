package test;

import java.io.Serializable;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class ThucPham extends HangHoa implements HangThucPham, Serializable {
    Date nsx;
    Date hsd;

    @Override
    public Void NSX() {
        if (nsx.before(this.hsd)) {
            this.nsx = nsx;
        } else {
            this.nsx = new Date(0);
        }
        return NSX();
    }

    @Override
    public Void HSD() {
        if (hsd.after(this.nsx)) {
            this.hsd = hsd;
        } else {
            this.hsd = new Date(7);
        }
        return null;
    }

    public ThucPham(String maHH, String tenHH, double soLuongTon, double donGia, int nsx2, int hsd2) {
        super(maHH, tenHH, soLuongTon, donGia);
        this.nsx = nsx;
        this.hsd = hsd;
    }

    @Override
    public void setSoLuongTon(double soLuongTon) {
        if (getSoLuongTon() > 0 && nsx.after(this.hsd)) {
            System.out.println("Khó bán quá giảm số lượng nhập đi");
        }
        super.setSoLuongTon(soLuongTon);
    }

    @Override
    public String toString() {
        SimpleDateFormat ngayVietNam = new SimpleDateFormat();
        return "ThucPham [hsd=" + ngayVietNam.format(hsd) + ", nsx=" + ngayVietNam.format(nsx) + "]" + super.toString();
    }

}