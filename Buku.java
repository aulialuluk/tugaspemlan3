public class Buku {
    private String Judul;
    private String Penulis;
    private int TahunTerbit;
  
    public Buku(String Judul, String Penulis, int TahunTerbit){
        this.Judul = Judul;
        this.Penulis = Penulis;
        this.TahunTerbit = TahunTerbit;
    }
        public void tampilInfoBuku() {
            System.out.println("Judul Buku: " + Judul);
            System.out.println("Penulis Buku: " + Penulis);
            System.out.println("Tahun Terbit: "+ TahunTerbit);
    }
}

