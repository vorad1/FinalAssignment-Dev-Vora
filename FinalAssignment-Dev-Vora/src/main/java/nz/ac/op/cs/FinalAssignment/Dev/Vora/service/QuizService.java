package nz.ac.op.cs.FinalAssignment.Dev.Vora.service;

/*
 * This is the QuizService class where all the code for its controller is written
 */

import nz.ac.op.cs.FinalAssignment.Dev.Vora.db.QuizRepository;
import nz.ac.op.cs.FinalAssignment.Dev.Vora.models.Quiz;
import nz.ac.op.cs.FinalAssignment.Dev.Vora.models.QuizUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuizService {

    @Autowired
    private QuizRepository quizRepository;


    public void createQuiz(QuizUser quizUser, Integer amount){
        Quiz quiz = new Quiz();
        quiz.setStart_date("16 March 2021");
        quiz.setAmount(amount);
        quiz.setUser(quizUser);

        quizRepository.save(quiz);
    }

    public List<Quiz> getAllQuizzs(){
        List<Quiz> quizzes = new ArrayList<Quiz>();
        quizRepository.findAll().forEach(quizzes::add);
        return quizzes;
        //return quizUsers;
    }

    public Quiz getQuiz(Long id) {
        return quizRepository.findById(id).get();
    }
    public void deleteQuiz(Long id){
        quizRepository.deleteById(id);
    }
}
