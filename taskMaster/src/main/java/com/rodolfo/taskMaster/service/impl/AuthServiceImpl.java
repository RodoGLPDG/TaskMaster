package com.rodolfo.taskMaster.service.impl;


import com.rodolfo.taskMaster.dto.AuthResponse;
import com.rodolfo.taskMaster.dto.LoginRequest;
import com.rodolfo.taskMaster.dto.RegisterRequest;
import com.rodolfo.taskMaster.dto.UserResponse;
import com.rodolfo.taskMaster.entity.Role;
import com.rodolfo.taskMaster.entity.RoleName;
import com.rodolfo.taskMaster.entity.User;
import com.rodolfo.taskMaster.exception.ResourceNotFoundException;
import com.rodolfo.taskMaster.mapper.UserMapper;
import com.rodolfo.taskMaster.repository.RoleRepository;
import com.rodolfo.taskMaster.repository.UserRepository;
import com.rodolfo.taskMaster.security.JwtService;
import com.rodolfo.taskMaster.service.AuthService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;


    public AuthServiceImpl(UserRepository userRepository, RoleRepository roleRepository, JwtService jwtService, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserResponse register(RegisterRequest request){
        if(userRepository.findByEmail(request.getEmail()).isPresent()){
            throw new RuntimeException("Email already exist");
        }

        Role userRole = roleRepository.findByName(RoleName.ROLE_USER).orElseThrow(()-> new ResourceNotFoundException("Role not found"));

        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRoles(Set.of(userRole));

        userRepository.save(user);

        return UserMapper.toResponse(user);

    }



    @Override
    public AuthResponse login(LoginRequest request){

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        boolean validPassword = passwordEncoder.matches(
                request.getPassword(),
                user.getPassword()
        );

        if (!validPassword){
            throw new RuntimeException("Invalid credentials");
        }

        String token = jwtService.generateToken(user.getEmail());

        return new AuthResponse(
                token,
                user.getName(),
                user.getEmail()
        );
    }

}
