package com.example.demo.controllers;

import com.example.demo.model.entities.Home;
import com.example.demo.model.entities.User;
import com.example.demo.services.HomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Test")
@RequiredArgsConstructor
public class HomeController {

    private final HomeService homeService;
    @GetMapping("/homes")
    public ResponseEntity<List<Home>> getAllHomes(){
        List<Home> list = homeService.getAllHomes();
        if(list.isEmpty()){
            return new ResponseEntity<>(list, HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
    }
    @GetMapping("/userHome")
    public ResponseEntity<Optional<User>> getUserWithHome(@RequestParam("id") Long id){
        Optional<User> user = Optional.ofNullable(homeService.getUsersWithHomeByID(id));
        if (user.isEmpty()){
            return new ResponseEntity<>(user,HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(user,HttpStatus.OK);
        }
    }

    @GetMapping("/access")
    public ResponseEntity<Optional<User>> getUserRfidCodeWithHome(@RequestParam("id") Long id, @RequestParam("rfidCode") String rfidCode){
        Optional <User> user = Optional.ofNullable(homeService.getUserRfidWithHomeByID(id,rfidCode));
        if(user.isEmpty()){
            return new ResponseEntity<>(user,HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(user,HttpStatus.OK);
        }
    }

    @PostMapping("/addhome")
    public ResponseEntity<Optional<Home>> addHome(@RequestBody Home home){
        Optional<Home> homeOptional = Optional.ofNullable(homeService.addHome(home));
        if(homeOptional.isEmpty()){
            return new ResponseEntity<>(homeOptional,HttpStatus.BAD_GATEWAY);
        }else{
            return new ResponseEntity<>(homeOptional,HttpStatus.OK);
        }
    }
}
