
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CalImplementation extends UnicastRemoteObject implements CalculatorInterface{

	public CalImplementation() throws RemoteException{
		
	}
	
	@Override
	public int add(int a1, int b1) throws RemoteException {
		// TODO Auto-generated method stub
		return a1 + b1;
	}

	@Override
	public int substract(int a1, int b1) throws RemoteException {
		// TODO Auto-generated method stub
		return a1 - b1;
	}

	@Override
	public int multiply(int a1, int b1) throws RemoteException {
		// TODO Auto-generated method stub
		return a1 * b1;
	}

	@Override
	public int divide(int a1, int b1) throws RemoteException {
		// TODO Auto-generated method stub
		return a1 / b1;
	}

}