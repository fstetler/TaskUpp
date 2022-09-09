package se.uu.ucr.interview.controller;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import se.uu.ucr.interview.jpa.Task;
import se.uu.ucr.interview.jpa.TaskRepository;
import se.uu.ucr.interview.service.TaskService;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequestMapping("task")
@RestController
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public void addTask(@RequestBody Task task) {
        taskService.addTask(task);
    }

    @GetMapping
    public List<Task> getTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping(path = "{id}")
    public Task getTaskById(@PathVariable("id") String id){
        return taskService.getTaskById(id).orElse(null);
    }
}
