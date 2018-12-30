package spring.basic.auth.security.springbasicsecurity.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import spring.basic.auth.security.springbasicsecurity.model.Person;
import spring.basic.auth.security.springbasicsecurity.service.PersonService;

@RestController
@RequestMapping("person")
public class PersonController {
    private PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping("save/{roleId}")
    public Person save(@RequestBody Person person, @PathVariable int roleId){
         personService.savePerson(person, roleId);
         return person;
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("secured/all")
    public Iterable<Person> getAll(){
        return personService.getAll();
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("secured/hello")
    public String getHlwSecure(){
        return personService.helloSecured();
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("not")
    public String hello(){
        return "Hello Only for Admin";
    }

}
