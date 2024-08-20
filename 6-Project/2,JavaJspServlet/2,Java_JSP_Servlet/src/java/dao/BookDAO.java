package dao;

import java.sql.*;
import java.util.ArrayList;
import model.Book;

public class BookDAO { 
    public static ArrayList<Book> bookList(){
        ArrayList<Book> books = new ArrayList<>();
        try(Connection con = DBConfig.openConnection()){
            String sql = "Select * From book";
	    PreparedStatement pstmt = con.prepareStatement(sql);
	    ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                Book book = new Book(rs.getInt("id_book"), rs.getInt("price"), rs.getInt("pagenumber"), rs.getInt("quantity"),
                                rs.getString("name"), rs.getString("subject"), rs.getString("class"));
                books.add(book);
            }
        }catch(Exception ex){
            ex.printStackTrace();  
        }
        return books;
    }
    
    public static ArrayList<Book> searchBook(String where){
        ArrayList<Book> books = new ArrayList<>();
        try(Connection con = DBConfig.openConnection()){
            StringBuilder sql = new StringBuilder("Select * From book");
            sql.append(where);
	    PreparedStatement pstmt = con.prepareStatement(sql.toString());
	    ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                Book book = new Book(rs.getInt("id_book"), rs.getInt("price"), rs.getInt("pagenumber"), rs.getInt("quantity"),
                                rs.getString("name"), rs.getString("subject"), rs.getString("class"));
                books.add(book);
            }
        }catch(Exception ex){
            ex.printStackTrace();  
        }
        return books;
    }
    
    public static Book searchInforBook(String id_book){
        Book book = new Book();
        try(Connection con = DBConfig.openConnection()){
            String sql = "Select * From book where id_book = " + id_book;
	    PreparedStatement pstmt = con.prepareStatement(sql);
	    ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                book = new Book(rs.getInt("id_book"), rs.getInt("price"), rs.getInt("pagenumber"), rs.getInt("quantity"),
                                rs.getString("name"), rs.getString("subject"), rs.getString("class"));
            }
        }catch(Exception ex){
            ex.printStackTrace();  
        }
        return book;
    }
}
