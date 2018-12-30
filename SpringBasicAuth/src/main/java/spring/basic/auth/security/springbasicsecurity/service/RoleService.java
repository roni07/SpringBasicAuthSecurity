package spring.basic.auth.security.springbasicsecurity.service;

import org.springframework.stereotype.Service;
import spring.basic.auth.security.springbasicsecurity.model.Role;
import spring.basic.auth.security.springbasicsecurity.repository.RoleRepository;

@Service
public class RoleService {
    private RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role storeRole(Role role){
        return roleRepository.save(role);
    }

    public Iterable<Role> getRoles(){
        return roleRepository.findAll();
    }
}
