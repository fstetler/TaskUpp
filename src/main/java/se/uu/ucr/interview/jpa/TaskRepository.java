package se.uu.ucr.interview.jpa;

import org.springframework.data.repository.CrudRepository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

/**
 * Interface for Task
 */
public interface TaskRepository{
    int insertTask(Task task);

    default int addTask(Task task) { return insertTask(task); }

    Optional<Task> selectTaskById(String id);

    List<Task> selectAllTasks();
}
