package com.code.borrow.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Transient;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long book_id;
    private String ISBN;
    private String Title;
    private String author;
    private String  publisher;
    private double price;
    private String  category;
    private String cover_page;
    private int edition;
    private  boolean available;
    private String description;
    private int l_id;

    public int getL_id() {
        return l_id;
    }


    public void setL_id(int l_id) {
        this.l_id = l_id;
    }

    
    private Double rentalPrice;

    
    public Double depositeamount;
    
    public void calculateRentalPrice() {
        
        double baseRentalPrice = this.getPrice() * 0.1; 
        this.rentalPrice = Math.max(baseRentalPrice, 50.0); 
        double baseDeposite =  this.getPrice() * 1.5 ;
        this.depositeamount=Math.max(baseDeposite ,200.0 );
    }

   


    public Book() {
    }

    
  
    @ManyToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)  // Many-to-Many with Library (optional)
    private List<Library> libraries = new ArrayList<>(); 

    @ManyToMany(mappedBy = "borrowedBooks", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY) // Mapped by refers to the owning side (User)
    private List<User> borrowers;
    public long getBook_id() {
        return book_id;
    }
    public void setBook_id(long book_id) {
        this.book_id = book_id;
    }
    public String getISBN() {
        return ISBN;
    }
    public void setISBN(String iSBN) {
        ISBN = iSBN;
    }
    public String getTitle() {
        return Title;
    }
    public void setTitle(String title) {
        Title = title;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getPublisher() {
        return publisher;
    }
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public String getCover_page() {
        return cover_page;
    }
    public void setCover_page(String cover_page) {
        this.cover_page = cover_page;
    }
    public int getEdition() {
        return edition;
    }
    public void setEdition(int edition) {
        this.edition = edition;
    }
    public boolean isAvailable() {
        return available;
    }
    public void setAvailable(boolean available) {
        this.available = available;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Double getRentalPrice() {
        return rentalPrice;
    }
    
    public Double getDepositeamount() {
        return depositeamount;
    }
    


    


}
