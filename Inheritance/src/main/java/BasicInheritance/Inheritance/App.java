package BasicInheritance.Inheritance;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Kendaraan k = new Kendaraan();
    	Mobil agya = new Mobil();
    	Sepeda ontel= new Sepeda();
    	
    	k.bergerak();
    	k.entotDia();
    	agya.bergerak();
    	ontel.bergerak();
    	
    }
}
