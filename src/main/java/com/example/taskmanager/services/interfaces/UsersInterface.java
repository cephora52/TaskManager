package com.example.taskmanager.services.interfaces;

import com.example.taskmanager.dto.UsersDTO;
import com.example.taskmanager.entities.Users;

import java.util.List;

public interface UsersInterface {

    UsersDTO createUser(UsersDTO usersDTO);

    List<UsersDTO> getAllUsers();

    UsersDTO getUserById(Integer id);

    UsersDTO updateUser(Integer id, UsersDTO usersDTO);

    void deleteUser(Integer id);

    Users findByEmail(String email);

}