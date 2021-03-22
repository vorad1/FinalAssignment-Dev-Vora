package nz.ac.op.cs.FinalAssignment.Dev.Vora.db;


import nz.ac.op.cs.FinalAssignment.Dev.Vora.models.Task;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Task, Integer> {
}
