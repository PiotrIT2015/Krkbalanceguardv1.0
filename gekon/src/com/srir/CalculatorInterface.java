
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CalculatorInterface extends Remote{

	public int add(int a1, int b1) throws RemoteException;
	
	public int substract(int a1, int b1) throws RemoteException;
	
	public int multiply(int a1, int b1) throws RemoteException;
	
	public int divide(int a1, int b1) throws RemoteException;
	
}
