package com.example.taskmanager.controllers;

import com.example.taskmanager.dto.UsersDTO;
import com.example.taskmanager.services.interfaces.UsersInterface;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UsersController {

    private final UsersInterface usersService;

    public UsersController(UsersInterface usersService) {
        this.usersService = usersService;
    }

    @PostMapping
    public UsersDTO createUser(@RequestBody UsersDTO usersDTO) {
        return usersService.createUser(usersDTO);
    }

    @GetMapping
    public List<UsersDTO> getAllUsers() {
        return usersService.getAllUsers();
    }

    @GetMapping("/{id}")
    public UsersDTO getUserById(@PathVariable Integer id) {
        return usersService.getUserById(id);
    }

    @PutMapping("/{id}")
    public UsersDTO updateUser(@PathVariable Integer id,
                               @RequestBody UsersDTO usersDTO) {
        return usersService.updateUser(id, usersDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id) {
        usersService.deleteUser(id);
    }
}