package Medac.tfg.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "PERSON")
public class Person {

    @GeneratedValue
    @Id
    private Long id;

    @Column(name = "Name")
    private String name;

    @Column(name  = "Password")
    private String password;


}
