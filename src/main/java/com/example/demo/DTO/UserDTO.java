package com.example.demo.DTO;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class UserDTO {
    @JsonProperty(value = "NombreUsuario")
    private String userName;

    @JsonProperty(value = "CasasAsociadas")
    private List<HomeDTO> homeDTO;

    @JsonProperty(value = "RFID")
    private String rfidCode;

}
