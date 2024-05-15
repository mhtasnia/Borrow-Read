package com.code.borrow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.code.borrow.entities.Library;

@Repository
public interface LibraryRepo extends JpaRepository<Library, Integer>{

}
