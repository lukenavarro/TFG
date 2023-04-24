package com.example.demo.services;

import com.example.demo.model.entities.User;
import com.example.demo.model.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {


    private UserRepository userRepository;

    @Override
    public User getUserWithUserNameAndPassword(String user, String password) {
        return userRepository.findByUserNameAndPassword(user,password);
    }

    public User addUser(User user){
       return (user==null)?null:userRepository.save(user);
    }
}
