import java.util.ArrayList;
import java.util.Scanner;



class alatsyuting {
    int id;
    String NamaAlat;
    int Harga;
    
    

    
    alatsyuting(int id, String NamaAlat, int Harga){
        this.NamaAlat = NamaAlat;
        this.Harga = Harga;
        this.id = id;

    }


    public String toString() {
        return "Nama = " + NamaAlat + ", Harga sewa/hari = " + Harga + ", ID = " + id;
    }



}

public class App {
    public static void main(String[] args) {
        ArrayList<alatsyuting> daftarAlatsyuting = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        int idcounter = 1;
        

        while (running) {
            System.out.println("\nMenu PT.SiapRekam");
            System.out.println("1. Tampilkan daftar alat");
            System.out.println("2. Tambahkan alat");
            System.out.println("3. Ubah data alat");
            System.out.println("4. Hapus data alat");
            System.out.println("5. Keluar");
            System.out.println("Pilihan (1-5): ");
            int pilihan = scanner.nextInt();
            scanner.nextLine();
            
            switch(pilihan) { 

                case 1:
                if (daftarAlatsyuting.isEmpty()) {
                    System.out.println("Belum ada alat yang tersedia.");
                } else {
                    System.out.println("Daftar Alat:");
                    for (alatsyuting alat : daftarAlatsyuting) {
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
                daftarAlatsyuting.add(new alatsyuting(idcounter, nama, harga));
                System.out.println("Alat berhasil ditambahkan dengan ID: " + idcounter);
                idcounter++;
                break;

            case 3:
                System.out.print("Masukkan ID alat yang ingin diubah: ");
                int idUbah = scanner.nextInt();
                scanner.nextLine(); 
                boolean ditemukan = false;
                for (alatsyuting alat : daftarAlatsyuting) {
                    if (alat.id == idUbah) {
                        System.out.print("Masukkan nama alat baru: ");
                        alat.NamaAlat = scanner.nextLine();
                        System.out.print("Masukkan harga sewa per hari baru: Rp");
                        alat.Harga = scanner.nextInt();
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
                for (int i = 0; i < daftarAlatsyuting.size(); i++) {
                    if (daftarAlatsyuting.get(i).id == idHapus) {
                        daftarAlatsyuting.remove(i);
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



