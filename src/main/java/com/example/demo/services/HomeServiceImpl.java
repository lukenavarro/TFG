package com.example.demo.services;

import com.example.demo.DTO.HomeDTO;
import com.example.demo.DTO.UserDTO;
import com.example.demo.mapper.HomeDTOMapper;
import com.example.demo.mapper.UserDTOMapper;
import com.example.demo.model.entities.Home;
import com.example.demo.model.entities.User;
import com.example.demo.model.repositories.HomeRepository;
import com.example.demo.model.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor

public class HomeServiceImpl implements HomeService {

    private final HomeRepository homeRepository;

    private final UserRepository userRepository;

    private final UserDTOMapper userDTOMapper;

    private final HomeDTOMapper homeDTOMapper;

    @Override
    public List<HomeDTO> getAllHomes() {
        return homeDTOMapper.listHomeToHomeDTO(homeRepository.findAll());
    }

    public UserDTO getUsersWithHomeByID(Long id){
        Optional<Home> home = homeRepository.findById(id);
        return userDTOMapper.userToUserDTO(home.map(Home::getUser).orElse(null));
    }

    @Override
    public UserDTO getUserRfidWithHomeByID(Long id ,String rfidCode) {
        Optional<Home> home  =homeRepository.findById(id);
        User user;
        if (home.isEmpty()){
            return null;
        }else{
            user = home.get().getUser();
            if (user.getRfidCode().equals(rfidCode)){
                return userDTOMapper.userToUserDTO(user);
            }else{
                return null;
            }
        }
    }
}
