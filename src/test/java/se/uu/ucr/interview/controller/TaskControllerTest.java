package se.uu.ucr.interview.controller;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import se.uu.ucr.interview.jpa.Task;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TaskControllerTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @Test
    public void listTasks_shouldReturnTasks() {
        ResponseEntity<String> entity = testRestTemplate.getForEntity("/tasks", String.class);
        Assertions.assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
        Assertions.assertThat(entity.getBody()).contains("Read through code", "Completed");
        Assertions.assertThat(entity.getBody()).contains("Perform tasks", "Completed");
        Assertions.assertThat(entity.getBody()).contains("Present solution", "Open");
    }

    @Test
    public void getTask_shouldReturnTask() {
        ResponseEntity<String> entity = testRestTemplate.getForEntity("/tasks/1", String.class);
        Assertions.assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
        Assertions.assertThat(entity.getBody()).contains("Read through code", "Completed");
    }

    @Test
    public void getNonExistingTask_shouldReturnError() {
        ResponseEntity<String> entity = testRestTemplate.getForEntity("/tasks/5", String.class);
        Assertions.assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }

    @Test
    public void addTask_verifyNewTaskIsAdded() {
        ResponseEntity<String> entityBefore = testRestTemplate.getForEntity("/tasks/4", String.class);
        Assertions.assertThat(entityBefore.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
        testRestTemplate.postForEntity("/tasks", new Task("Finishing task", "Open"), String.class);
        ResponseEntity<String> entityAfter = testRestTemplate.getForEntity("/tasks/4", String.class);
        Assertions.assertThat(entityAfter.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}