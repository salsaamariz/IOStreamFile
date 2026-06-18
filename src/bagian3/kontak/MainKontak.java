package bagian3.kontak;

public class MainKontak {
    public static void main(String[] args) {
        // 1. Membuat objek pengelola dan mengisinya dengan format baru (Nama, Nomor, Email)
        BukuKontak buku = new BukuKontak("kontak.txt");
        buku.tambahKontak(new Kontak("Andi", "0811111", "andi@email.com"));
        buku.tambahKontak(new Kontak("Budi", "0822222", "budi@email.com"));
        buku.tambahKontak(new Kontak("Citra", "0833333", "citra@email.com"));

        System.out.println("--- Tahap 1: Inisialisasi & Simpan Data Baru ---");
        buku.tampilkanSemua();
        buku.simpanKeBerkas();
        System.out.println();

        // 2. Menguji SOAL 1: Method cariKontak
        System.out.println("--- Tahap 2: Pengujian Soal 1 (cariKontak) ---");
        buku.cariKontak("Budi");  // Skenario ada
        buku.cariKontak("Dedi");  // Skenario tidak ada
        System.out.println();

        // 3. Menguji SOAL 3: Method hapusKontak
        System.out.println("--- Tahap 3: Pengujian Soal 3 (hapusKontak) ---");
        buku.hapusKontak("Andi"); // Menghapus Andi dan otomatis save berkas baru
        System.out.println();

        // 4. Menguji SOAL 2: Memuat kembali dari berkas untuk membuktikan data terupdate dengan benar
        System.out.println("--- Tahap 4: Pengujian Soal 2 (Muat Ulang Berkas 3 Kolom) ---");
        BukuKontak bukuLain = new BukuKontak("kontak.txt");
        bukuLain.muatDariBerkas();
        bukuLain.tampilkanSemua();
        System.out.println("Jumlah kontak akhir: " + bukuLain.jumlahKontak());
    }
}