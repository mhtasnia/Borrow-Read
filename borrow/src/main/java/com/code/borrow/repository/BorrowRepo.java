package com.code.borrow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.code.borrow.entities.Borrow;

@Repository
public interface BorrowRepo extends JpaRepository<Borrow, Long>{

}
