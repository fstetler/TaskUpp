package se.uu.ucr.interview.jpa;

import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Task, Long> {
    Task findById(long id);
}
