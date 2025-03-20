import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

public class ManajemenBuku {
    private ArrayList<Buku> daftarBuku = new ArrayList<>();
    private final String FILE_NAME = "buku.txt";

    public ManajemenBuku() {
        daftarBuku = new ArrayList<>();
        bacaDariFile();
    }

    public void tambahBuku(Buku buku) {
        daftarBuku.add(buku);
        simpanKeFile();
    }

    public void tampilkanSemuaBuku() {
        for (Buku buku : daftarBuku) {
            buku.tampilInfoBuku();
            System.out.println();
        }
    }

    private void bacaDariFile() {
        try (BufferedReader br = new BufferedReader(new FileReader("buku.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String judul = data[0];
                String penulis = data[1];
                int tahunTerbit = Integer.parseInt(data[2]);
                Buku buku = new Buku(judul, penulis, tahunTerbit);
                daftarBuku.add(buku);
            }
        } catch (IOException e) {
            System.out.println("Gagal membaca file: " + e.getMessage());
        }
    }

    private void simpanKeFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("buku.txt"))) {
            for (Buku buku : daftarBuku) {
                bw.write(buku.getJudul() + "," + buku.getPenulis() + "," + buku.getTahunTerbit());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Gagal menyimpan file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        ManajemenBuku manajemen = new ManajemenBuku();
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
                    System.out.print("Judul Buku: ");
                    String judul = io.nextLine();
                    System.out.print("Penulis Buku: ");
                    String penulis = io.nextLine();
                    System.out.print("Tahun Terbit: ");
                    int tahunTerbit = io.nextInt();
                    io.nextLine();

                    Buku bukuBaru = new Buku(judul, penulis, tahunTerbit);
                    manajemen.tambahBuku(bukuBaru);
                    System.out.println("Buku berhasil ditambahkan");
                    break;
                case 2:
                    manajemen.tampilkanSemuaBuku();
                    break;
                case 3:
                    System.out.println("Program selesai");
                    System.out.println("-------------------");
                    return;
                default:
                    System.out.println("Coba lagi");
                    System.out.println("-------------------");
            }
        }
    }
}
