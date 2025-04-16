import java.util.ArrayList;
import java.util.Scanner;

class Alat {
    int id;
    String namaAlat;
    int harga;

    Alat(int id, String namaAlat, int harga) {
        this.id = id;
        this.namaAlat = namaAlat;
        this.harga = harga;
    }

    public void tampilkanInfo() {
        System.out.println("Alat: " + namaAlat + " | Harga: Rp" + harga + " | ID: " + id);
    }

    //Method Overloading
    public void tampilkanInfo(boolean lengkap) {
        if (lengkap) {
            System.out.println(">> Detail Lengkap Alat <<");
            System.out.println("ID       : " + id);
            System.out.println("Nama     : " + namaAlat);
            System.out.println("Harga    : Rp" + harga);
        } else {
            tampilkanInfo();
        }
    }
}

class AlatSyuting extends Alat {
    AlatSyuting(int id, String namaAlat, int harga) {
        super(id, namaAlat, harga);
    }

    //Method Overriding
    @Override
    public void tampilkanInfo() {
        System.out.println("Alat Syuting: " + namaAlat + " | Harga Sewa/Hari: Rp" + harga);
    }
}

public class App {
    public static void main(String[] args) {
        ArrayList<Alat> daftarAlat = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        int idCounter = 1;

        while (running) {
            System.out.println("\nMenu PT.SiapRekam");
            System.out.println("1. Tampilkan daftar alat (biasa)");
            System.out.println("2. Tampilkan daftar alat (detail)");
            System.out.println("3. Tambahkan alat syuting");
            System.out.println("4. Ubah data alat");
            System.out.println("5. Hapus data alat");
            System.out.println("6. Keluar");
            System.out.print("Pilihan (1-6): ");
            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    if (daftarAlat.isEmpty()) {
                        System.out.println("Belum ada alat yang tersedia.");
                    } else {
                        System.out.println("Daftar Alat (Versi Biasa):");
                        for (Alat alat : daftarAlat) {
                            alat.tampilkanInfo(); 
                        }
                    }
                    break;

                case 2:
                    if (daftarAlat.isEmpty()) {
                        System.out.println("Belum ada alat yang tersedia.");
                    } else {
                        System.out.println("Daftar Alat (Versi Detail):");
                        for (Alat alat : daftarAlat) {
                            alat.tampilkanInfo(true); 
                        }
                    }
                    break;

                case 3:
                    System.out.print("Masukkan nama alat: ");
                    String nama = scanner.nextLine();
                    System.out.print("Masukkan harga sewa per hari: Rp");
                    int harga = scanner.nextInt();
                    scanner.nextLine();
                    daftarAlat.add(new AlatSyuting(idCounter, nama, harga));
                    System.out.println("Alat berhasil ditambahkan dengan ID: " + idCounter);
                    idCounter++;
                    break;

                case 4:
                    System.out.print("Masukkan ID alat yang ingin diubah: ");
                    int idUbah = scanner.nextInt();
                    scanner.nextLine();
                    boolean ditemukan = false;
                    for (Alat alat : daftarAlat) {
                        if (alat.id == idUbah) {
                            System.out.print("Masukkan nama alat baru: ");
                            alat.namaAlat = scanner.nextLine();
                            System.out.print("Masukkan harga sewa per hari baru: Rp");
                            alat.harga = scanner.nextInt();
                            scanner.nextLine();
                            System.out.println("Data alat berhasil diubah.");
                            ditemukan = true;
                            break;
                        }
                    }
                    if (!ditemukan) {
                        System.out.println("Alat dengan ID tersebut tidak ditemukan.");
                    }
                    break;

                case 5:
                    System.out.print("Masukkan ID alat yang ingin dihapus: ");
                    int idHapus = scanner.nextInt();
                    scanner.nextLine();
                    boolean dihapus = false;
                    for (int i = 0; i < daftarAlat.size(); i++) {
                        if (daftarAlat.get(i).id == idHapus) {
                            daftarAlat.remove(i);
                            System.out.println("Alat berhasil dihapus.");
                            dihapus = true;
                            break;
                        }
                    }
                    if (!dihapus) {
                        System.out.println("Alat dengan ID tersebut tidak ditemukan.");
                    }
                    break;

                case 6:
                    running = false;
                    System.out.println("Terima kasih telah menggunakan layanan kami.");
                    break;

                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }

        scanner.close();
    }
}
