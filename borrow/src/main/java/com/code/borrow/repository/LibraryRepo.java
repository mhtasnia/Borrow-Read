package com.code.borrow.repository;

import com.code.borrow.entities.Library;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LibraryRepo extends JpaRepository<Library, Integer> {
    @Query("SELECT l FROM Library l WHERE l.l_email = :email")
    Library findByLEmail(String email);
}
