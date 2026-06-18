package bagian2.bacatulis;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class LatihanHari {

    public static void main(String[] args) {
        String namaFile = "hari.txt";

        // =====================================================================
        // Soal 1: Tulis 5 nama hari ke hari.txt, lalu baca kembali
        // =====================================================================
        System.out.println("--- Soal 1: Menulis 5 Hari Pertama & Membaca Kembali ---");
        String[] limaHari = {"Senin", "Selasa", "Rabu", "Kamis", "Jumat"};
        
        // Menulis ke file (Mode default: menimpa/overwrite jika file sudah ada)
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(namaFile))) {
            for (String hari : limaHari) {
                writer.write(hari);
                writer.newLine(); // Membuat satu nama per baris
            }
            System.out.println("[Sistem] Berhasil menulis 5 hari ke " + namaFile + ".\n");
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat menulis file: " + e.getMessage());
        }

        // Membaca kembali dan menampilkan ke layar
        System.out.println("Isi berkas " + namaFile + " sekarang:");
        bacaDanTampilkanFile(namaFile);
        System.out.println(); // Jeda baris


        // =====================================================================
        // Soal 2: Tambahkan (append) 2 nama hari lagi, lalu tampilkan seluruhnya
        // =====================================================================
        System.out.println("--- Soal 2: Menambahkan (Append) 2 Hari Lagi ---");
        String[] duaHariTambahan = {"Sabtu", "Minggu"};
        
        // Menulis ke file (Mode append: parameter true pada FileWriter agar tidak menghapus isi sebelumnya)
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(namaFile, true))) {
            for (String hari : duaHariTambahan) {
                writer.write(hari);
                writer.newLine();
            }
            System.out.println("[Sistem] Berhasil menambahkan 2 hari tambahan ke " + namaFile + ".\n");
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat append file: " + e.getMessage());
        }

        // Tampilkan seluruh isinya
        System.out.println("Isi berkas " + namaFile + " setelah di-append:");
        bacaDanTampilkanFile(namaFile);
        System.out.println(); // Jeda baris


        // =====================================================================
        // Soal 3: Baca berkas hari.txt lalu hitung banyak baris di dalamnya
        // =====================================================================
        System.out.println("--- Soal 3: Menghitung Banyak Baris ---");
        int jumlahBaris = 0;
        
        try (BufferedReader reader = new BufferedReader(new FileReader(namaFile))) {
            while (reader.readLine() != null) {
                jumlahBaris++; // Setiap baris yang tidak null akan menambah counter
            }
            System.out.println("Jumlah total baris di dalam berkas '" + namaFile + "' adalah: " + jumlahBaris + " baris.");
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat menghitung baris: " + e.getMessage());
        }
    }

    /**
     * Helper method untuk membaca dan menampilkan isi file text ke console
     */
    private static void bacaDanTampilkanFile(String namaFile) {
        try (BufferedReader reader = new BufferedReader(new FileReader(namaFile))) {
            String baris;
            int nomor = 1;
            while ((baris = reader.readLine()) != null) {
                System.out.println(nomor + ". " + baris);
                nomor++;
            }
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat membaca file: " + e.getMessage());
        }
    }
}