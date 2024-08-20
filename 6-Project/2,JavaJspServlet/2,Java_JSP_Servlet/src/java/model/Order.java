
package model;

public class Order {
    private int id, bookQuantity, totalPrice, idUser, idBook, statusBuy;
    private String describes;

    public Order() {
    }

    public Order(int id, int bookQuantity, int totalPrice, int idUser, int idBook, int statusBuy, String describes) {
        this.id = id;
        this.bookQuantity = bookQuantity;
        this.totalPrice = totalPrice;
        this.idUser = idUser;
        this.idBook = idBook;
        this.statusBuy = statusBuy;
        this.describes = describes;
    }

    public String getDescribes() {
        return describes;
    }

    public void setDescribes(String describes) {
        this.describes = describes;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBookQuantity() {
        return bookQuantity;
    }

    public void setBookQuantity(int bookQuantity) {
        this.bookQuantity = bookQuantity;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdBook() {
        return idBook;
    }

    public void setIdBook(int idBook) {
        this.idBook = idBook;
    }

    public int getStatusBuy() {
        return statusBuy;
    }

    public void setStatusBuy(int statusBuy) {
        this.statusBuy = statusBuy;
    }
    
    
}
