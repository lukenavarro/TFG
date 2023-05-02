package com.example.demo.DTO;

import com.example.demo.model.entities.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class HomeDTO {


    @JsonProperty(value = "ID")
    @JsonIgnore
    private Long ID;

    @JsonProperty(value = "Direccion")
    private String location;

    @JsonProperty(value = "Numero")
    private Long number;

    @JsonProperty(value = "Codigo Postal")
    private Long postalCode;

    @JsonProperty(value = "Ciudad")
    private String city;

    @JsonIgnore
    private User user;
}
