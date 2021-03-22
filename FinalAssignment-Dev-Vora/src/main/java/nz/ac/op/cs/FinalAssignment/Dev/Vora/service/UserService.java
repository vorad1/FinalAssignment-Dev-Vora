package nz.ac.op.cs.FinalAssignment.Dev.Vora.service;

/*
 * This is the UserService class where all the code for its controller is written
 */

import nz.ac.op.cs.FinalAssignment.Dev.Vora.db.QuizUserRepository;
import nz.ac.op.cs.FinalAssignment.Dev.Vora.models.QuizUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private QuizUserRepository userRepository;


    public List<QuizUser> getAllQuizUsers(){
        List<QuizUser> users = new ArrayList<QuizUser>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    public QuizUser getQuizUser(String id){
        return userRepository.findById(id).get();
    }

    public void addQuizUser(QuizUser user){
        userRepository.save(user);
    }

    public void updateQuizUser(QuizUser user){
        userRepository.save(user);
    }

    public void deleteQuizUser(String id){
        userRepository.deleteById(id);
    }

}
