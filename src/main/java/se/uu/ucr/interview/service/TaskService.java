package se.uu.ucr.interview.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import se.uu.ucr.interview.jpa.Task;
import se.uu.ucr.interview.jpa.TaskRepository;

import java.util.List;
import java.util.Optional;

/**
 * Service class for Task
 */
@Service
public class TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(@Qualifier("configuration") TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public int addTask(Task task){
        return taskRepository.insertTask(task);
    }

    public List<Task> getAllTasks() {
        return taskRepository.selectAllTasks();
    }

    public Optional<Task> getTaskById(String id) {
        return taskRepository.selectTaskById(id);
    }

}
