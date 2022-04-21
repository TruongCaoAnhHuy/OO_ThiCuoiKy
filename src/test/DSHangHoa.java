package test;

import java.util.ArrayList;
import java.util.List;

public class DSHangHoa {
    List<HangHoa> dHangHoa = new ArrayList<>();

    public DSHangHoa(HangHoa hangHoa) {
        System.out.printf("TP01", "bot ngot", 2500, 17000, 27 / 05 / 2022, 16 / 06 / 2023);
        System.out.printf("TP02", "haohao", 1000, 3500, 15 / 05 / 2022, 23 / 12 / 2022);
        System.out.printf("TP03", "ngu coc", 5600, 54000, 26 / 05 / 2022, 23 / 12 / 20223);
        System.out.printf("TP04", "oreo", 3000, 42000, 15 / 05 / 2022, 23 / 12 / 2023);
        System.out.printf("TP05", "banh mi", 3000, 30000, 15 / 05 / 2022, 23 / 12 / 2023);
        System.out.printf("DM06", "TIVI LG", 3000, 4250000, 450, 12);
        System.out.printf("DM07", "Tu lanh LG", 2000, 10500000, 450, 16);
        System.out.printf("DM08", "Lo vi song ", 2540, 5000000, 850, 12);
        System.out.printf("DM09", "Bep tu ", 3000, 3500000, 450, 12);
        System.out.printf("SS10", "Bat su long phuong", 2000, 850000, "Long Phuong");

    }

    public DSHangHoa() {
    }

    public void Them(HangHoa hangHoa) {

        dHangHoa.add(hangHoa);
    }

    public void inDanhSach() {
        for (HangHoa hangHoa : dHangHoa) {
            System.out.println(hangHoa);
        }
    }

    public HangHoa tiemkiemHangHoa(String MaHH) {

        HangHoa hangHoa = null;
        for (HangHoa hh : dHangHoa) {
            if (hh.getMaHH().equalsIgnoreCase(MaHH)) {
                hangHoa = (HangHoa) hh;
            }
        }
        return hangHoa;

    }

    public void xoaGiaoDich(HangHoa hangHoa) {
        this.dHangHoa.remove(hangHoa);
    }

    // tim vi tri cua Giao Dich torng danh sach
    public int timViTriCuaGD(HangHoa hangHoa) {
        int viTri = -1;
        viTri = this.dHangHoa.indexOf(hangHoa);
        return viTri;
    }

    public void suaGiaoDich(int viTri, HangHoa hangHoa) {
        this.dHangHoa.set(viTri, hangHoa);
    }

    public void suaGiaoDich(String hanghoa) {
    }

    public void viTri(boolean b) {
    }

    public void add(String string, String string2, int i, int j, int k, int l) {
    }
}