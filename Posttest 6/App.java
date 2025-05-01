import java.util.ArrayList;
import java.util.Scanner;

// Interface
interface BisaDisewa {
    void sewa();
    void kembali();
}


class Utilitas {
    static int totalAlat = 0;

    static void tampilkanJumlahAlat() {
        System.out.println("Total alat yang terdaftar: " + totalAlat);
    }
}


abstract class Alat {
    int id;
    String namaAlat;
    int harga;
    final String jenis = "Elektronik";

    Alat(int id, String namaAlat, int harga) {
        this.id = id;
        this.namaAlat = namaAlat;
        this.harga = harga;
    }

    public abstract void tampilkanInfo();

    public void tampilkanInfo(boolean lengkap) {
        if (lengkap) {
            System.out.println(">> Detail Lengkap Alat <<");
            System.out.println("ID       : " + id);
            System.out.println("Nama     : " + namaAlat);
            System.out.println("Harga    : Rp" + harga);
            infoAlat();
        } else {
            tampilkanInfo();
        }
    }

    public final void infoAlat() {
        System.out.println("Jenis alat ini adalah: " + jenis);
    }
}

final class AlatSyuting extends Alat implements BisaDisewa {
    AlatSyuting(int id, String namaAlat, int harga) {
        super(id, namaAlat, harga);
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("Alat Syuting: " + namaAlat + " | Harga Sewa/Hari: Rp" + harga);
        infoAlat();
    }

    @Override
    public void sewa() {
        System.out.println(namaAlat + " sedang disewa.");
    }

    @Override
    public void kembali() {
        System.out.println(namaAlat + " telah dikembalikan.");
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
            System.out.println("7. Tampilkan total alat");
            System.out.print("Pilihan (1-7): ");

            try {
                int pilihan = scanner.nextInt();
                scanner.nextLine();

                switch (pilihan) {
                    case 1 -> {
                        if (daftarAlat.isEmpty()) {
                            System.out.println("Belum ada alat yang tersedia.");
                        } else {
                            System.out.println("Daftar Alat (Versi Biasa):");
                            for (Alat alat : daftarAlat) {
                                alat.tampilkanInfo();
                            }
                        }
                    }
                    case 2 -> {
                        if (daftarAlat.isEmpty()) {
                            System.out.println("Belum ada alat yang tersedia.");
                        } else {
                            System.out.println("Daftar Alat (Versi Detail):");
                            for (Alat alat : daftarAlat) {
                                alat.tampilkanInfo(true);
                            }
                        }
                    }
                    case 3 -> {
                        System.out.print("Masukkan nama alat: ");
                        String nama = scanner.nextLine();
                        System.out.print("Masukkan harga sewa per hari: Rp");
                        int harga = scanner.nextInt();
                        scanner.nextLine();
                        AlatSyuting alatBaru = new AlatSyuting(idCounter, nama, harga);
                        daftarAlat.add(alatBaru);
                        Utilitas.totalAlat++;
                        System.out.println("Alat berhasil ditambahkan dengan ID: " + idCounter);
                        alatBaru.sewa();
                        idCounter++;
                    }
                    case 4 -> {
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
                    }
                    case 5 -> {
                        System.out.print("Masukkan ID alat yang ingin dihapus: ");
                        int idHapus = scanner.nextInt();
                        scanner.nextLine();
                        boolean dihapus = false;
                        for (int i = 0; i < daftarAlat.size(); i++) {
                            if (daftarAlat.get(i).id == idHapus) {
                                daftarAlat.remove(i);
                                Utilitas.totalAlat--;
                                System.out.println("Alat berhasil dihapus.");
                                dihapus = true;
                                break;
                            }
                        }
                        if (!dihapus) {
                            System.out.println("Alat dengan ID tersebut tidak ditemukan.");
                        }
                    }
                    case 6 -> {
                        running = false;
                        System.out.println("Terima kasih telah menggunakan layanan kami.");
                    }
                    case 7 -> Utilitas.tampilkanJumlahAlat();
                    default -> System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                }
            } catch (Exception e) {
                System.out.println("Terjadi kesalahan input. Harap masukkan angka yang valid.");
                scanner.nextLine(); 
            }
        }

        scanner.close();
    }
}
