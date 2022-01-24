package engine.pp.services;

import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;


/**
 *
 * @author Piotr
 */
public class voterService extends JFrame implements Item{

    private static final String FILE_SEPARATOR = "/";
    String item, path, nameoffile;
    windowService window=new windowService();
   /* public voterService(String path){
        this.path = path.startsWith(FILE_SEPARATOR) ? path : FILE_SEPARATOR + path;
        String[] dirs = path.split(FILE_SEPARATOR);
        this.item = dirs[dirs.length - 1];
        initUI();
    }*/

    @Bean
    public String getItem(){
        String csvFile = "./data/resolution-list.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        ArrayList<String> resolutions = new ArrayList<String>();
        try {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                // use comma as separator
                String[] law = line.split(cvsSplitBy);
                System.out.println(" [law= " + law[0] + "]");
                for(int i=0;i<=law.length-1;i++)
                {
                    String resolution[] = law[2].split(cvsSplitBy);
                    String resolutionslist = resolution[i] + resolution[i+1];
                    resolutions.add(resolutionslist);
                }
                Iterator itr1 = resolutions.iterator();
                while(itr1.hasNext()) {
                    Object resolutionslist = itr1.next();
                    int resolutionslists = (int)resolutionslist;
                    item=resolutionslist.toString();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        Upload(item);

        return "Data is uploaded";
    }

    public void Upload(String item) {
        String connectionString =
                "jdbc:sqlserver://sqlserverapp.database.windows.net:1433;"
                        + "database=database1;"
                        + "user=Gekon@sqlserverapp.database.windows.net;"
                        + "password=pass;"
                        + "encrypt=true;"
                        + "trustServerCertificate=false;"
                        + "hostNameInCertificate=*.database.windows.net;"
                        + "loginTimeout=30;";

        // Declare the JDBC objects.
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        PreparedStatement prepsInsertProduct = null;
        try {
            connection = DriverManager.getConnection(connectionString);
            // Create and execute an INSERT SQL prepared statement.
            String insertSql = "INSERT INTO db (sounds_url) VALUES ('"+item+"')";
            prepsInsertProduct = connection.prepareStatement(
                    insertSql,
                    Statement.RETURN_GENERATED_KEYS);
            prepsInsertProduct.execute();
            // Retrieve the generated key from the insert.
            resultSet = prepsInsertProduct.getGeneratedKeys();
            // Print the ID of the inserted row.
            while (resultSet.next()) {
                System.out.println("Generated: " + resultSet.getString(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the connections after the data has been handled.
            if (prepsInsertProduct != null) try {
                prepsInsertProduct.close();
            } catch (Exception e) {
            }
            if (resultSet != null) try {
                resultSet.close();
            } catch (Exception e) {
            }
            if (statement != null) try {
                statement.close();
            } catch (Exception e) {
            }
            if (connection != null) try {
                connection.close();
            } catch (Exception e) {
            }
        }

    }

    public String getPath() {
        return path;
    }

    public String getNameOfFile() {
        return nameoffile;
    }



}



