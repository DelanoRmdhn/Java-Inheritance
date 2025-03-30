package BasicInheritance.LatihanIsA;

public class Anggota {
	private String nama;
	private int id, maxBuku;
	private Buku[] bukuDipinjam;
	
	public Anggota(String nama, int id) {
		this.nama = nama;
		this.id = id;
		this.maxBuku = 0;
		this.bukuDipinjam = new Buku[3];
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}
	
	public void tampilkanInfo() {

	}
}
