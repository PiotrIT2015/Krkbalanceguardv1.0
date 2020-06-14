package engine.pp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/// Klasa impementująca funkcjonalność bazy danych MySQL
/** W klasie tej znajdują się implementacje funkcji
 * bazy danych (pobieranie wartości, aktualizowanie głosów) */

public class MySQLTest {

    /// Funkcja połączenia z bazą danych
    /** Funkcja ta zapewnia łączność pomiędzy serwerem a bazą danych MySQL. Podawane są tutaj dane dostępowe do bazy oraz jej adres. */

    public Connection getConnection() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:mysql://" + serverName + ":" + portNumber + "/" + databaseName +
                "?useUnicode=true" +
                "&characterEncoding=utf-8" +
                "&user=" + userName +
                "&password=" + password);
        System.out.println("Połączono do bazy " + databaseName);
        return conn;
    }

    Connection databaseConnection;
    String userName = "root",
            password = "pass",
            serverName = "localhost",
            portNumber = "3306",
            databaseName = "srir";


/// Funkcja wyświetlania treści uchwały
    /**Funkcja ta odpowiada za pobranie treści uchwały z bazy danych i zwrócenie jej w postaci Stringa */
    public String viewTable() throws SQLException {
        String query = "select tresc from sr where id=1";
        String tresc = null;

        Statement stmt = null;
        try {
            stmt = (Statement) databaseConnection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            // Dopóki zbiór wyników posiada jakieś dane to wypisuj
            while(rs.next())
                tresc = rs.getString("tresc");



        } catch (SQLException e)
        {
            e.printStackTrace();
        } finally {
            // Zamknij obiekt Statement, aby natychmiast zwolnić jego pamięć
            if (stmt != null) { stmt.close(); }
        }
        return tresc;
    }
/// Funkcja wyświetlania liczby głosów
    /**Funkcja ta odpowiada za pobranie ilości poszczególnych głosów z bazy danych i zwrócenie ich w postaci Stringa */
    public String viewVotes() throws SQLException {
        String query = "select za, przeciw, wstrz from sr where id=1";
        int za=0;
        int przeciw=0;
        String wstrz =null;

        Statement stmt = null;
        try {
            stmt = (Statement) databaseConnection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            // Dopóki zbiór wyników posiada jakieś dane to wypisuj
            while(rs.next()){
                za =rs.getInt("za");
                przeciw =rs.getInt("przeciw");
                wstrz =rs.getString("wstrz");
            }
            System.out.println(za +"   "+ przeciw+ "   " + wstrz);



        } catch (SQLException e)
        {
            e.printStackTrace();
        } finally {
            // Zamknij obiekt Statement, aby natychmiast zwolnić jego pamięć
            if (stmt != null) { stmt.close(); }
        }
        return ("WYNIKI: Glosow za: " +za + " Glosow przeciw: " + przeciw + " Wstrzymalo sie od glosow: " + wstrz);
    }

    /// Funkcja głosowania za uchwałą
    /**Funkcja ta odpowiada za zaktualizowanie komórki "za" w bazie danych (odnoszące się do uchwały, nad którą trwa głosowanie) */
    public void updateZa() throws SQLException {
        String query = "UPDATE sr SET za=za+1";
        Statement stmt = null;
        try {
            stmt = (Statement) databaseConnection.createStatement();
            int rows = stmt.executeUpdate(query);

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            // Zamknij obiekt Statement, aby natychmiast zwolnić jego pamięć
            if (stmt != null) { stmt.close(); }
        }
    }
/// Funkcja wstrzymania się od głosu
    /**Funkcja ta odpowiada za zaktualizowanie komórki "Brak zdania" w bazie danych (odnoszące się do uchwały, nad którą trwa głosowanie) */
    public void updateBz() throws SQLException {
        String query = "UPDATE sr SET wstrz=wstrz+1";
        Statement stmt = null;
        try {
            stmt = (Statement) databaseConnection.createStatement();
            int rows = stmt.executeUpdate(query);

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            // Zamknij obiekt Statement, aby natychmiast zwolnić jego pamięć
            if (stmt != null) { stmt.close(); }
        }
    }
/// Funkcja głosowania przeciw uchwale
    /**Funkcja ta odpowiada za zaktualizowanie komórki "przeciw" w bazie danych (odnoszące się do uchwały, nad którą trwa głosowanie) */
    public void updatePrzeciw() throws SQLException {
        String query = "UPDATE sr SET przeciw=przeciw+1";
        Statement stmt = null;
        try {
            stmt = (Statement) databaseConnection.createStatement();
            int rows = stmt.executeUpdate(query);

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            // Zamknij obiekt Statement, aby natychmiast zwolnić jego pamięć
            if (stmt != null) { stmt.close(); }
        }
    }

}

