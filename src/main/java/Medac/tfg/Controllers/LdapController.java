package Medac.tfg.Controllers;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
@NoArgsConstructor
public class LdapController {
    public void getUsuario(@PathVariable String usuario, @PathVariable String password){
    }
}
