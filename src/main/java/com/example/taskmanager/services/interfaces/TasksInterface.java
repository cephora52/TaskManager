package com.example.taskmanager.services.interfaces;

import com.example.taskmanager.dto.TasksDTO;

import java.util.List;

public interface TasksInterface {

    TasksDTO createTask(TasksDTO tasksDTO);

    List<TasksDTO> getAllTasks();

    TasksDTO getTaskById(Integer id);

    TasksDTO updateTask(Integer id, TasksDTO tasksDTO);

    void deleteTask(Integer id);

}
