package bagian1.berkas;

import java.io.File;
import java.io.IOException;

public class LatihanBerkas {

    public static void main(String[] args) {
        
        // =====================================================================
        // Soal 1: Cek keberadaan dan ukuran file laporan.txt
        // =====================================================================
        
        System.out.println("--- Soal 1 ---");
        File fileLaporan = new File("laporan.txt");
        
        if (fileLaporan.exists()) {
            System.out.println("Berkas 'laporan.txt' ditemukan.");
            System.out.println("Ukuran berkas: " + fileLaporan.length() + " byte");
        } else {
            System.out.println("Berkas 'laporan.txt' tidak ditemukan.");
        }
        
        System.out.println(); // Jeda baris

        // =====================================================================
        // Soal 2: Membuat folder baru bernama 'arsip' menggunakan mkdir()
        // =====================================================================
        System.out.println("--- Soal 2 ---");
        File folderArsip = new File("arsip");
        
        if (folderArsip.mkdir()) {
            System.out.println("Berhasil: Folder 'arsip' telah dibuat.");
        } else {
            // mkdir() akan mengembalikan false jika folder sudah ada atau gagal dibuat
            System.out.println("Gagal: Folder 'arsip' gagal dibuat (atau folder sudah ada).");
        }
        
        System.out.println(); // Jeda baris

        // =====================================================================
        // Soal 3: Membuat file sementara.txt, cek status, lalu hapus dengan delete()
        // =====================================================================
        System.out.println("--- Soal 3 ---");
        File fileSementara = new File("sementara.txt");
        
        try {
            // Membuat berkas baru
            if (fileSementara.createNewFile()) {
                System.out.println("Berkas 'sementara.txt' berhasil dibuat.");
            } else {
                System.out.println("Berkas 'sementara.txt' sudah ada sebelumnya.");
            }
            
            // Tampilkan status keberadaan SEBELUM dihapus
            System.out.println("Status sebelum dihapus (apakah ada?): " + fileSementara.exists());
            
            // Menghapus berkas
            if (fileSementara.delete()) {
                System.out.println("Berkas 'sementara.txt' berhasil dihapus.");
            } else {
                System.out.println("Gagal menghapus berkas 'sementara.txt'.");
            }
            
            // Tampilkan status keberadaan SESUDAH dihapus
            System.out.println("Status sesudah dihapus (apakah ada?): " + fileSementara.exists());
            
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan I/O: " + e.getMessage());
        }
    }
}