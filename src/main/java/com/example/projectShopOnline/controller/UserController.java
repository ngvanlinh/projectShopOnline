package com.example.projectShopOnline.controller;

import com.example.projectShopOnline.entities.dto.respository.OrderResDTO;
import com.example.projectShopOnline.entities.dto.respository.UserResDTO;
import com.example.projectShopOnline.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserResDTO>> getAllUsers() {
        return ResponseEntity.ok(userService.findAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResDTO> getUserById(@PathVariable int id) {
        UserResDTO result = userService.findById(id);
        if (result == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<UserResDTO> createUser(@RequestBody UserResDTO userDTO) {
        return ResponseEntity.ok(userService.createUser(userDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResDTO> updateUser(@PathVariable int id, @RequestBody UserResDTO userResDTO) {
        userResDTO.setId(id);
        UserResDTO result = userService.updateUser(id,userResDTO);
        if (result == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteOrder(@PathVariable int id) {
        boolean result = userService.delete(id);
        if (result) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }
}
