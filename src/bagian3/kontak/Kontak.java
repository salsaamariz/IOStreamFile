package bagian3.kontak;

public class Kontak {
    // Atribut: data yang dimiliki setiap kontak (Ditambah email sesuai Soal 2)
    private String nama;
    private String nomor;
    private String email;

    // Constructor diperbarui untuk menerima parameter email
    public Kontak(String nama, String nomor, String email) {
        this.nama = nama;
        this.nomor = nomor;
        this.email = email;
    }

    // Getter untuk membaca atribut
    public String getNama() {
        return nama;
    }

    public String getNomor() {
        return nomor;
    }

    public String getEmail() {
        return email;
    }

    // Mengubah objek menjadi satu baris teks dengan pemisah ";" (Menjadi 3 bagian)
    public String keBaris() {
        return nama + ";" + nomor + ";" + email;
    }

    // Mengembalikan keterangan kontak dalam bentuk teks lengkap dengan email
    public String info() {
        return nama + " - " + nomor + " (" + email + ")";
    }
}