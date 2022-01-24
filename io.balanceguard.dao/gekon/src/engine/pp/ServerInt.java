package engine.pp;

import java.rmi.Remote;
import java.rmi.RemoteException;
/// Interfejs udostepniany klientowi
/**Interfejs zawierający spis funkcji, które klient może zdalnie wywołać na serwerze. Wszystkie te funkcje zaimplementowane są w klasie "Server". */
public interface ServerInt extends Remote {
    String showResolution() throws RemoteException;
    String voteAgree() throws RemoteException;
    String voteDisagree() throws RemoteException;
    String voteSuspended() throws RemoteException;
    String showVotes() throws RemoteException;


}
