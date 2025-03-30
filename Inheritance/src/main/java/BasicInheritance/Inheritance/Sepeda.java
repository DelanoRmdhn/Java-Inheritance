package BasicInheritance.Inheritance;

public class Sepeda extends Kendaraan{
	
	
	@Override
	public void bergerak() {
		super.bergerak();
		System.out.println( super.jenis + " dikayuh oleh pengendara...");
	}
	
	
}
