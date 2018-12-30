package spring.basic.auth.security.springbasicsecurity.repository;

import org.springframework.data.repository.CrudRepository;
import spring.basic.auth.security.springbasicsecurity.model.Role;

public interface RoleRepository extends CrudRepository<Role, Integer> {
}
