package com.soulscript.soul_script_backend.controller;

import com.soulscript.soul_script_backend.dto.UserDto;
import com.soulscript.soul_script_backend.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long userId) {
        UserDto userDto = userService.getUserById(userId);
        return ResponseEntity.ok(userDto);
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getUsers() {
        List<UserDto> users = userService.getUsers();
        return ResponseEntity.ok(users);
    }

    @PatchMapping("{id}")
    public ResponseEntity<UserDto> updateUserById(@PathVariable("id") Long userId, @RequestBody UserDto userDto) {
        UserDto updatedUser = userService.updateUserById(userId, userDto);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> deleteUserById(@PathVariable("id") Long userId) {
        Boolean resp = userService.deleteUserById(userId);
        return ResponseEntity.ok(resp);
    }
}
