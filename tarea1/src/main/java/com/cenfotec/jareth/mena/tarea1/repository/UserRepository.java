package com.cenfotec.jareth.mena.tarea1.repository;

import com.cenfotec.jareth.mena.tarea1.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByName(String name);
}
