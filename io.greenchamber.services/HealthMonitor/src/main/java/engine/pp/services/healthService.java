package engine.pp.services;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;

import java.io.File;
import org.aarboard.nextcloud.api.ServerConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

/**
 *
 * @author Piotr
 */
//@SpringBootApplication
@Service
public class healthService implements Item {

    String url_name, path, nameoffile;
    private static final String FILE_SEPARATOR = "/";
    windowService window = new windowService();
    ServerConfig serverconfig=new ServerConfig("cloudpp.com",true,22,"root","12345");
    nextcloudServices cloud = new nextcloudServices(serverconfig);

    @Bean
    public String getName(){

        String csvFile = "./data/health-list.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        ArrayList<String> music = new ArrayList<String>();
        ArrayList<String> gallery = new ArrayList<String>();

        try {
            br=new BufferedReader(new FileReader(csvFile));
            while ((line=br.readLine()) != null) {
                // use comma as separator
                String[] soundtracks=line.split(cvsSplitBy);
                System.out.println("[music= " + soundtracks[0] + "]");
                music.add(relaxingSound(soundtracks,0));
                Iterator itr1 = music.iterator();
                while(itr1.hasNext()) {
                    Object musiclist = itr1.next();
                    int musiclists = (int)musiclist;
                    url_name=musiclist.toString();
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

        Upload(url_name);

        File file = new File(window.initUI());

        cloud.uploadFile(file, "https://cloudpp.com/images");

        return "Data is uploaded";
    }

    public void Upload(String urlname) {
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
            String insertSql = "INSERT INTO db (sounds_url) VALUES ('" + urlname + "')";
            prepsInsertProduct = connection.prepareStatement(
                    insertSql,
                    Statement.RETURN_GENERATED_KEYS);
            prepsInsertProduct.execute();
            // Retrieve the generated key from the insert.
            resultSet = prepsInsertProduct.getGeneratedKeys();
            // Print the ID of the inserted row.
            while(resultSet.next()){
                System.out.println("Generated: " + resultSet.getString(1));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            // Close the connections after the data has been handled.
            if(prepsInsertProduct!=null)try{
                prepsInsertProduct.close();
            }catch(Exception e){
            }
            if(resultSet!=null) try{
                resultSet.close();
            }catch(Exception e){
            }
            if(statement != null) try{
                statement.close();
            }catch(Exception e){
            }
            if(connection != null) try{
                connection.close();
            }catch(Exception e){
            }
        }
    }

    public String relaxingSound(String soundtracks[],int p){
        String soundtracklist=null;
        for(int i=0;i<=soundtracks[p].length()-1;i++) {
            String sountracks2[] = soundtracks[i].split(",");
            soundtracklist = sountracks2[i] + soundtracks[i+1];
        }
        return soundtracklist;
    }

    public String getPath() {
        return path;
    }
}

