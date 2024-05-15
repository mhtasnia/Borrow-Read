package com.code.borrow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.code.borrow.entities.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer>{
   
}
