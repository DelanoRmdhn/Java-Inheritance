package BasicInheritance.LatihanIsA;

public class BukuCetak extends Buku {
	private int stok;
	private boolean dipinjam;
	
	
	public BukuCetak(String judul, String penulis, int tahunTerbit, int stok) {
		super(judul,penulis,tahunTerbit);
		this.dipinjam = false;
		this.stok = stok;
	}

	public int getStok() {
		return stok;
	}


	public void setStok(int stok) {
		this.stok = stok;
	}
	
	public boolean isDipinjam() {
		return dipinjam;
	}

	public void setDipinjam(boolean dipinjam) {
		this.dipinjam = dipinjam;
	}

	
	@Override
	public void tampilkanInfo() {
		super.tampilkanInfo();
	    System.out.printf("%-15s: %s\n", "Tipe Buku", "Cetak");
	    System.out.printf("%-15s: %d\n", "Stok", stok);
	}
}
