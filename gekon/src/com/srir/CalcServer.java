import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;



public class CalcServer implements Remote {

	public CalcServer(){
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			//System.setSecurityManager(new RMISecurityManager());	
			CalcServer obj = new CalcServer();
			CalculatorInterface stub = (CalculatorInterface) UnicastRemoteObject.exportObject(obj, 0);
			//System.out.println(InetAddress.getLocalHost().getHostAddress());
			
			
			Registry registry = LocateRegistry.createRegistry(1099);
			registry.bind("CalculatorInterface", stub);
			System.out.println("Serwer gotowy");
		}catch (Exception e)
		{
			System.err.println("Wyjatek przy odpalaniu serwera: " + e.toString());
			e.printStackTrace();
		}
	}
}

