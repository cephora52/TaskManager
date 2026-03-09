package com.example.taskmanager.services.implementations;

import com.example.taskmanager.dto.UsersDTO;
import com.example.taskmanager.entities.Users;
import com.example.taskmanager.mappers.UsersMapper;
import com.example.taskmanager.repositories.UsersRepository;
import com.example.taskmanager.services.interfaces.UsersInterface;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsersService implements UsersInterface {

    private final UsersRepository usersRepository;
    private final UsersMapper usersMapper;
    private final PasswordEncoder passwordEncoder;

    public UsersService(UsersRepository usersRepository,
                        UsersMapper usersMapper,
                        PasswordEncoder passwordEncoder) {
        this.usersRepository = usersRepository;
        this.usersMapper = usersMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UsersDTO createUser(UsersDTO usersDTO) {

        Users user = usersMapper.toEntity(usersDTO);

        // encoder le mot de passe
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        Users savedUser = usersRepository.save(user);

        return usersMapper.toDTO(savedUser);
    }

    @Override
    public List<UsersDTO> getAllUsers() {

        return usersRepository.findAll()
                .stream()
                .map(usersMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UsersDTO getUserById(Integer id) {

        Users user = usersRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return usersMapper.toDTO(user);
    }

    @Override
    public UsersDTO updateUser(Integer id, UsersDTO usersDTO) {

        Users user = usersRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setName(usersDTO.getName());
        user.setEmail(usersDTO.getEmail());

        Users updatedUser = usersRepository.save(user);

        return usersMapper.toDTO(updatedUser);
    }

    @Override
    public void deleteUser(Integer id) {

        usersRepository.deleteById(id);
    }

    @Override
    public Users findByEmail(String email) {

        return usersRepository.findByEmail(email);
    }
}