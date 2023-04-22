package Medac.tfg.Controllers;

import Medac.tfg.Model.Person;
import Medac.tfg.Services.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/test")
@AllArgsConstructor
public class PersonController {

    private final PersonService personService;

    @PostMapping("/persona")
    public ResponseEntity<Person> getPersonByNameAndPassword(@RequestParam("name") String name, @RequestParam("password") String password){

            return new ResponseEntity<>(personService.findPersonByNameAndPassword(name,password),HttpStatus.OK);

    }
}
