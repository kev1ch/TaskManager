package edu.task_manager.jpa.repositories;

import edu.task_manager.jpa.entities.Task;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class TaskRepositoryTest {

    @Autowired
    TaskRepository taskRepository;

    @Sql(scripts = {"/ddl/PopulatingTable.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(scripts = {"/ddl/Cleanup.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    @Test
    void getAll() {
        List<Task> result = taskRepository.findAll();

        assertNotNull(result);
        assertEquals(0, result.size());
    }

    @Sql(scripts = {"/ddl/PopulatingTable.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(scripts = {"/ddl/Cleanup.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    @Test
    void getTaskById() {
        Optional<Task> result = taskRepository.findById(1L);
        assertNotNull(result);
        // assertEquals(0, result.size());
    }
}
