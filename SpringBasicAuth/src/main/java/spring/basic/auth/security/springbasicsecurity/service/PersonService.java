package spring.basic.auth.security.springbasicsecurity.service;

import org.springframework.stereotype.Service;
import spring.basic.auth.security.springbasicsecurity.model.Person;
import spring.basic.auth.security.springbasicsecurity.model.Role;
import spring.basic.auth.security.springbasicsecurity.repository.PersonRepository;
import spring.basic.auth.security.springbasicsecurity.repository.RoleRepository;

import java.util.*;

@Service
public class PersonService {
    private PersonRepository personRepository;
    private RoleRepository roleRepository;

    public PersonService(PersonRepository personRepository, RoleRepository roleRepository) {
        this.personRepository = personRepository;
        this.roleRepository = roleRepository;
    }

    public Person savePerson(Person person, int roleId){

        List<Role> roles = new ArrayList<>();

        Optional<Role> optionalRole = roleRepository.findById(roleId);

        if (optionalRole.isPresent()){
            roles.add(optionalRole.get());
            person.setRoles(roles);
            personRepository.save(person);
            return person;
        }

        return null;
    }


    public Iterable<Person> getAll(){
        return personRepository.findAll();
    }

    public String helloSecured(){
        return "Hello Spring Security";
    }

    public String helloNotSecured(){
        return "Hello Not Secured In Spring Security";
    }

}
