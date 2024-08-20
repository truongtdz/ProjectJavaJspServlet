
package model;

public class User {
    private int id_user;
    private String userName, passWord, firstName, lastName, address, phone;

    public User() {
    }

    public User(int id, String userName, String passWord, String firstName, String lastName, String address, String phone) {
        this.id_user = id;
        this.userName = userName;
        this.passWord = passWord;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
    }

    public User(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    } 

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getId_user() {
        return id_user;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    
    
}
