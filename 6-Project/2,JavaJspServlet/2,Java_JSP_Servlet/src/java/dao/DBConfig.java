
package dao;

import java.sql.*; 

public class DBConfig {
    
    public static final String Driver = "com.mysql.cj.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/shopbook?useUnicode=true&characterEncoding=UTF-8";
    public static final String UserName = "root";
    public static final String Password = "123456";

    public static Connection openConnection(){
        Connection conn = null;
        try{
            Class.forName(DBConfig.Driver);
            conn = DriverManager.getConnection(DBConfig.URL, DBConfig.UserName, DBConfig.Password);
        } catch(Exception ex){
            ex.printStackTrace();
        }
        return conn;
    }
}
