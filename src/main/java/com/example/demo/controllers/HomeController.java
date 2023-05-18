package com.example.demo.controllers;

import com.example.demo.DTO.HomeDTO;
import com.example.demo.DTO.UserDTO;
import com.example.demo.services.HomeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class HomeController {

    private final HomeService homeService;

    @CrossOrigin
    @GetMapping("/homes")
    public ResponseEntity<List<HomeDTO>> getAllHomes(){
        List<HomeDTO> list = homeService.getAllHomes();
        if(list.isEmpty()){
            return new ResponseEntity<>(list, HttpStatus.FORBIDDEN);
        }else{
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
    }

    @CrossOrigin
    @GetMapping("/userHome")
    public ResponseEntity<Optional<UserDTO>> getUserWithHome(@RequestParam("id") Long id){
        Optional<UserDTO> user = Optional.ofNullable(homeService.getUsersWithHomeByID(id));
        if (user.isEmpty()){
            return new ResponseEntity<>(user,HttpStatus.FORBIDDEN);
        }else{
            return new ResponseEntity<>(user,HttpStatus.OK);
        }
    }


    @CrossOrigin
    @GetMapping("/access")
    public ResponseEntity<Optional<UserDTO>> getUserRfidCodeWithHome(@RequestParam("id") Long id, @RequestParam("rfidCode") String rfidCode){
        Optional <UserDTO> user = Optional.ofNullable(homeService.getUserRfidWithHomeByID(id,rfidCode));
        if(user.isEmpty()){
            return new ResponseEntity<>(user,HttpStatus.FORBIDDEN);
        }else{
            return new ResponseEntity<>(user,HttpStatus.OK);
        }
    }
}
