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

import javax.swing.*;
import java.net.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.xml.namespace.QName;
import org.aarboard.nextcloud.api.utils.WebdavInputStream;
import org.aarboard.nextcloud.api.ServerConfig;
import org.aarboard.nextcloud.api.exception.NextcloudApiException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.http.client.utils.URIBuilder;

import com.github.sardine.Sardine;
import com.github.sardine.SardineFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

/**
 *
 * @author Piotr
 */
//@SpringBootApplication
@Service
public class healthService implements Item{
    private static final Logger LOG = LoggerFactory.getLogger(healthService.class);

    private final ServerConfig _serverConfig;

    public healthService(ServerConfig serverConfig) {
        _serverConfig = serverConfig;
    }

    String url_name, path, nameoffile;
    private static final String FILE_SEPARATOR = "/";
    windowService window = new windowService();
    private static final String ADMINPP_BASE_PATH = "remote.php/adminpp/";

    protected String buildWebdavPath(String remotePath)
    {
        URIBuilder uB= new URIBuilder()
                .setScheme(_serverConfig.isUseHTTPS() ? "https" : "http")
                .setHost(_serverConfig.getServerName())
                .setPort(_serverConfig.getPort())
                .setPath(
                        _serverConfig.getSubpathPrefix() == null ?
                                ADMINPP_BASE_PATH + remotePath :
                                _serverConfig.getSubpathPrefix()+ "/" + ADMINPP_BASE_PATH + remotePath
                );
        return uB.toString();
    }

    protected Sardine buildAuthSardine()
    {
        Sardine sardine = SardineFactory.begin();
        sardine.setCredentials(_serverConfig.getUserName(), _serverConfig.getPassword());
        sardine.enablePreemptiveAuthentication(_serverConfig.getServerName());

        return sardine;
    }

    public void uploadFile(File localSource, String remotePath) {
        String path = buildWebdavPath(remotePath);
        Sardine sardine = buildAuthSardine();

        try
        {
            sardine.put(path, localSource, null, true);
        } catch (IOException e)
        {
            throw new NextcloudApiException(e);
        }
        finally
        {
            try
            {
                sardine.shutdown();
            }
            catch(Exception ex2)
            {
                LOG.warn("Error in sardine shutdown", ex2);
            }
        }
    }

    public void uploadFile(InputStream inputStream, String remotePath) {
        uploadFile(inputStream, remotePath, true);
    }

    public void uploadFile(InputStream inputStream, String remotePath, boolean continueHeader) {
        String path = buildWebdavPath(remotePath);

        Sardine sardine = buildAuthSardine();

        try
        {
            sardine.put(path, inputStream, null, continueHeader);
        } catch (IOException e)
        {
            throw new NextcloudApiException(e);
        }
        finally
        {
            try
            {
                sardine.shutdown();
            }
            catch(Exception ex2)
            {
                LOG.warn("Error in sardine shutdown", ex2);
            }
        }
    }


    private long convertStringToLong(String number)
    {
        if (number == null || number.equals(""))
        {
            return 0;
        }
        else
        {
            return Long.parseLong(number);
        }
    }

    @Bean
    public String getName(){

        String csvFile = ".//data";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        ArrayList<String> music = new ArrayList<String>();
        ArrayList<String> gallery = new ArrayList<String>();

        try {
            br=new BufferedReader(new FileReader(window.initUI()));
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

        uploadFile(file, "https://cloud.pp/images");

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

