package com.rodolfo.taskMaster.mapper;

import com.rodolfo.taskMaster.dto.UserResponse;
import com.rodolfo.taskMaster.entity.User;

public class UserMapper {

    public static UserResponse toResponse(User user){
        return new UserResponse(
                user.getId(),
                user.getName(),
                user.getEmail()
        );
    }
}
