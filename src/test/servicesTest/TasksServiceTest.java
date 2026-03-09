package servicesTest;

import com.example.taskmanager.dto.TasksDTO;
import com.example.taskmanager.entities.Tasks;
import com.example.taskmanager.mappers.TasksMapper;
import com.example.taskmanager.repositories.TasksRepository;
import com.example.taskmanager.services.implementations.TasksService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.*;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class TasksServiceTest {

    @Mock
    private TasksRepository tasksRepository;

    @Mock
    private TasksMapper tasksMapper;

    @InjectMocks
    private TasksService tasksService;

    private Tasks task;
    private TasksDTO taskDTO;

    @BeforeEach
    void setUp() {

        MockitoAnnotations.openMocks(this);

        task = new Tasks();
        task.setId(1);
        task.setTitle("Test Task");
        task.setDescription("Test description");

        taskDTO = new TasksDTO();
        taskDTO.setId(1);
        taskDTO.setTitle("Test Task");
        taskDTO.setDescription("Test description");
    }

    @Test
    void createTask() {

        when(tasksMapper.toEntity(taskDTO)).thenReturn(task);
        when(tasksRepository.save(task)).thenReturn(task);
        when(tasksMapper.toDTO(task)).thenReturn(taskDTO);

        TasksDTO result = tasksService.createTask(taskDTO);

        assertNotNull(result);
        verify(tasksRepository).save(task);
    }

    @Test
    void getAllTasks() {

        when(tasksRepository.findAll()).thenReturn(List.of(task));
        when(tasksMapper.toDTO(task)).thenReturn(taskDTO);

        List<TasksDTO> result = tasksService.getAllTasks();

        assertEquals(1, result.size());
    }

    @Test
    void getTaskById() {

        when(tasksRepository.findById(1)).thenReturn(Optional.of(task));
        when(tasksMapper.toDTO(task)).thenReturn(taskDTO);

        TasksDTO result = tasksService.getTaskById(1);

        assertNotNull(result);
    }

    @Test
    void updateTask() {

        when(tasksRepository.findById(1)).thenReturn(Optional.of(task));
        when(tasksRepository.save(task)).thenReturn(task);
        when(tasksMapper.toDTO(task)).thenReturn(taskDTO);

        TasksDTO result = tasksService.updateTask(1, taskDTO);

        assertNotNull(result);
    }

    @Test
    void deleteTask() {

        tasksService.deleteTask(1);

        verify(tasksRepository).deleteById(1);
    }
}