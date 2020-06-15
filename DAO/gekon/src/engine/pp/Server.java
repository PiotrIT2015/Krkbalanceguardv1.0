package engine.pp;

import java.net.InetAddress;
import java.rmi.RMISecurityManager;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;

/// Klasa impementująca funkcjonalność serwea
/** W klasie tej znajdują się implementacje funkcji
 * interfesju serwera, które są udostępniane dla klienta oraz ciało (main) serwera aplikacji */

public class Server implements ServerInt {
    public Server()
    {}
    MySQLTest baza = new MySQLTest();

    /// Funkcja zwracająca treść uchwały
    /** Funkcja wywołuje obiekt klast MySQLTest, pobiera, za pomocą jego funkcji, treść uchwały. */
    public String pokazUchwale()

    {
        String body = null;

        try
        {
            baza.databaseConnection=baza.getConnection();
            body = baza.viewTable();
            System.out.println("Wyslalem tresc uchwaly.");


        }catch(SQLException e)
        {
            e.printStackTrace();
        }
        return body;
    }
    /// Funkcja zwracająca głsoy uchwały
    /** Funkcja wywołuje obiekt klast MySQLTest, pobiera, za pomocą jego funkcji, ilości głosów dla danej uchwały. */
    public String pokazGlosy()
    {
        String wynik=null;
        try
        {
            baza.databaseConnection=baza.getConnection();
            wynik = baza.viewVotes();



        }catch(SQLException e)
        {
            e.printStackTrace();
        }
        return wynik;
    }
    /// Funkcja głosująca za
    /** Funkcja wywołuje obiekt klast MySQLTest, za pomocą jego funkcji głosuje za uchwałą. */
    public String glosZa()
    {

        try
        {

            baza.updateZa();
            System.out.println("Zaglosowano za uchwala");


        }catch(SQLException e)
        {
            e.printStackTrace();
        }
        return "Zaglosowales za uchwala!";
    }
/// Funkcja głosująca przeciw
    /** Funkcja wywołuje obiekt klast MySQLTest, za pomocą jego funkcji głosuje za uchwałą. */
    public String glosPrzeciw()
    {

        try
        {

            baza.updatePrzeciw();
            System.out.println("Zaglosowano przeciw uchwale");


        }catch(SQLException e)
        {
            e.printStackTrace();
        }
        return "Zaglosowales przeciw uchwale!";
    }
    /// Funkcja wstrzymująca od głosu
    /** Funkcja wywołuje obiekt klast MySQLTest, za pomocą jego funkcji wstrzymuje się od głosu. */
    public String glosBz()
    {

        try
        {

            baza.updateBz();
            System.out.println("Wstrzymano się od głosu");


        }catch(SQLException e)
        {
            e.printStackTrace();
        }
        return "Wstrzymales sie od glosu!";
    }
    /// Main serwera
    /**zawarta jest tutaj funkjonalność serwera, obsługa RMI (tworzenie rejestru, bindowanie i udostępnianie) */
    public static void main(String[] args) {


        try
        {
            System.setSecurityManager(new RMISecurityManager());
            Server obj = new Server();
            ServerInt stub = (ServerInt) UnicastRemoteObject.exportObject(obj, 0);
            System.out.println(InetAddress.getLocalHost().getHostAddress());


            Registry registry = LocateRegistry.createRegistry(1099);
            registry.bind("ServerInt", stub);
            System.out.println("Serwer gotowy");
        }catch (Exception e)
        {
            System.err.println("Wyjatek przy odpalaniu serwera: " + e.toString());
            e.printStackTrace();
        }

    }

}

