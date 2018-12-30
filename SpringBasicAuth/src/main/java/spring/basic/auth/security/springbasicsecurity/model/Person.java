package spring.basic.auth.security.springbasicsecurity.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Person {
    @Id
    private int personId;
    private String personName;
    private String password;
    private int age;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Role> roles;

    public Person(Person person){
        this.personId = person.personId;
        this.personName = person.personName;
        this.age = person.age;
        this.roles = person.roles;
    }
}
