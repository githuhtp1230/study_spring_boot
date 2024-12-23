package com.example.buoi2.configuration;

import com.example.buoi2.entity.User;
import com.example.buoi2.enums.Role;
import com.example.buoi2.repository.UserRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@Configuration
public class ApplicationInitConfig {

    private final PasswordEncoder passwordEncoder;

    public ApplicationInitConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Bean
    ApplicationRunner applicationRunner(UserRepository userRepository) {
        return args -> {
            if ( userRepository.findByUsername("admin") == null ) {
                Set<String> roles = new HashSet<String>();
                roles.add(Role.ADMIN.name());

                User user = new User();
                user.setUsername("admin");
                user.setPassword(passwordEncoder.encode("admin"));
                user.setRoles(roles);

                userRepository.save(user);
            }
        };
    }
}
