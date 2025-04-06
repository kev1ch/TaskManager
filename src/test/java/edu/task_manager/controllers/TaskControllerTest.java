package edu.task_manager.controllers;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@AutoConfigureMockMvc
public class TaskControllerTest {

    @Autowired
    private MockMvc mock_mvc;

    @Sql(scripts = {"/ddl/PopulatingTable.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(scripts = {"/ddl/Cleanup.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    @Test
    @SneakyThrows
    public void getAllTasksTest() {
        MvcResult result = mock_mvc.perform(MockMvcRequestBuilders.get("/tasks/")
                .contentType(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        String content = result.getResponse().getContentAsString();
        assertTrue(content.contains("Upload changes to repository"));
        assertTrue(content.contains("Add more features"));
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
