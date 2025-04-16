import java.util.ArrayList;
import java.util.Scanner;

class AlatSyuting {
    private int id;
    private String namaAlat;
    private int harga;
    
    public AlatSyuting(int id, String namaAlat, int harga) {
        this.id = id;
        this.namaAlat = namaAlat;
        this.harga = harga;
    }
    
    public int getId() {
        return id;
    }
    
    public String getNamaAlat() {
        return namaAlat;
    }
    
    public void setNamaAlat(String namaAlat) {
        this.namaAlat = namaAlat;
    }
    
    public int getHarga() {
        return harga;
    }
    
    public void setHarga(int harga) {
        this.harga = harga;
    }
    
    @Override
    public String toString() {
        return "Nama = " + namaAlat + ", Harga sewa/hari = Rp" + harga + ", ID = " + id;
    }
}

public class App {
    public static void main(String[] args) {
        ArrayList<AlatSyuting> daftarAlatSyuting = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        int idCounter = 1;
        
        while (running) {
            System.out.println("\nMenu PT.SiapRekam");
            System.out.println("1. Tampilkan daftar alat");
            System.out.println("2. Tambahkan alat");
            System.out.println("3. Ubah data alat");
            System.out.println("4. Hapus data alat");
            System.out.println("5. Keluar");
            System.out.print("Pilihan (1-5): ");
            int pilihan = scanner.nextInt();
            scanner.nextLine();
            
            switch (pilihan) {
                case 1:
                    if (daftarAlatSyuting.isEmpty()) {
                        System.out.println("Belum ada alat yang tersedia.");
                    } else {
                        System.out.println("Daftar Alat:");
                        for (AlatSyuting alat : daftarAlatSyuting) {
                            System.out.println(alat);
                        }
                    }
                    break;
                
                case 2:
                    System.out.print("Masukkan nama alat: ");
                    String nama = scanner.nextLine();
                    System.out.print("Masukkan harga sewa per hari: Rp");
                    int harga = scanner.nextInt();
                    scanner.nextLine();
                    daftarAlatSyuting.add(new AlatSyuting(idCounter, nama, harga));
                    System.out.println("Alat berhasil ditambahkan dengan ID: " + idCounter);
                    idCounter++;
                    break;
                
                case 3:
                    System.out.print("Masukkan ID alat yang ingin diubah: ");
                    int idUbah = scanner.nextInt();
                    scanner.nextLine();
                    boolean ditemukan = false;
                    for (AlatSyuting alat : daftarAlatSyuting) {
                        if (alat.getId() == idUbah) {
                            System.out.print("Masukkan nama alat baru: ");
                            alat.setNamaAlat(scanner.nextLine());
                            System.out.print("Masukkan harga sewa per hari baru: Rp");
                            alat.setHarga(scanner.nextInt());
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
                
                case 4:
                    System.out.print("Masukkan ID alat yang ingin dihapus: ");
                    int idHapus = scanner.nextInt();
                    scanner.nextLine();
                    boolean dihapus = false;
                    for (int i = 0; i < daftarAlatSyuting.size(); i++) {
                        if (daftarAlatSyuting.get(i).getId() == idHapus) {
                            daftarAlatSyuting.remove(i);
                            System.out.println("Alat berhasil dihapus.");
                            dihapus = true;
                            break;
                        }
                    }
                    if (!dihapus) {
                        System.out.println("Alat dengan ID tersebut tidak ditemukan.");
                    }
                    break;
                
                case 5:
                    running = false;
                    System.out.println("Program selesai. Terima kasih telah menggunakan layanan kami.");
                    break;
                
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
        scanner.close();
    }
}
