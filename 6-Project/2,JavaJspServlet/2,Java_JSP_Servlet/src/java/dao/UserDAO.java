
package dao;

import java.sql.*;
import model.User;


public class UserDAO {
    
    public static boolean CheckLogin(String userName, String passWord) {
        
        try(Connection con = DBConfig.openConnection()){
            String sql = "Select * from users where username = '" + userName + "' and password = '" + passWord + "'";
	    PreparedStatement pstmt = con.prepareStatement(sql);
	    ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                return true;
            }
        }catch(Exception ex){
            ex.printStackTrace();  
        }
        return false;
    }
    
    public static User getUser(String userName, String passWord){
        User user = null;
        try(Connection con = DBConfig.openConnection()){
            String sql = "Select * from users where username = '" + userName + "' and password = '" + passWord + "'";
	    PreparedStatement pstmt = con.prepareStatement(sql);
	    ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                user = new User(rs.getInt("id_user"), rs.getString("username"), rs.getString("password"),
                                rs.getString("firstname"), rs.getString("lastname"),
                                rs.getString("address"), rs.getString("phone"));
            }
        }catch(Exception ex){
            ex.printStackTrace();  
        }
        return user;
    }
    
    public static boolean isExistUserName(String userName) {
        
        try(Connection con = DBConfig.openConnection()){
            String sql = "Select * from users where username = '" + userName + "'";
	    PreparedStatement pstmt = con.prepareStatement(sql);
	    ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                return true;
            }
        }catch(Exception ex){
            ex.printStackTrace();  
        }
        return false;
    }
    
    public static boolean InsertUser(User user){
        try(Connection con = DBConfig.openConnection()){
            String sql = "INSERT INTO users(username, password) VALUES ('" + user.getUserName() + "' , '" + user.getPassWord() + "')";
	    PreparedStatement pstmt = con.prepareStatement(sql);
	    int row = pstmt.executeUpdate(sql);
            return row >= 1 ? true : false;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return true;
    }
    
    public static void UpdateUser(String userName, String firstName, String lastName){
        try(Connection con = DBConfig.openConnection()){
            String sql = "UPDATE users SET firstname = '" + firstName + "' , lastname = '" + lastName + "' WHERE username = '" + userName + "'";
	    PreparedStatement pstmt = con.prepareStatement(sql);
	    pstmt.executeUpdate(sql);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
