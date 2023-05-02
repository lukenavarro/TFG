package com.example.demo.mapper;

import com.example.demo.DTO.HomeDTO;
import com.example.demo.model.entities.Home;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "Spring")
public interface HomeDTOMapper {


    @Mapping(target = "ID",source = "ID")
    @Mapping(target = "location",source = "location")
    @Mapping(target = "number",source = "number")
    @Mapping(target = "postalCode",source = "postalCode")
    @Mapping(target = "user",source  = "user")
    @Mapping(target = "city",source = "city")

    HomeDTO homeToHomeDTO(Home home);

    List<HomeDTO> listHomeToHomeDTO(List<Home> home);


}
