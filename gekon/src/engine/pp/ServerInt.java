package engine.pp;

import java.rmi.Remote;
import java.rmi.RemoteException;
/// Interfejs udostepniany klientowi
/**Interfejs zawierający spis funkcji, które klient może zdalnie wywołać na serwerze. Wszystkie te funkcje zaimplementowane są w klasie "Server". */
public interface ServerInt extends Remote {
    String pokazUchwale() throws RemoteException;
    String glosZa() throws RemoteException;
    String glosPrzeciw() throws RemoteException;
    String glosBz() throws RemoteException;
    String pokazGlosy() throws RemoteException;


}
