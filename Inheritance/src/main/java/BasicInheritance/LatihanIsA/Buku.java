package BasicInheritance.LatihanIsA;

public class Buku {
	private String judul;
	private String penulis;
	private int tahunTerbit;

	public Buku(String judul, String penulis, int tahunTerbit) {
		this.judul = judul;
		this.penulis = penulis;
		this.tahunTerbit = tahunTerbit;
	}

	public String getJudul() {
		return judul;
	}

	public String getPenulis() {
		return penulis;
	}

	public int getTahunTerbit() {
		return tahunTerbit;
	}
	
	public void tampilkanInfo() {
	    System.out.printf("%-15s: %s\n", "Judul", judul);
	    System.out.printf("%-15s: %s\n", "Penulis", penulis);
	    System.out.printf("%-15s: %d\n", "Tahun Terbit", tahunTerbit);
	}
	
}
