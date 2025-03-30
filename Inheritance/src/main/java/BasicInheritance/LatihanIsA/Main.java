package BasicInheritance.LatihanIsA;
import java.util.Scanner;
public class Main {


	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Perpustakaan p = new Perpustakaan(3);
		
		BukuCetak bukuCetak1 = new BukuCetak("Harry Potter", "J.K Rowling",1997,10);
		BukuCetak bukuCetak2 = new BukuCetak("The Pragmatic Programmer","Andrew Hunt",1999,10);
		
		BukuDigital bukuDigital1 = new BukuDigital("Clean Code","Robert C. Martin",2008,2.8);
		
		p.tambahBuku(bukuCetak1);
		p.tambahBuku(bukuCetak2);
		p.tambahBuku(bukuDigital1);
		
		
		//Daftar anggota
		p.tambahAnggota();
		
		//Validasi Anggota
		p.loginAnggota();
		
		
		
		
		p.tampilkanSemuaBuku();
		
		//Cari Buku
		while(true) {
			System.out.println("\n🔍 Masukan Judul buku yang ingin dicari (Ketik : Keluar untuk keluar): ");
			String judul = input.nextLine();

			if(judul.equalsIgnoreCase("keluar")) {
				System.out.println("\n🛑 Pencarian Buku dibatalkan!");	
				System.out.println("\n--------------------------------\n");
				break;
			}
			
			boolean ditemukan = p.pencarianBuku(judul);
		
			if(ditemukan) {
				break;
			} else {
				System.out.println("⚠ Coba lagi! Pastikan Judul Buku Benar!");
			}
		}
		
		//Logic Pinjam, Tampilkan Buku yang dipinjam dan Kembalikan Buku
		 while (true) {
	            System.out.println("\n📚 MENU PERPUSTAKAAN 📚");
	            System.out.println("[1] Pinjam Buku");
	            System.out.println("[2] Kembalikan Buku");
	            System.out.println("[3] Lihat Buku yang Dipinjam");
	            System.out.println("[4] Keluar");
	            System.out.print("Pilih menu: ");
	            int pilihan = input.nextInt();
	            input.nextLine(); // konsumsi newline

	            if (pilihan == 1) {
	                System.out.print("🔍 Masukkan judul buku yang ingin dipinjam: ");
	                String judul = input.nextLine();
	                p.peminjamanBuku(judul);
	            } else if (pilihan == 2) {
	                System.out.print("🔄 Masukkan judul buku yang ingin dikembalikan: ");
	                String judul = input.nextLine();
	                p.kembalikanBuku(judul);
	            } else if (pilihan == 3) {
	                p.bukuYangDipinjam();
	            } else if (pilihan == 4) {
	                System.out.println("🚪 Keluar dari perpustakaan...");
	                break;
	            } else {
	                System.out.println("❌ Pilihan tidak valid, coba lagi.");
	            }
	        }
			
		
	}

}
