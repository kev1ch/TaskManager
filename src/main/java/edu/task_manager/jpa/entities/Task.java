package edu.task_manager.jpa.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "description")
    private String description;
    @Column(name = "due_date")
    private LocalDateTime dueDate;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "status")
    private TaskStatus status;
    @Column(name = "file_path")
    private String filePath;

}
