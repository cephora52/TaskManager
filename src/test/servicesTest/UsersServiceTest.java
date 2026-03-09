package servicesTest;

import com.example.taskmanager.dto.UsersDTO;
import com.example.taskmanager.entities.Users;
import com.example.taskmanager.mappers.UsersMapper;
import com.example.taskmanager.repositories.UsersRepository;
import com.example.taskmanager.services.implementations.UsersService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.*;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class UsersServiceTest {

    @Mock
    private UsersRepository usersRepository;

    @Mock
    private UsersMapper usersMapper;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private UsersService usersService;

    private Users user;
    private UsersDTO userDTO;

    @BeforeEach
    void setUp() {

        MockitoAnnotations.openMocks(this);

        user = new Users();
        user.setId(1);
        user.setName("John");
        user.setEmail("john@email.com");
        user.setPassword("123");

        userDTO = new UsersDTO();
        userDTO.setId(1);
        userDTO.setName("John");
        userDTO.setEmail("john@email.com");

    }

    @Test
    void createUser() {

        when(usersMapper.toEntity(userDTO)).thenReturn(user);
        when(passwordEncoder.encode("123")).thenReturn("encodedPassword");
        when(usersRepository.save(user)).thenReturn(user);
        when(usersMapper.toDTO(user)).thenReturn(userDTO);

        UsersDTO result = usersService.createUser(userDTO);

        assertNotNull(result);
        verify(usersRepository).save(user);
    }

    @Test
    void getAllUsers() {

        when(usersRepository.findAll()).thenReturn(List.of(user));
        when(usersMapper.toDTO(user)).thenReturn(userDTO);

        List<UsersDTO> result = usersService.getAllUsers();

        assertEquals(1, result.size());
    }

    @Test
    void getUserById() {

        when(usersRepository.findById(1)).thenReturn(Optional.of(user));
        when(usersMapper.toDTO(user)).thenReturn(userDTO);

        UsersDTO result = usersService.getUserById(1);

        assertNotNull(result);
    }

    @Test
    void updateUser() {

        when(usersRepository.findById(1)).thenReturn(Optional.of(user));
        when(usersRepository.save(user)).thenReturn(user);
        when(usersMapper.toDTO(user)).thenReturn(userDTO);

        UsersDTO result = usersService.updateUser(1, userDTO);

        assertNotNull(result);
    }

    @Test
    void deleteUser() {

        usersService.deleteUser(1);

        verify(usersRepository).deleteById(1);
    }
}
