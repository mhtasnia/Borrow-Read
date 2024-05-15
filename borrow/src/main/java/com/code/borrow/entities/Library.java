package com.code.borrow.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Libraries")
public class Library {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int l_id;
    private String l_name;
    private String l_address;
    @Column(unique = true)
    private String l_email;
    @Column(unique = true)
    private String l_contact;
    @Column(length = 1000)
    private String l_about;

    @ManyToMany(mappedBy = "libraries") // Mapped by refers to the owning side (Book)
    private List<Book> books = new ArrayList<>(); 

    public Library() {
    }
    
    public Library(int l_id, String l_name, String l_address, String l_email, String l_contact, String l_about) {
        this.l_id = l_id;
        this.l_name = l_name;
        this.l_address = l_address;
        this.l_email = l_email;
        this.l_contact = l_contact;
        this.l_about = l_about;
    }

    public int getL_id() {
        return l_id;
    }
    public void setL_id(int l_id) {
        this.l_id = l_id;
    }
    public String getL_name() {
        return l_name;
    }
    public void setL_name(String l_name) {
        this.l_name = l_name;
    }
    public String getL_address() {
        return l_address;
    }
    public void setL_address(String l_address) {
        this.l_address = l_address;
    }
    public String getL_email() {
        return l_email;
    }
    public void setL_email(String l_email) {
        this.l_email = l_email;
    }
    public String getL_contact() {
        return l_contact;
    }
    public void setL_contact(String l_contact) {
        this.l_contact = l_contact;
    }
    public String getL_about() {
        return l_about;
    }
    public void setL_about(String l_about) {
        this.l_about = l_about;
    }

}
