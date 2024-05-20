package com.code.borrow.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotNull(message = "Name field is required")
    @Size(min = 2, max = 20, message = "Name should be 2 to 20 characters long")
    private String name;
    @Column(unique=true)
    private String email;
    private String contact;
    @Column(length=1024)
    private String address;
    private String password;
    private double currency = 2000;
    

    

    

   
    public double getCurrency() {
        return currency;
    }



    public void setCurrency(double currency) {
        this.currency = currency;
    }



    public User() {
    }
    
    

    



    public User(long id,
            @NotNull(message = "Name field is required") @Size(min = 2, max = 20, message = "Name should be 2 to 20 characters long") String name,
            String email, String contact, String address, String password, double currency) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.contact = contact;
        this.address = address;
        this.password = password;
        this.currency = currency;
    }







    @ManyToMany // Many-to-Many with Book (optional)
    private List<Book> borrowedBooks = new ArrayList<>();
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getContact() {
        return contact;
    }
    public void setContact(String contact) {
        this.contact = contact;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }


}
