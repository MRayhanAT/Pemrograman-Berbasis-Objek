public final class AlatSyuting extends Alat implements BisaDisewa {
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
