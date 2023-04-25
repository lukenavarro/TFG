package com.example.demo.services;

import com.example.demo.model.entities.Home;
import com.example.demo.model.entities.User;

import java.util.List;

public interface HomeService {
    List<Home> getAllHomes();

    User getUsersWithHomeByID(Long id);

    User getUserRfidWithHomeByID(Long id,String rfidCode);

    Home addHome(Home home);
}
