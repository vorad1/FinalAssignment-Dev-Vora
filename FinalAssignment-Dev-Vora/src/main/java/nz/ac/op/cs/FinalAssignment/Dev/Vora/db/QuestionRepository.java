package nz.ac.op.cs.FinalAssignment.Dev.Vora.db;
/*
 * This is our Database for our Question class that will enable us to store the questions
 * that will be called from the OpenTDB API
 *
 */

import nz.ac.op.cs.FinalAssignment.Dev.Vora.models.Question;
import org.springframework.data.repository.CrudRepository;

public interface QuestionRepository extends CrudRepository<Question, Long> {
}
