package servicesTest;

import com.example.taskmanager.controllers.AuthController;
import com.example.taskmanager.jwt.JwtUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.mockito.MockitoAnnotations;

import java.util.Map;

public class AuthControllerTest {

    @Mock
    private JwtUtils jwtUtils;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private AuthController authController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void login_shouldReturnToken() {

        String email = "john@email.com";
        String password = "123";

        when(jwtUtils.generateToken(email)).thenReturn("fake-jwt-token");

        Map<String, String> response = authController.login(email, password);

        assertNotNull(response);
        assertEquals("fake-jwt-token", response.get("token"));

        verify(jwtUtils, times(1)).generateToken(email);
    }
}
