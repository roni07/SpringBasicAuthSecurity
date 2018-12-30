package spring.basic.auth.security.springbasicsecurity.controller;

import org.springframework.web.bind.annotation.*;
import spring.basic.auth.security.springbasicsecurity.model.Role;
import spring.basic.auth.security.springbasicsecurity.service.RoleService;

@RestController
@RequestMapping("role")
public class RoleController {
    private RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping("save")
    public Role saveRole(@RequestBody Role role){
        return roleService.storeRole(role);
    }

    @GetMapping("roles")
    public Iterable<Role> allRoles(){
        return roleService.getRoles();
    }
}
