package com.optimus.nnlt.service.impl

import com.optimus.nnlt.model.Role
import com.optimus.nnlt.repository.RoleRepository
import com.optimus.nnlt.service.RoleService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class RoleServiceImpl implements RoleService {
    @Autowired
    RoleRepository roleRepository;

    List<Role> getAllRole() {
        return roleRepository.findAll();
    }

    Optional<Role> findRoleById(int id){
        return roleRepository.findById(id);
    }

}
