package com.optimus.nnlt.service

import com.optimus.nnlt.model.Role
import org.springframework.stereotype.Service

@Service
interface RoleService  {
    List<Role> getAllRole();
    Optional<Role> findRoleById(int id);

}
