package nz.ac.op.cs.FinalAssignment.Dev.Vora.resources;

/*
 * This is the QuizController class which handles all the request methods
 */

import nz.ac.op.cs.FinalAssignment.Dev.Vora.models.Quiz;
import nz.ac.op.cs.FinalAssignment.Dev.Vora.models.QuizUser;
import nz.ac.op.cs.FinalAssignment.Dev.Vora.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

//Spring RestController annotation is used to create RESTful web services using Spring MVC.
// Spring RestController takes care of mapping request data to the defined request handler method
@RestController
public class QuizController {
    //The @Autowired annotation can be used to autowire bean on the setter method just like @Required annotation,
    // constructor, a property or methods with arbitrary names and/or multiple arguments.
    @Autowired
    private QuizService quizService;
    //@GetMapping annotated methods handle the HTTP GET requests matched with given URI expression.
    @GetMapping("/quiz")
    public List<Quiz> getQuiz(){
        return quizService.getAllQuizzs();
    }
    //@GetMapping annotated methods handle the HTTP GET requests matched with given URI expression.
    @GetMapping("/quiz/{id}")
    public Quiz getQuiz(@PathVariable Long id)
    {
        return quizService.getQuiz(id);
    }
    //@PostMapping annotated methods handle the HTTP POST requests matched with given URI expression.
    @PostMapping("/quiz")
    public void addQuiz(@RequestBody QuizUser quizUser){
        quizService.createQuiz(quizUser, 10);

    }
    //@DeleteMapping annotated methods handle the HTTP POST requests matched with given URI expression.
    @DeleteMapping("/quiz/{id}")
    public void deleteQuizUser(@PathVariable Long id){

        quizService.deleteQuiz(id);
    }
}
