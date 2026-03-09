package com.example.taskmanager.mappers;

import com.example.taskmanager.dto.TasksDTO;
import com.example.taskmanager.entities.Tasks;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TasksMapper {

    @Mapping(source = "userId.id", target = "userId")
    TasksDTO toDTO(Tasks tasks);

    @Mapping(source = "userId", target = "userId.id")
    Tasks toEntity(TasksDTO tasksDTO);
}