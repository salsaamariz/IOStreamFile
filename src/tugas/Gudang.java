package tugas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Gudang {
    // Menyimpan daftar barang
    private ArrayList<Barang> daftarBarang = new ArrayList<>();
    private String namaBerkas;

    // Constructor
    public Gudang(String namaBerkas) {
        this.namaBerkas = namaBerkas;
    }

    // Method menambah barang
    public void tambahBarang(Barang barang) {
        daftarBarang.add(barang);
    }

    // Method menampilkan semua barang
    public void tampilkanSemua() {
        System.out.println("== Daftar Barang di Gudang ==");
        for (int i = 0; i < daftarBarang.size(); i++) {
            System.out.println((i + 1) + ". " + daftarBarang.get(i).info());
        }
    }

    // Method menyimpan seluruh barang ke berkas txt
    public void simpanKeBerkas() {
        try (PrintWriter penulis = new PrintWriter(new FileWriter(namaBerkas))) {
            for (Barang b : daftarBarang) {
                penulis.println(b.keBaris());
            }
            System.out.println("[Sistem] Data berhasil disimpan ke berkas: " + namaBerkas);
        } catch (IOException e) {
            System.out.println("Gagal menyimpan ke berkas: " + e.getMessage());
        }
    }

    // Method memuat data dari berkas txt
    public void muatDariBerkas() {
        daftarBarang.clear(); // Bersihkan list sebelum memuat data baru
        try (BufferedReader pembaca = new BufferedReader(new FileReader(namaBerkas))) {
            String baris;
            while ((baris = pembaca.readLine()) != null) {
                String[] bagian = baris.split(";");
                if (bagian.length == 3) {
                    // Konversi tipe data String kembali ke double dan int
                    String nama = bagian[0];
                    double harga = Double.parseDouble(bagian[1]);
                    int stok = Integer.parseInt(bagian[2]);
                    
                    daftarBarang.add(new Barang(nama, harga, stok));
                }
            }
            System.out.println("[Sistem] Data berhasil dimuat dari berkas: " + namaBerkas);
        } catch (IOException e) {
            System.out.println("Gagal memuat dari berkas: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Terdapat kesalahan format angka pada berkas.");
        }
    }

    // Method menjumlahkan total (harga * stok) seluruh barang
    public double totalNilai() {
        double total = 0;
        for (Barang b : daftarBarang) {
            total += (b.getHarga() * b.getStok());
        }
        return total;
    }
}