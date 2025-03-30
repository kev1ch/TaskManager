package edu.task_manager.controllers;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class TaskControllerTest {

    @Autowired
    private MockMvc mock_mvc;

    @Test
    @SneakyThrows
    public void getAllTasksTest() {
        mock_mvc.perform(MockMvcRequestBuilders.get("/tasks/")
                .contentType(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @SneakyThrows
    public void getTaskTest() {
        String url = String.format("/tasks/%d", 1);
        mock_mvc.perform(MockMvcRequestBuilders.get("/tasks/")
                .contentType(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @SneakyThrows
    public void deleteTaskTest() {
        // /task/1
        String url = String.format("/tasks/%d", 1);
        mock_mvc.perform(MockMvcRequestBuilders.delete(url)
                .contentType(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk());
    }

}
