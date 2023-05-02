package com.example.demo.controllers;

import com.example.demo.model.entities.User;
import com.example.demo.services.UserService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/Test")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @CrossOrigin
    @GetMapping("/login")
    public ResponseEntity<Optional<User>> getUserWithAuth(@RequestParam("user") String userName, @RequestParam("pass") String password){
        Optional<User> user = Optional.ofNullable(userService.getUserWithUserNameAndPassword(userName,password));
        if (user.isEmpty()){
            return new ResponseEntity<>(user, HttpStatus.FORBIDDEN);
        }else{
            return new ResponseEntity<>(user,HttpStatus.OK);
        }
    }

    @CrossOrigin
    @PostMapping("/addUser")
    public ResponseEntity<Optional<User>> addUser(@RequestBody User user){
        Optional<User> userOptional = Optional.ofNullable(userService.addUser(user));
        if(userOptional.isEmpty()){
            return new ResponseEntity<>(userOptional,HttpStatus.FORBIDDEN);
        }else{
            return new ResponseEntity<>(userOptional,HttpStatus.OK);
        }
    }

}
