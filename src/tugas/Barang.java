package tugas;

import java.text.DecimalFormat;

public class Barang {
    // Atribut tetap sama
    private String nama;
    private double harga;
    private int stok;

    // Constructor tetap sama
    public Barang(String nama, double harga, int stok) {
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
    }

    // Getter tetap sama
    public String getNama() {
        return nama;
    }

    public double getHarga() {
        return harga;
    }

    public int getStok() {
        return stok;
    }

    // Method keBaris tetap sama (untuk keperluan save ke txt)
    public String keBaris() {
        return nama + ";" + harga + ";" + stok;
    }

    // Method info: DIPERBAIKI agar harga tidak error/muncul notasi ilmiah
    public String info() {
        DecimalFormat df = new DecimalFormat("#,###");
        return nama + " | Harga: Rp" + df.format(harga) + " | Stok: " + stok + " unit";
    }
}