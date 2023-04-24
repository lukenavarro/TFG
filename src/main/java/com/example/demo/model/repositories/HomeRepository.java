package com.example.demo.model.repositories;

import com.example.demo.model.entities.Home;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HomeRepository extends JpaRepository<Home,Long> {

    Home findUsersWithHomeByID(Long id);

    Home findUserRfidWithHomeByID(Long id);

}
