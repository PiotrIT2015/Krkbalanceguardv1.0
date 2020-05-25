
import java.rmi.registry.LocateRegistry;
import java.rmi.server.*;
import java.rmi.registry.Registry;

public class CaloClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		try{
		    String name = "127.0.0.1";
			
			Registry myReg = LocateRegistry.getRegistry(name);
			
			CalImplementation c = (CalImplementation)myReg.lookup("CalImplementation");
			System.out.println("1+1=" + c.add(1,1));
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
	}

}

