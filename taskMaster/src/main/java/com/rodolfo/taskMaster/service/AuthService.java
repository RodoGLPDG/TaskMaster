package com.rodolfo.taskMaster.service;

import com.rodolfo.taskMaster.dto.AuthResponse;
import com.rodolfo.taskMaster.dto.LoginRequest;
import com.rodolfo.taskMaster.dto.RegisterRequest;
import com.rodolfo.taskMaster.dto.UserResponse;

public interface AuthService {

    public UserResponse register(RegisterRequest request);

    public AuthResponse login(LoginRequest request);
}
