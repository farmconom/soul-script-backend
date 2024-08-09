package com.soulscript.soul_script_backend.service;

import com.soulscript.soul_script_backend.dto.UserDto;

import java.util.List;

public interface UserService {

    UserDto createUser(UserDto userDto);

    UserDto getUserById(Long userId);

    List<UserDto> getUsers();

    UserDto updateUserById(Long userId, UserDto userDto);

    Boolean deleteUserById(Long userId);
}
