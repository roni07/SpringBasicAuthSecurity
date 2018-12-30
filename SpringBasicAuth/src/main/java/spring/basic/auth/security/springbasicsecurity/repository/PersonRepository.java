package spring.basic.auth.security.springbasicsecurity.repository;

import org.springframework.data.repository.CrudRepository;
import spring.basic.auth.security.springbasicsecurity.model.Person;

import java.util.Optional;

public interface PersonRepository extends CrudRepository<Person, Integer> {
    Optional<Person> findByPersonName(String personName);
}
