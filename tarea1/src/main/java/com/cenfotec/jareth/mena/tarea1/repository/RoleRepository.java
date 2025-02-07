package com.cenfotec.jareth.mena.tarea1.repository;

import com.cenfotec.jareth.mena.tarea1.model.Role;
import com.cenfotec.jareth.mena.tarea1.model.enums.RoleEnum;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends CrudRepository<Role, Integer> {
    Optional<Role> findByName(RoleEnum name);
}
