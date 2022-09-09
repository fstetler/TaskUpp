package se.uu.ucr.interview.controller;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import se.uu.ucr.interview.jpa.Task;
import se.uu.ucr.interview.jpa.TaskRepository;

import java.text.MessageFormat;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
public class TaskController {

    private final TaskRepository taskRepository;

    // Add @Autowired here
    @Autowired
    TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping("/tasks")
    public List<Task> getTasks() {
        return StreamSupport
                .stream(taskRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @GetMapping("/tasks/{id}")
    public Task getTask(@PathVariable Long id) throws NotFoundException {
        return taskRepository.findById(id).orElse(null);
//        return taskRepository.findById(id)
//                .orElseThrow(() -> new NotFoundException(MessageFormat.format("Task with id {0} was not found.", id)));
    }

    @PostMapping
    public void addTask(Task task) {
    }
}
