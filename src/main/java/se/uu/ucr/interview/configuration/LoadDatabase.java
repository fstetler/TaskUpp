package se.uu.ucr.interview.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import se.uu.ucr.interview.jpa.Task;
import se.uu.ucr.interview.jpa.TaskRepository;

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
    @Bean
    CommandLineRunner init(TaskRepository taskRepository) {
        return args -> {
            log.info("Load... " + taskRepository.save(new Task("Read through code", "Completed")));
            log.info("Load... " + taskRepository.save(new Task("Perform tasks", "Completed")));
            log.info("Load... " + taskRepository.save(new Task("Present solution", "Open")));
        };
    }
}
