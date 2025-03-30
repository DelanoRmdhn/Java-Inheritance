package BasicInheritance.LatihanIsA;

public class BukuDigital extends Buku {
	private double ukuranFile;
	public BukuDigital(String judul, String penulis, int tahunTerbit,double ukuranFile) {
		super(judul,penulis,tahunTerbit);
		this.ukuranFile = ukuranFile;
	}
	
	public double getUkuranFile() {
		return ukuranFile;
	}
	public void setUkuranFile(double ukuranFile) {
		this.ukuranFile = ukuranFile;
	}
	
	@Override
	public void tampilkanInfo() {
		super.tampilkanInfo();
	    System.out.printf("%-15s: %s\n", "Tipe Buku", "Digital");
	    System.out.printf("%-15s: %.2f MB\n", "Ukuran File", ukuranFile);

	}
	
}
