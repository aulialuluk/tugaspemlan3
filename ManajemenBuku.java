import java.util.Scanner;

public class ManajemenBuku {
    private static int jumlahBuku = 0;
    private static final int MAKSIMAL_BUKU = 3; 
    private static Buku[] daftarBuku = new Buku[MAKSIMAL_BUKU]; 
    
    public static void main(String[] args) {
        Scanner io = new Scanner(System.in);
        int angka;

        while (true) {
            System.out.println("-------------------");
            System.out.println("--- Perpustakaan --");
            System.out.println("-------------------");
            System.out.println("1. Tambah Buku");
            System.out.println("2. Tampilkan Daftar Buku");
            System.out.println("3. Keluar");
            System.out.print("Opsi : ");
            angka = io.nextInt();
            io.nextLine(); 

            switch (angka) {
                case 1:
                    tambahBuku(io);
                    break;
                case 2:
                    tampilkanDaftarBuku();
                    break;
                case 3:
                    simpanDataBuku();
                    System.out.println("Program selesai.");
                    System.out.println("-------------------");
                    return;
                default:
                    System.out.println("Coba lagi.");
                    System.out.println("-------------------");
            }
        }
    }

    public static void tambahBuku(Scanner io) {
        if (jumlahBuku >= MAKSIMAL_BUKU) {
            System.out.println("Maaf, kapasitas buku penuh.");
            System.out.println("-------------------");
            return;
        }

        System.out.print("Judul Buku: ");
        String judul = io.nextLine();
        System.out.print("Penulis Buku: ");
        String penulis = io.nextLine();
        System.out.print("Tahun Terbit: ");
        int tahunTerbit = io.nextInt();
        io.nextLine(); // Consume newline

        Buku bukuBaru = new Buku(judul, penulis, tahunTerbit);
        daftarBuku[jumlahBuku] = bukuBaru;
        jumlahBuku++;
        System.out.println("Buku berhasil ditambahkan.");
         }

    public static void tampilkanDaftarBuku() {
        if (jumlahBuku == 0) {
            System.out.println("Daftar buku kosong.");
        } else {
            for (int i = 0; i < jumlahBuku; i++) {
                daftarBuku[i].tampilInfoBuku();
                System.out.println("-------------------");
            }
        }
    }

    public static void simpanDataBuku() {
        System.out.println("Data buku telah disimpan.");
       }
}