package com.example.service;

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
public class HealthService {

    HealthService(){

    }


    public String odczyt(){



        String csvFile = ".//data";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        ArrayList<String> music = new ArrayList<String>();
        ArrayList<String> gallery = new ArrayList<String>();

        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] relax = line.split(cvsSplitBy);

                System.out.println(" [music= " + relax[0] + " , gallery=" + relax[1] + "]");

                for(int i=0;i<=relax.length-1;i++)
                {
                    String Music[] = relax[2].split(cvsSplitBy);
                    String Musiclist = Music[i] + Music[i+1];
                    music.add(Musiclist);
                }

                for(int i=0;i<=relax.length-1;i++)
                {
                    String Gallery[] = relax[2].split(cvsSplitBy);
                    String Gallerylist = Gallery[i] + Gallery[i+1];
                    gallery.add(Gallerylist);
                }

                Iterator itr1 = music.iterator();
                Iterator itr2 = gallery.iterator();

                while(itr1.hasNext()) {
                    Object musiclist = itr2.next();
                    int musiclists = (int)musiclist;
                    Object gallerylist = itr2.next();
                    int gallerylists = (int)gallerylist;
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

        return "data";
    }

    public String InsertQuery() {
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
            String insertSql = odczyt();

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

        return "database";
    }



}

