package engine.pp.services;

import engine.pp.services.windowService;

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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
/**
 *
 * @author Piotr
 */
@Service
public class shoppingService implements Item{

    private static final String FILE_SEPARATOR = "/";
    String name, path, nameoffile;
    windowService window=new windowService();
    ArrayList<Integer> cash1 = new ArrayList<Integer>();
    ArrayList<Integer> cash2 = new ArrayList<Integer>();
    ArrayList<Integer> cash3 = new ArrayList<Integer>();
    ArrayList<Integer> cash4 = new ArrayList<Integer>();
    /*@Autowired
    public shoppingService(String path){
        this.path = path.startsWith(FILE_SEPARATOR) ? path : FILE_SEPARATOR + path;
        String[] dirs = path.split(FILE_SEPARATOR);
        this.name = dirs[dirs.length - 1];
        initUI();
    }*/

    @Bean
    public String getName(){
        String csvFile = "./data/shopping-list.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        try {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                // use comma as separator
                String[] money = line.split(cvsSplitBy);
                System.out.println(" [id= " + money[0] + " , type=" + money[1] + " , price=" + money[2] + " , commission=" + money[3] + " , currency=" + money[4] + "is paid=" + money[5] + "]");
                countchargeOperation(money,2);
                countchargeOperation(money,3);
                if(money[1].equals("trip") && money[4].equals("EUR") && money[5].equals(false))
                {
                    cash3.add(Integer.parseInt(countChargedValue(money,2)));
                }else if(money[1].equals("ticket") && money[4].equals("EUR") && money[5].equals(false))
                {
                    cash3.add(Integer.parseInt(countChargedValue(money,2)));
                }else if(money[1].equals("transfer") && money[4].equals("EUR") && money[5].equals(false))
                {
                    cash3.add(Integer.parseInt(countChargedValue(money,2)));
                }else if(money[1].equals("trip") && money[4].equals("PLN") && money[5].equals(false))
                {
                    cash3.add(Integer.parseInt(countChargedValue(money,2)));
                }else if(money[1].equals("ticket") && money[4].equals("PLN") && money[5].equals(false))
                {
                    cash3.add(Integer.parseInt(countChargedValue(money,2)));

                }else if(money[1].equals("transfer") && money[4].equals("PLN") && money[5].equals(false))
                {
                    cash3.add(Integer.parseInt(countChargedValue(money,2)));
                }
                Iterator itr1 = cash1.iterator();
                Iterator itr2 = cash2.iterator();
                Iterator itr3 = cash3.iterator();
                while(itr1.hasNext()) {
                    Object price = itr2.next();
                    int prices = (int)price;
                    Object comission = itr2.next();
                    int comissions = (int)comission;
                    Object chargevalue = itr2.next();
                    int chargevalues = (int)chargevalue;
                    int settlmentvalue = prices - comissions - chargevalues;
                    System.out.println(prices+comissions+chargevalues+settlmentvalue);
                    String name=price.toString()+"-"+comission.toString()+"-"+chargevalue.toString();
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

        Upload(name);

        return name;
    }

    public void Upload(String charge_value) {
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
            String insertSql = "INSERT INTO db (sounds_url) VALUES ('"+charge_value+"')";
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

    String countChargedValue(String money[],int p){
        String chargedValue=null;
        for(int i=0;i<=money[p].length()-1;i++) {
            String price[] = money[i].split(",");
            chargedValue = price[i] +","+ price[i + 1];
        }
        return chargedValue;
    }
    public String getPath() {
        return path;
    }
    public String getNameOfFile() {
        return nameoffile;
    }
    void countchargeOperation(String[] money, int k){
        if(money[1].equals("trip") && money[4].equals("EUR"))
        {
            cash2.add(Integer.parseInt(countChargedValue(money,k)));
        }else if(money[1].equals("ticket") && money[4].equals("EUR"))
        {
            cash2.add(Integer.parseInt(countChargedValue(money,k)));
        }else if(money[1].equals("transfer") && money[4].equals("EUR"))
        {
            cash2.add(Integer.parseInt(countChargedValue(money,k)));
        }else if(money[1].equals("trip") && money[4].equals("PLN"))
        {
            cash2.add(Integer.parseInt(countChargedValue(money,k)));
        }else if(money[1].equals("ticket") && money[4].equals("PLN"))
        {
            cash2.add(Integer.parseInt(countChargedValue(money,k)));
        }else if(money[1].equals("transfer") && money[4].equals("PLN"))
        {
            cash2.add(Integer.parseInt(countChargedValue(money,k)));
        }
    }
}


