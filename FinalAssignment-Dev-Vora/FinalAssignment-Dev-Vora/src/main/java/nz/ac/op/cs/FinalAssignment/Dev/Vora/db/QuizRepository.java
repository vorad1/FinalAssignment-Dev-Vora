package nz.ac.op.cs.FinalAssignment.Dev.Vora.db;

/*
 * This is our Database for our quiz class that will enable us to store the questions and the options for
 * a particular quiz in here
 *
 * Each Quiz will have it's own unique Id that will be used to store as the primary key and keep all the details of the quiz
 *
 * */

import nz.ac.op.cs.FinalAssignment.Dev.Vora.models.Quiz;
import org.springframework.data.repository.CrudRepository;

public interface QuizRepository extends CrudRepository<Quiz,Long> {
}
