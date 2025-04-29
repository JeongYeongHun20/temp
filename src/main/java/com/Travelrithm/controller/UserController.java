package com.Travelrithm.controller;

import com.Travelrithm.dto.UserRequestDto;
import com.Travelrithm.dto.UserResponseDto;
import com.Travelrithm.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;


    @PostMapping
    public ResponseEntity<UserResponseDto> createUser(@RequestBody UserRequestDto user) {
        return ResponseEntity.ok(userService.join(user));
    }


    @GetMapping
    public ResponseEntity<List<UserResponseDto>> getAllUsers() {
        return ResponseEntity.ok(userService.findAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> getUserById(@PathVariable(name = "id") Integer id) {
        return ResponseEntity.ok(userService.findUser(id));
    }


    @PutMapping("/{id}") //전체 수정
    public ResponseEntity<UserResponseDto> updateUser(@PathVariable(name="id") Integer id, @RequestBody UserRequestDto user) {
        return ResponseEntity.ok(userService.updateUser(id, user));
    }
    /*
    @PatchMapping("/{id}") //부분 수정(추후 추가)
    public ResponseEntity<UserResponseDTO> patchUser(@PathVariable Integer id, @RequestBody UserRequestDTO user) {
        return ResponseEntity.ok(userService.updateUser(id, user));
    }
     */

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}