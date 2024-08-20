package model;

public class Book {
    private int id_book, price, pageNumber, quantity;
    private String name, subject, classBook;

    public Book() {
    }

    public Book(int id_book, int price, int pageNumber, int quantity, String name, String subject, String classBook) {
        this.id_book = id_book;
        this.price = price;
        this.pageNumber = pageNumber;
        this.quantity = quantity;
        this.name = name;
        this.subject = subject;
        this.classBook = classBook;
    }

    public int getId_book() {
        return id_book;
    }

    public void setId_book(int id_book) {
        this.id_book = id_book;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getClassBook() {
        return classBook;
    }

    public void setClassBook(String classBook) {
        this.classBook = classBook;
    }

    
}
