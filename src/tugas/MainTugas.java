package tugas;

public class MainTugas {
    public static void main(String[] args) {
        
        // =================================================================
        // Syarat Tambahan 1: Array Kategori (Minimal 3)
        // =================================================================
        System.out.println("--- Kategori Toko ---");
        String[] kategori = {"Elektronik", "Sembako", "Pakaian", "Alat Tulis"};
        for (int i = 0; i < kategori.length; i++) {
            System.out.println("- " + kategori[i]);
        }
        System.out.println();

        // =================================================================
        // Syarat Tambahan 2: Membuat, Menambah, dan Menyimpan Data
        // =================================================================
        String namaFile = "barang.txt";
        Gudang gudangAwal = new Gudang(namaFile);

        // Menambah minimal 5 objek Barang
        gudangAwal.tambahBarang(new Barang("Laptop Asus", 12000000, 5));
        gudangAwal.tambahBarang(new Barang("Mouse Wireless", 150000, 20));
        gudangAwal.tambahBarang(new Barang("Beras 5Kg", 75000, 50));
        gudangAwal.tambahBarang(new Barang("Kemeja Flanel", 120000, 15));
        gudangAwal.tambahBarang(new Barang("Buku Tulis", 5000, 100));

        System.out.println("--- Mengisi Data Gudang Awal ---");
        gudangAwal.tampilkanSemua();
        
        // Menyimpan ke file barang.txt
        gudangAwal.simpanKeBerkas();
        System.out.println();

        // =================================================================
        // Syarat Tambahan 3: Objek Gudang Baru & Pembuktian Muat Data
        // =================================================================
        System.out.println("--- Memuat Ulang Data (Gudang Baru) ---");
        Gudang gudangBaru = new Gudang(namaFile); // Objek baru, datanya kosong
        
        // Memuat dari file text yang tadi disimpan
        gudangBaru.muatDariBerkas(); 
        gudangBaru.tampilkanSemua();

        // Menampilkan total nilai persediaan
        System.out.printf("\nTotal Nilai Persediaan Barang: Rp%,.0f%n", gudangBaru.totalNilai());
    }
}