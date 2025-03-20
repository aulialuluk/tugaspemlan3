public class Buku {
    private String Judul;
    private String Penulis;
    private int TahunTerbit;

    public Buku(String Judul, String Penulis, int TahunTerbit) {
        this.Judul = Judul;
        this.Penulis = Penulis;
        this.TahunTerbit = TahunTerbit;
    }

    public void tampilInfoBuku() {
        System.out.println("Judul Buku: " + Judul);
        System.out.println("Penulis Buku: " + Penulis);
        System.out.println("Tahun Terbit: " + TahunTerbit);
    }

    public String getJudul() {
        return Judul;
    }

    public String getPenulis() {
        return Penulis;
    }

    public int getTahunTerbit() {
        return TahunTerbit;
    }
}
