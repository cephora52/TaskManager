package com.example.taskmanager.controllers;

import com.example.taskmanager.dto.TasksDTO;
import com.example.taskmanager.services.interfaces.TasksInterface;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TasksController {

    private final TasksInterface tasksService;

    public TasksController(TasksInterface tasksService) {
        this.tasksService = tasksService;
    }

    @PostMapping
    public TasksDTO createTask(@RequestBody TasksDTO tasksDTO) {
        return tasksService.createTask(tasksDTO);
    }

    @GetMapping
    public List<TasksDTO> getAllTasks() {
        return tasksService.getAllTasks();
    }

    @GetMapping("/{id}")
    public TasksDTO getTaskById(@PathVariable Integer id) {
        return tasksService.getTaskById(id);
    }

    @PutMapping("/{id}")
    public TasksDTO updateTask(@PathVariable Integer id,
                               @RequestBody TasksDTO tasksDTO) {
        return tasksService.updateTask(id, tasksDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Integer id) {
        tasksService.deleteTask(id);
    }
}
