package com.app.repository;

import com.app.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository <Users, Integer> {

    @Query(value= "select u from Users u where u.isDeleted=0")
    Users findAllUsers();

    @Query(value = "select u from Users u where u.email=:email and u.isDeleted=0")
    Users findUserByEmail(String email);

    @Query(value = "select u from Users u where u.userId=:userId and u.isDeleted=0")
    Users findByUserId(int userId);
}
