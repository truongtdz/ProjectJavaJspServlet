package model;

public class Cart {
    
    private int totalPrice, idBook;
    private String nameBook;

    public Cart() {
    }

    public Cart(int totalPrice, int idBook, String nameBook) {
        this.idBook = idBook;
        this.totalPrice = totalPrice;
        this.nameBook = nameBook;
    }

    public int getIdBook() {
        return idBook;
    }

    public void setIdBook(int idBook) {
        this.idBook = idBook;
    }
    

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }
  
}
