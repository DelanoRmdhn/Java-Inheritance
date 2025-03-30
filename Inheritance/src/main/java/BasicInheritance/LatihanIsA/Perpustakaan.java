package BasicInheritance.LatihanIsA;
import java.util.Scanner;

public class Perpustakaan {
	private Buku[] daftarBuku;
	private Buku[] daftarDipinjam;
	private Anggota[] daftarAnggota;
	
	private int jumlahBuku,jumlahBukuDipinjam,jumlahAnggota;

	public Perpustakaan(int kapasitas) {
		this.daftarBuku = new Buku[kapasitas];
		this.daftarDipinjam = new Buku[20];
		this.daftarAnggota = new Anggota[10];
		this.jumlahBuku = 0;
		this.jumlahBukuDipinjam = 0;
		this.jumlahAnggota = 0;
	}
	
	Scanner input = new Scanner(System.in);
	
	public void tambahAnggota() {
		System.out.println("📢 Selamat datang di Perpustakaan!");
		System.out.println("================================\n");
		
		//Cek apakah masih cukup
		if(jumlahAnggota < daftarAnggota.length) {
			System.out.println("Masukan Nama Anda : ");
			String nama = input.nextLine();
			
			System.out.println("Masukan ID Anda :");
			int id = input.nextInt();
			
			
			daftarAnggota[jumlahAnggota] = new Anggota(nama,id);
			jumlahAnggota++;
			
			//Menampilkan informasi anggota 
			for(int i = 0; i < jumlahAnggota; i++) {
				System.out.println("✅ Pendaftaran berhasil! Selamat datang, " + daftarAnggota[i].getNama() + " (ID: " + daftarAnggota[i].getId() + ")");
			}
			
			System.out.println("\n--------------------------------\n");
			return;
		} 
		else {
			System.out.println("🙏 Maaf Saat ini Keanggotaan Perpustakaan sudah Penuh!");
			System.out.println("\n--------------------------------\n");
			return;
		}
	}
	
	public void loginAnggota() {
		//cek apakah sudah ada anggota di perpustakaan
		if(jumlahAnggota == 0) {
			System.out.println("❌ Belum ada Anggota di Perpustakaan saat ini!");
			System.out.println("\n--------------------------------\n");
			return;
		}
		
		System.out.println("🔑 Masukan ID Anggota Anda : ");
		int inputId = input.nextInt();
		
		for(int i = 0; i < jumlahAnggota ; i++) {
			//Validasi data input nama dengan nama di array daftarAnggota
			if(daftarAnggota[i].getId() == inputId) {
				System.out.println("\n✅ Login berhasil! Selamat datang kembali, " + daftarAnggota[i].getNama());
				System.out.println("\n--------------------------------\n");
				return;
			} 
			else {
				System.out.println("⛔ Tidak ada Anggota dengan id : " + inputId);
				System.out.println("\n--------------------------------\n");
				return;
			}
		}
	}
	
 	public void tambahBuku(Buku buku) {
		
		//perintah tambahkan buku & Cek apakah perpustakaan sudah penuh
		if(jumlahBuku < daftarBuku.length) {
			daftarBuku[jumlahBuku] = buku;
			jumlahBuku++;
		} else {
			System.out.println("Gagal menambahkan Buku, Perpustakaan sudah penuh!");
		}
	}

	public void tampilkanSemuaBuku() {
		
		System.out.println("\n📚 Daftar Buku di Perpustakaan 📚");
		System.out.println("================================\n");

		//cek apakah sudah ada buku di perpustakaan
		if(jumlahBuku == 0) {
			System.out.println("Belum ada Buku di Perpustakaan.");
			System.out.println("\n--------------------------------\n");
			return;
		}
		
		for(int i = 0; i < jumlahBuku; i++) {
			//Tampilkan Buku
			daftarBuku[i].tampilkanInfo();
			System.out.println("\n--------------------------------\n");
		}
	}

	public boolean pencarianBuku(String judul) {
		//cek apakah sudah ada buku di perpustakaan
		if(jumlahBuku == 0) {
			System.out.println("Belum ada Buku di Perpustakaan.");
			System.out.println("\n--------------------------------\n");
			return false;
		}
		
		for(int i = 0; i < jumlahBuku; i++) {
			if(daftarBuku[i].getJudul().equalsIgnoreCase(judul)) {
				System.out.println("\n✅ Buku ditemukan!");
				System.out.println("\n--------------------------------\n");
				daftarBuku[i].tampilkanInfo();
				System.out.println("\n--------------------------------\n");
				return true;
			}
		}
		System.out.println("❌ Buku Tidak ditemukan!");
		return false;
	}
	
	public void peminjamanBuku(String judul) {
	    if (jumlahBuku == 0) {
	        System.out.println("Belum ada Buku di Perpustakaan.");
	        System.out.println("\n--------------------------------\n");
	        return;
	    }

	    boolean ditemukan = false;

	    // Logic Peminjaman Buku
	    for (int i = 0; i < jumlahBuku; i++) {
	        if (daftarBuku[i].getJudul().equalsIgnoreCase(judul)) {
	            ditemukan = true;
	          
	            if (jumlahBukuDipinjam < daftarDipinjam.length) {
	                if (daftarBuku[i] instanceof BukuCetak) {  
	                    BukuCetak bukuCetak = (BukuCetak) daftarBuku[i];

	                    if (bukuCetak.getStok() > 0) {
	                        bukuCetak.setStok(bukuCetak.getStok() - 1);
	                        System.out.println("\n📖 Buku " + bukuCetak.getJudul() + " berhasil dipinjam!");
	                        System.out.println("\n--------------------------------\n");

	                        // Menambahkan Buku ke dalam daftarDipinjam
	                        daftarDipinjam[jumlahBukuDipinjam] = bukuCetak;
	                        jumlahBukuDipinjam++;
	                    } else {
	                        System.out.println("\n📖 Buku " + bukuCetak.getJudul() + " sedang habis!");
	                        System.out.println("\n--------------------------------\n");
	                    }
	                    return;
	                } else if (daftarBuku[i] instanceof BukuDigital) {										// ---> instance of : apabila 
	                    BukuDigital bukuDigital = (BukuDigital) daftarBuku[i];

	                    if (jumlahBukuDipinjam < daftarDipinjam.length) {  // Tambahkan pengecekan kapasitas
	                        System.out.println("\n📱 Buku Digital " + bukuDigital.getJudul() + " berhasil dipinjam!");
	                        System.out.println("\n--------------------------------\n");
	                        daftarDipinjam[jumlahBukuDipinjam] = bukuDigital;
	                        jumlahBukuDipinjam++;
	                    } else {
	                        System.out.println("\n❌ Daftar Peminjaman sudah penuh!");
	                    }
	                    return;
	                }
	            } else {
	                System.out.println("\n❌ Daftar Peminjaman sudah penuh!");
	                return;
	            }
	        }
	    }

	    // Jika setelah loop selesai, tidak ditemukan buku yang cocok
	    if (!ditemukan) {
	        System.out.println("\n❌ Buku tidak ditemukan di Perpustakaan!");
	        System.out.println("\n--------------------------------\n");
	    }
	}

	public void kembalikanBuku(String buku) {
		for(int i = 0; i < jumlahBukuDipinjam ; i ++) {
			if(daftarDipinjam[i] != null && daftarDipinjam[i].getJudul().equalsIgnoreCase(buku)) {
				if(daftarDipinjam[i] instanceof BukuCetak) {					//Untuk mengakses class BukuCetak : Parent class -> Child class
					BukuCetak bukuCetak = (BukuCetak) daftarDipinjam[i];		//Type Casting untuk cek stok buku
					
					//cek stok buku apakah benar buku dipinjam
					if(bukuCetak.getStok() != 10) {
						System.out.println("\n📖 Buku " + bukuCetak.getJudul() + " berhasil dikembalikan!");
						bukuCetak.setStok(bukuCetak.getStok() + 1);
						
						//kurangi daftarDipinjam
						daftarDipinjam[i] = daftarDipinjam[jumlahBukuDipinjam-1];
						daftarDipinjam[jumlahBukuDipinjam - 1]  = null ;
						jumlahBukuDipinjam--;
						
						System.out.println("\n--------------------------------\n");	
						return;
					} 
				}
				else {
					System.out.println("\nBuku " + buku + " Tersedia");
					
					//kurangi daftarDipinjam
					daftarDipinjam[i] = daftarDipinjam[jumlahBukuDipinjam-1];
					daftarDipinjam[jumlahBukuDipinjam - 1]  = null ;
					jumlahBukuDipinjam--;
					
					System.out.println("\n--------------------------------\n");	
					return;
				}
			} else {
				System.out.println("❌ Buku tidak ditemukan dalam daftar peminjaman!");
			}
		}
	}

	public void bukuYangDipinjam() {
		System.out.println("\n📚 Daftar Buku di Perpustakaan 📚");
		System.out.println("================================\n");
		
		if(jumlahBukuDipinjam == 0 ) {
			System.out.println("Tidak ada Buku yang dipinjam saat ini!");
			System.out.println("\n--------------------------------\n");
			return;
		} 
		
		for(int i = 0; i < jumlahBukuDipinjam; i++) {
			if(daftarDipinjam[i] instanceof BukuCetak) {
				BukuCetak bukuCetak = (BukuCetak) daftarDipinjam[i];
				bukuCetak.tampilkanInfo();
			} 
			else if(daftarDipinjam[i] instanceof BukuDigital){
				BukuDigital bukuDigital = (BukuDigital) daftarDipinjam[i];
				bukuDigital.tampilkanInfo();
			}		
			System.out.println("\n--------------------------------\n");
		}
	}
		

}