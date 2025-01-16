package com.example.projectShopOnline.repository;


import com.example.projectShopOnline.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmail(String email);
}
