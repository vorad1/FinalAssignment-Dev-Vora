package nz.ac.op.cs.FinalAssignment.Dev.Vora.db;

/*
 * This is our Database for all our users that will be enrolled
 *
 * Each User's details will be stored in this database
 *
 * Each User will have their UserId as their primary key
 *
 */

import nz.ac.op.cs.FinalAssignment.Dev.Vora.models.QuizUser;
import org.springframework.data.repository.CrudRepository;

public interface QuizUserRepository  extends CrudRepository<QuizUser, String>{
}
