package com.soulscript.soul_script_backend.mapper;

import com.soulscript.soul_script_backend.dto.UserDto;
import com.soulscript.soul_script_backend.entity.User;

public class UserMapper {

    public static UserDto mapToUserDto(User user) {
        return new UserDto(
                user.getId(),
                user.getEmail(),
                user.getPassword()
        );
    }

    public static User mapToUser(UserDto userDto) {
        return new User(
                userDto.getId(),
                userDto.getEmail(),
                userDto.getPassword()
        );
    }
}
