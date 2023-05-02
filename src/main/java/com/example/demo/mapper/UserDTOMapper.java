package com.example.demo.mapper;

import com.example.demo.DTO.HomeDTO;
import com.example.demo.DTO.UserDTO;
import com.example.demo.model.entities.Home;
import com.example.demo.model.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "Spring")
public interface UserDTOMapper {
    @Mapping(target = "userName",source = "userName")
    @Mapping(target = "homeDTO",source= "homes")
    @Mapping(target = "rfidCode",source = "rfidCode")

    UserDTO userToUserDTO(User user);
    List<HomeDTO> listHomeToHomeDTO(List<Home> home);

}
