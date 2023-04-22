package Medac.tfg.Services;

import Medac.tfg.Model.Person;

import java.util.List;
import java.util.Optional;

public interface PersonService {
    List<Person> findPersonByID(Long ID);

    Person findPersonByNameAndPassword(String name,String password);
}
