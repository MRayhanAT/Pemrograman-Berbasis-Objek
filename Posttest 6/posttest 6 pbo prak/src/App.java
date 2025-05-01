import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ArrayList<Alat> daftarAlat = new ArrayList<>();
        boolean running = true;
        int idCounter = 1;

        try (Scanner scanner = new Scanner(System.in)) {
            while (running) {
            System.out.println("\nMenu PT.SiapRekam");
            System.out.println("1. Tampilkan daftar alat (biasa)");
            System.out.println("2. Tampilkan daftar alat (detail)");
            System.out.println("3. Tambahkan alat syuting");
            System.out.println("4. Ubah data alat");
            System.out.println("5. Hapus data alat");
            System.out.println("6. Tampilkan total alat (static)");
            System.out.println("7. Keluar");
            System.out.print("Pilihan (1-7): ");

            int pilihan = 0;
            try {
                pilihan = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Input harus berupa angka!");
                continue;
            }

            switch (pilihan) {
                case 1 -> {
                    if (daftarAlat.isEmpty()) {
                        System.out.println("Belum ada alat yang tersedia.");
                    } else {
                        for (Alat alat : daftarAlat) {
                            alat.tampilkanInfo();
                        }
                    }
                }
                case 2 -> {
                    if (daftarAlat.isEmpty()) {
                        System.out.println("Belum ada alat yang tersedia.");
                    } else {
                        for (Alat alat : daftarAlat) {
                            alat.tampilkanInfo(true);
                        }
                    }
                }
                case 3 -> {
                    try {
                        System.out.print("Masukkan nama alat: ");
                        String nama = scanner.nextLine();
                        System.out.print("Masukkan harga sewa per hari: Rp");
                        int harga = Integer.parseInt(scanner.nextLine());

                        AlatSyuting alatBaru = new AlatSyuting(idCounter, nama, harga);
                        daftarAlat.add(alatBaru);
                        Utilitas.totalAlat++;

                        System.out.println("Alat berhasil ditambahkan dengan ID: " + idCounter);

                        alatBaru.sewa();
                        alatBaru.kembali();

                        idCounter++;
                    } catch (NumberFormatException e) {
                        System.out.println("Input harga harus berupa angka.");
                    } catch (Exception e) {
                        System.out.println("Terjadi kesalahan: " + e.getMessage());
                    }
                }
                case 4 -> {
                    System.out.print("Masukkan ID alat yang ingin diubah: ");
                    int idUbah = Integer.parseInt(scanner.nextLine());
                    boolean ditemukan = false;
                    for (Alat alat : daftarAlat) {
                        if (alat.id == idUbah) {
                            System.out.print("Masukkan nama alat baru: ");
                            alat.namaAlat = scanner.nextLine();
                            System.out.print("Masukkan harga sewa per hari baru: Rp");
                            alat.harga = Integer.parseInt(scanner.nextLine());
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
                    int idHapus = Integer.parseInt(scanner.nextLine());
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
                case 6 -> Utilitas.tampilkanTotal();
                case 7 -> {
                    running = false;
                    System.out.println("Terima kasih telah menggunakan layanan kami.");
                }
                default -> System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }

        }
    }
}
