package com.example.demo.model.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity(name = "USERS")
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class User {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "CLIENT_ID")
    private Long id;

    @Column(name = "USER_NAME")
    private String userName;

    @Column(name = "USER_PASSWORD")
    private String password;

    @OneToMany(mappedBy = "user")
    private List<Home> homes;

    @Column(name = "RFID_CODE")
    private String rfidCode;

}
