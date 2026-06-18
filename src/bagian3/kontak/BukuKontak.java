package bagian3.kontak;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;

public class BukuKontak {
    private ArrayList<Kontak> daftar = new ArrayList<>();
    private String namaBerkas;

    public BukuKontak(String namaBerkas) {
        this.namaBerkas = namaBerkas;
    }

    public void tambahKontak(Kontak kontak) {
        daftar.add(kontak);
    }

    public void tampilkanSemua() {
        System.out.println("== Daftar Kontak ==");
        for (int i = 0; i < daftar.size(); i++) {
            Kontak k = daftar.get(i);
            System.out.println((i + 1) + ". " + k.info());
        }
    }

    public void simpanKeBerkas() {
        try (PrintWriter penulis = new PrintWriter(new FileWriter(namaBerkas))) {
            for (Kontak k : daftar) {
                penulis.println(k.keBaris());
            }
            System.out.println("Kontak disimpan ke " + namaBerkas);
        } catch (IOException e) {
            System.out.println("Gagal menyimpan: " + e.getMessage());
        }
    }

    // SOAL 1: Method untuk mencari kontak berdasarkan nama
    public void cariKontak(String nama) {
        System.out.println(" Pencarian Kontak dengan Nama: \"" + nama + "\"");
        boolean ditemukan = false;
        for (Kontak k : daftar) {
            // Menggunakan equalsIgnoreCase agar pencarian tidak sensitif huruf besar/kecil
            if (k.getNama().equalsIgnoreCase(nama)) {
                System.out.println("Ditemukan -> " + k.info());
                ditemukan = true;
                break;
            }
        }
        if (!ditemukan) {
            System.out.println("Pesan: Kontak dengan nama '" + nama + "' tidak ditemukan.");
        }
    }

    // SOAL 2: Menyesuaikan pemisahan berkas menjadi tiga bagian (nama, nomor, email)
    public void muatDariBerkas() {
        daftar.clear();
        try (BufferedReader pembaca = new BufferedReader(new FileReader(namaBerkas))) {
            String baris;
            while ((baris = pembaca.readLine()) != null) {
                String[] bagian = baris.split(";");
                // Diubah dari == 2 menjadi == 3 karena sekarang ada tambahan email
                if (bagian.length == 3) {
                    daftar.add(new Kontak(bagian[0], bagian[1], bagian[2]));
                }
            }
            System.out.println("Kontak dimuat dari " + namaBerkas);
        } catch (IOException e) {
            System.out.println("Gagal memuat: " + e.getMessage());
        }
    }

    // SOAL 3: Method untuk menghapus kontak berdasarkan nama, lalu simpan ke berkas
    public void hapusKontak(String nama) {
        System.out.println(" Penghapusan Kontak dengan Nama: \"" + nama + "\"");
        boolean ditemukan = false;
        for (int i = 0; i < daftar.size(); i++) {
            if (daftar.get(i).getNama().equalsIgnoreCase(nama)) {
                daftar.remove(i);
                System.out.println("Sukses: Kontak '" + nama + "' telah dihapus dari daftar.");
                ditemukan = true;
                break; 
            }
        }
        
        if (ditemukan) {
            // Panggil simpanKeBerkas agar perubahan langsung permanen di file txt
            simpanKeBerkas();
        } else {
            System.out.println("Gagal Hapus: Kontak '" + nama + "' tidak ditemukan.");
        }
    }

    public int jumlahKontak() {
        return daftar.size();
    }
}