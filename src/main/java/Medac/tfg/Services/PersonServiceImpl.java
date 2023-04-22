package Medac.tfg.Services;

import Medac.tfg.Model.Person;
import Medac.tfg.Model.PersonRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Builder
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    @Override
    public List<Person> findPersonByID(Long ID) {
        return personRepository.findByID(ID);
    }
    @Override
    public Person findPersonByNameAndPassword(String name, String password) {
        return personRepository.findByNameAndPassword(name,password);
    }
}
