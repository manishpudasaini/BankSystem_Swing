package BankManagementSystem.LoginPage;

import java.sql.*;

public class DbConnection {
    public Connection c;
    public Statement s;
    public DbConnection(){
        try {

            c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","Eziomanish@1");
            s= c.createStatement();



        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
