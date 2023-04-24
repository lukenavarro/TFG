package com.example.demo.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity(name = "HOMES")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Home {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long ID;

    @Column(name = "LOCATION")
    private String location;

    @Column (name = "NUMBER")
    private Long number;

    @Column (name = "CP")
    private Long postalCode;

    @Column(name = "CITY")
    private String city;

    @ManyToOne
    @JoinColumn (name = "CLIENT_ID")
    @JsonIgnore
    private User user;

}
