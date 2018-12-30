package spring.basic.auth.security.springbasicsecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import spring.basic.auth.security.springbasicsecurity.model.CustomUserDetails;
import spring.basic.auth.security.springbasicsecurity.model.Person;
import spring.basic.auth.security.springbasicsecurity.repository.PersonRepository;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public UserDetails loadUserByUsername(String personName) throws UsernameNotFoundException {
        Optional<Person> optionalPerson = personRepository.findByPersonName(personName);

        optionalPerson.orElseThrow(() -> new UsernameNotFoundException("User Not Found !"));

        return optionalPerson.map(CustomUserDetails::new).get();
    }
}
