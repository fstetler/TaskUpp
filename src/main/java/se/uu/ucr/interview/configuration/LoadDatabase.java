package se.uu.ucr.interview.configuration;

import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;
import se.uu.ucr.interview.jpa.Task;
import se.uu.ucr.interview.jpa.TaskRepository;

import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Class that implements all the features
 */
@Repository("configuration")
public class LoadDatabase implements TaskRepository {

    private static List<Task> taskList = new ArrayList<>();

    @Override
    public int insertTask(Task task) {
        taskList.add(new Task(task.getId(), task.getDescription(), task.getFieldStatus()));
        return 1;
    }

    @Override
    public Optional<Task> selectTaskById(String id) {
        return taskList.stream()
                .filter(task -> task.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<Task> selectAllTasks() {
        return taskList;
    }


//    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
//    @Bean
//    CommandLineRunner init(TaskRepository taskRepository) {
//        return args -> {
//            log.info("Load... " + taskRepository.save(new Task("Read through code", "Completed")));
//            log.info("Load... " + taskRepository.save(new Task("Perform tasks", "Completed")));
//            log.info("Load... " + taskRepository.save(new Task("Present solution", "Open")));
//        };
//    }
}
