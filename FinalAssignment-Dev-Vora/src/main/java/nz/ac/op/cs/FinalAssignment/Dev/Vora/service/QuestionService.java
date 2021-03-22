package nz.ac.op.cs.FinalAssignment.Dev.Vora.service;

/*
 * This is the QuestionService class where all the code for its controller is written
 */

import nz.ac.op.cs.FinalAssignment.Dev.Vora.db.QuestionRepository;
import nz.ac.op.cs.FinalAssignment.Dev.Vora.models.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepository questionRepository;

    public List<Question> getAllQuestions(){
        List<Question> questions = new ArrayList<Question>();
        questionRepository.findAll().forEach(questions::add);
        return questions;

    }

    public Question getQuestion(Long id){
        return questionRepository.findById(id).get();

    }
    public void addQuestions(List<Question> questions){
        for(Question q:questions){
            questionRepository.save(q);
        }

    }

    public void addQuestion(Question question){
        questionRepository.save(question);
        //quizUsers.add(user);
    }

    public void updateQuestion(Question question){
        questionRepository.save(question);
    }
    public void deleteQuestion(Long id){
        questionRepository.deleteById(id);
    }


}
