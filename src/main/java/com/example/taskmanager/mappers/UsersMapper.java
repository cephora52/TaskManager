package com.example.taskmanager.mappers;


import com.example.taskmanager.dto.UsersDTO;
import com.example.taskmanager.entities.Users;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsersMapper {

    UsersDTO toDTO(Users users);

    Users toEntity(UsersDTO usersDTO);
}