package se.uu.ucr.interview.controller;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TaskControllerTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @Test
    public void listTasks_shouldReturnTasks() throws Exception {
        ResponseEntity<String> entity = testRestTemplate.getForEntity("/tasks", String.class);
        Assertions.assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
        Assertions.assertThat(entity.getBody()).contains("Perform tasks");
    }

    @Test
    public void getTask_shouldReturnTask() throws Exception {
        ResponseEntity<String> entity = testRestTemplate.getForEntity("/tasks/1", String.class);
        Assertions.assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
        Assertions.assertThat(entity.getBody()).contains("Read through code");
    }

    @Test
    public void getNonExistingTask_shouldReturnError() throws Exception {
        ResponseEntity<String> entity = testRestTemplate.getForEntity("/tasks/5", String.class);
        Assertions.assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}