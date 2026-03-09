package com.example.taskmanager.services.implementations;

import com.example.taskmanager.dto.TasksDTO;
import com.example.taskmanager.entities.Tasks;
import com.example.taskmanager.mappers.TasksMapper;
import com.example.taskmanager.repositories.TasksRepository;
import com.example.taskmanager.services.interfaces.TasksInterface;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TasksService implements TasksInterface {

    private final TasksRepository tasksRepository;
    private final TasksMapper tasksMapper;

    public TasksService(TasksRepository tasksRepository, TasksMapper tasksMapper) {
        this.tasksRepository = tasksRepository;
        this.tasksMapper = tasksMapper;
    }

    @Override
    public TasksDTO createTask(TasksDTO tasksDTO) {

        Tasks tasks = tasksMapper.toEntity(tasksDTO);

        Tasks savedTask = tasksRepository.save(tasks);

        return tasksMapper.toDTO(savedTask);
    }

    @Override
    public List<TasksDTO> getAllTasks() {

        return tasksRepository.findAll()
                .stream()
                .map(tasksMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public TasksDTO getTaskById(Integer id) {

        Tasks task = tasksRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        return tasksMapper.toDTO(task);
    }

    @Override
    public TasksDTO updateTask(Integer id, TasksDTO tasksDTO) {

        Tasks task = tasksRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        task.setTitle(tasksDTO.getTitle());
        task.setDescription(tasksDTO.getDescription());
        task.setStatus(tasksDTO.getStatus());

        Tasks updatedTask = tasksRepository.save(task);

        return tasksMapper.toDTO(updatedTask);
    }

    @Override
    public void deleteTask(Integer id) {

        tasksRepository.deleteById(id);
    }
}