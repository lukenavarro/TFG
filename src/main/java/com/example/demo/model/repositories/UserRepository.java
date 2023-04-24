package com.example.demo.model.repositories;

import com.example.demo.model.entities.Home;
import com.example.demo.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByUserNameAndPassword(String user, String password);


}