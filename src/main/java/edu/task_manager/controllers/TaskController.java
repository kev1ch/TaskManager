package edu.task_manager.controllers;

import edu.task_manager.jpa.entities.Task;
import edu.task_manager.jpa.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    TaskRepository taskRepository;

    @GetMapping("/")
    public ResponseEntity<List<Task>> getAllTasks() {
        List<Task> task_list = taskRepository.findAll();
        return new ResponseEntity<>(task_list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTask(@PathVariable long id) {
        Optional<Task> result = taskRepository.findById(1L);
        if (result.isPresent()) {
            return new ResponseEntity<>(result.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(long id) {
        return new ResponseEntity<>(new Task(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Task> deleteTask(@PathVariable long id) {
        return new ResponseEntity<>(new Task(), HttpStatus.OK);
    }

    @PostMapping("/{id}/upload")
    public ResponseEntity<Task> uploadToTask(long id) {
        return new ResponseEntity<>(new Task(), HttpStatus.OK);
    }

    @GetMapping("/{id}/download")
    public ResponseEntity<Task> downloadFromTask(long id) {
        return new ResponseEntity<>(new Task(), HttpStatus.OK);
    }
}
