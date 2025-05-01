public abstract class Alat {
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
