package com.rodolfo.taskMaster.config;


import com.rodolfo.taskMaster.entity.Role;
import com.rodolfo.taskMaster.entity.RoleName;
import com.rodolfo.taskMaster.repository.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initRoles(RoleRepository roleRepository){

        return args ->{
            if (roleRepository.findByName(RoleName.ROLE_USER).isEmpty()){
                roleRepository.save( new Role(null, RoleName.ROLE_USER));
            }

            if (roleRepository.findByName(RoleName.ROLE_ADMIN).isEmpty()){
                roleRepository.save( new Role(null, RoleName.ROLE_ADMIN));
            }

        };
    }
}
