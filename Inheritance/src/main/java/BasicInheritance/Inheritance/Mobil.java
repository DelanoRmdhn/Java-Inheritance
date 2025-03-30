package BasicInheritance.Inheritance;

public class Mobil extends Kendaraan{
	String jenis = "Mobil";
	
	@Override
	public void bergerak(){
		System.out.println(jenis + " melaju di jalan raya...");
	}
	
	
}
