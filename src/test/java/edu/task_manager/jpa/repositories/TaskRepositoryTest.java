package edu.task_manager.jpa.repositories;

import edu.task_manager.jpa.entities.Task;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class TaskRepositoryTest {

    @Autowired
    TaskRepository taskRepository;

    @Test
    void getAll() {
        List<Task> result = taskRepository.findAll();

        assertNotNull(result);
        assertEquals(0, result.size());
    }
}
