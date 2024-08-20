
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Cart;

public class CartDAO {
    public static ArrayList<Cart> ListCart(String id_user){
        ArrayList<Cart> carts = new ArrayList<>();
        try(Connection con = DBConfig.openConnection()){
            String sql = " Select o.totalprice, b.name, b.id_book FROM orders o "
                         + " join book b on o.id_book = b.id_book "
                         + " where id_user = " + id_user + " and statusbuy = 0"; 
	    PreparedStatement pstmt = con.prepareStatement(sql);
	    ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                Cart cart = new Cart( rs.getInt("totalprice"),rs.getInt("id_book"), rs.getString("name"));
                carts.add(cart);
            }
        }catch(Exception ex){
            ex.printStackTrace();  
        }
        return carts;
    }
    
    public static ArrayList<Cart> ListBuy(String id_user){
        ArrayList<Cart> carts = new ArrayList<>();
        try(Connection con = DBConfig.openConnection()){
            String sql = " Select o.totalprice, b.name, b.id_book FROM orders o "
                         + " join book b on o.id_book = b.id_book "
                         + " where id_user = " + id_user + " and statusbuy = 1"; 
	    PreparedStatement pstmt = con.prepareStatement(sql);
	    ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                Cart cart = new Cart( rs.getInt("totalprice"),rs.getInt("id_book"), rs.getString("name"));
                carts.add(cart);
            }
        }catch(Exception ex){
            ex.printStackTrace();  
        }
        return carts;
    }
    
    public static void SelectBuy(String where){
        try(Connection con = DBConfig.openConnection()){
            StringBuilder sql = new StringBuilder("Update orders Set statusbuy = 1 ");
            sql.append(where);
	    PreparedStatement pstmt = con.prepareStatement(sql.toString());
	    pstmt.executeUpdate();
        }catch(Exception ex){
            ex.printStackTrace();  
        }
    }
    
    public static void DeleteCart(String where){
        try(Connection con = DBConfig.openConnection()){
            StringBuilder sql = new StringBuilder("Delete from orders ");
            sql.append(where);
	    PreparedStatement pstmt = con.prepareStatement(sql.toString());
	    pstmt.executeUpdate();
        }catch(Exception ex){
            ex.printStackTrace();  
        }
    }
}
