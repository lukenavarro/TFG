package com.example.demo.services;

import com.example.demo.model.entities.Home;
import com.example.demo.model.entities.User;
import com.example.demo.model.repositories.HomeRepository;
import com.example.demo.model.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor

public class HomeServiceImpl implements HomeService {

    private final HomeRepository homeRepository;

    private final UserRepository userRepository;

    @Override
    public List<Home> getAllHomes() {
        return homeRepository.findAll();
    }

    public User getUsersWithHomeByID(Long id){
        Optional<Home> home = homeRepository.findById(id);
        return home.map(Home::getUser).orElse(null);
    }

    @Override
    public User getUserRfidWithHomeByID(Long id ,String rfidCode) {
        Optional<Home> home  =homeRepository.findById(id);
        User user;
        if (home.isEmpty()){
            return null;
        }else{
            user = home.get().getUser();
            if (user.getRfidCode().equals(rfidCode)){
                return user;
            }else{
                return null;
            }
        }
    }

    @Override
    public Home addHome(Home home) {
        List<Long> listIDS = new ArrayList<>();
        for (Home home1:this.getAllHomes()) {
            listIDS.add(home1.getID());
        }
        return listIDS.contains(home.getID())? null:homeRepository.save(home);
    }
}
