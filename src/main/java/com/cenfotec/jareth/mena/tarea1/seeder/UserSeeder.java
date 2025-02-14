package com.cenfotec.jareth.mena.tarea1.seeder;

import com.cenfotec.jareth.mena.tarea1.model.Role;
import com.cenfotec.jareth.mena.tarea1.model.User;
import com.cenfotec.jareth.mena.tarea1.repository.RoleRepository;
import com.cenfotec.jareth.mena.tarea1.repository.UserRepository;
import com.cenfotec.jareth.mena.tarea1.model.enums.RoleEnum;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserSeeder implements ApplicationListener<ContextRefreshedEvent> {
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserSeeder(
            RoleRepository roleRepository,
            UserRepository userRepository,
            PasswordEncoder passwordEncoder
    ) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        this.createSuperAdministrator();
        this.createGenericUser();
    }

    private void createSuperAdministrator() {
        Optional<User> existingSuperAdmin = userRepository.findByName("Super");
        if (existingSuperAdmin.isPresent()) {
            System.out.println("Super Admin already exists. Skipping creation.");
            return;
        }

        Optional<Role> optionalRole = roleRepository.findByName(RoleEnum.ROLE_SUPER_ADMIN);
        Role superAdminRole;

        if (optionalRole.isEmpty()) {
            superAdminRole = new Role();
            superAdminRole.setName(RoleEnum.ROLE_SUPER_ADMIN);
            roleRepository.save(superAdminRole);
        } else {
            superAdminRole = optionalRole.get();
        }

        User superAdmin = new User();
        superAdmin.setName("Super");
        superAdmin.setPassword(passwordEncoder.encode("123"));
        superAdmin.setRole(superAdminRole);

        userRepository.save(superAdmin);
        System.out.println("Super Admin created successfully.");
    }

    private void createGenericUser() {
        Optional<User> existingGenericUser = userRepository.findByName("User");
        if (existingGenericUser.isPresent()) {
            System.out.println("Generic User already exists. Skipping creation.");
            return;
        }

        Optional<Role> optionalRole = roleRepository.findByName(RoleEnum.ROLE_USER);
        Role userRole;

        if (optionalRole.isEmpty()) {
            userRole = new Role();
            userRole.setName(RoleEnum.ROLE_USER);
            roleRepository.save(userRole);
        } else {
            userRole = optionalRole.get();
        }

        User genericUser = new User();
        genericUser.setName("User");
        genericUser.setPassword(passwordEncoder.encode("123")); // Encrypt the password
        genericUser.setRole(userRole);

        userRepository.save(genericUser);
        System.out.println("Generic User created successfully.");
    }
}