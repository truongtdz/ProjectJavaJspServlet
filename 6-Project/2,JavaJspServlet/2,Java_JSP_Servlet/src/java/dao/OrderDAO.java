package dao;

import java.sql.*;
import java.util.ArrayList;
import model.Book;
import model.Order;

public class OrderDAO {
    public static boolean InsertOrder(Order order){
        try(Connection con = DBConfig.openConnection()){
            String sql = "INSERT INTO orders(id_user, id_book, bookquantity, totalprice, describes, statusbuy)"
                    + " VALUES (" + order.getIdUser() + ", " + order.getIdBook() + ", " + order.getBookQuantity()
                    + ", " + order.getTotalPrice() + " , '" + order.getDescribes() + "', " + order.getStatusBuy() + ")"; 
	    PreparedStatement pstmt = con.prepareStatement(sql);
	    int row = pstmt.executeUpdate(sql);
            return row >= 1 ? true : false;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return true;
    }
    
    public static ArrayList<Order> orderList(){
        ArrayList<Order> orderList = new ArrayList<>();
        try(Connection con = DBConfig.openConnection()){
            String sql = "Select * from orders"; 
	    PreparedStatement pstmt = con.prepareStatement(sql);
	    ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                Order order = new Order(rs.getInt("id_order"), rs.getInt("bookquantity"), rs.getInt("totalprice")
                                        , rs.getInt("id_user"), rs.getInt("id_book"), rs.getInt("statusbuy"), rs.getString("describes"));
                orderList.add(order);
            }
        }catch(Exception ex){
            ex.printStackTrace();  
        }
        return orderList;
    }
    
}
