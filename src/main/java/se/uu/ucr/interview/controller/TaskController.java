package se.uu.ucr.interview.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import se.uu.ucr.interview.jpa.Task;
import se.uu.ucr.interview.jpa.TaskRepository;

import java.text.MessageFormat;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RequestMapping("/tasks")
@RestController
public class TaskController {

    private final TaskRepository taskRepository;

    @Autowired
    TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping
    public List<Task> getTasks() {
        return StreamSupport
                .stream(taskRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND,
                        MessageFormat.format("Task with id {0} was not found.", id)));
    }

    @PostMapping
    public void addTask(@RequestBody Task task) {
        taskRepository.save(task);
    }
}

// notes to assignment ----
// Add autowired in order to instantiate repository
// Added RequestMapping("/tasks") so all mapping uses it instead of just GetMapping, saves space for PostMapping
// Changed GetMappingPath with id so not to call /tasks/ twice
// Changed name from getTasks to getTaskById for easier readability/logical
// Removed unneeded throwing of exception warning
// Changed NotFoundException to ResponseStatusException to better represent what is actually happening
// Added server error message in application.properties in order for ResponseStatusException to show error message