package com.code.borrow.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.code.borrow.entities.Book;

@Repository
public interface BookRepo extends JpaRepository<Book, Long> {
     @Query("SELECT DISTINCT b.l_id FROM Book b")
    List<Long> findAllLibraryIds();
}
