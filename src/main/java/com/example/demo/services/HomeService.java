package com.example.demo.services;

import com.example.demo.DTO.HomeDTO;
import com.example.demo.DTO.UserDTO;
import com.example.demo.model.entities.Home;
import com.example.demo.model.entities.User;

import java.util.List;

public interface HomeService {
    List<HomeDTO> getAllHomes();

    UserDTO getUsersWithHomeByID(Long id);

    UserDTO getUserRfidWithHomeByID(Long id,String rfidCode);
}
