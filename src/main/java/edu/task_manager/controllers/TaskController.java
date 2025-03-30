package edu.task_manager.controllers;

import edu.task_manager.jpa.entities.Task;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @GetMapping("/")
    public ResponseEntity<List<Task>> getAllTasks() {
        return new ResponseEntity<>(List.of(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTask(@PathVariable long id) {
        return new ResponseEntity<>(new Task(), HttpStatus.OK);
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
