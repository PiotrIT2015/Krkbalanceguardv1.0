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
    MySQLTest database = new MySQLTest();

    /// Funkcja zwracająca treść uchwały
    /** Funkcja wywołuje obiekt klast MySQLTest, pobiera, za pomocą jego funkcji, treść uchwały. */
    public String showResolution()

    {
        String body = null;

        try
        {
            database.databaseConnection=database.getConnection();
            body = database.viewTable();
            System.out.println("I sent resolution.");


        }catch(SQLException e)
        {
            e.printStackTrace();
        }
        return body;
    }
    /// Funkcja zwracająca głsoy uchwały
    /** Funkcja wywołuje obiekt klast MySQLTest, pobiera, za pomocą jego funkcji, ilości głosów dla danej uchwały. */
    public String showVotes()
    {
        String result=null;
        try
        {
            database.databaseConnection=database.getConnection();
            result = database.viewVotes();



        }catch(SQLException e)
        {
            e.printStackTrace();
        }
        return result;
    }
    /// Funkcja głosująca za
    /** Funkcja wywołuje obiekt klast MySQLTest, za pomocą jego funkcji głosuje za uchwałą. */
    public String voteAgree()
    {

        try
        {

            database.updateAgree();
            System.out.println("You voted for resolution");


        }catch(SQLException e)
        {
            e.printStackTrace();
        }
        return "You voted for resolution!";
    }
/// Funkcja głosująca przeciw
    /** Funkcja wywołuje obiekt klast MySQLTest, za pomocą jego funkcji głosuje za uchwałą. */
    public String voteDisagree()
    {

        try
        {

            baza.updateDisagree();
            System.out.println("You voted against resolution.");


        }catch(SQLException e)
        {
            e.printStackTrace();
        }
        return "You voted against resolution!";
    }
    /// Funkcja wstrzymująca od głosu
    /** Funkcja wywołuje obiekt klast MySQLTest, za pomocą jego funkcji wstrzymuje się od głosu. */
    public String voteSuspended()
    {

        try
        {

            database.updateSuspended();
            System.out.println("You suspend from vote");


        }catch(SQLException e)
        {
            e.printStackTrace();
        }
        return "You suspended from vote!";
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

