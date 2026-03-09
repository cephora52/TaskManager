package com.example.taskmanager.repositories;

import com.example.taskmanager.entities.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TasksRepository extends JpaRepository<Tasks, Integer> {

    List<Tasks> findByUserId_Id(Integer userId);

}