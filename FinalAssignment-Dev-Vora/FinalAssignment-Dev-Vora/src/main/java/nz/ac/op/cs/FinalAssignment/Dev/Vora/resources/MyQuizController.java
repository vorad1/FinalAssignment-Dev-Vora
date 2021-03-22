package nz.ac.op.cs.FinalAssignment.Dev.Vora.resources;

/*
* This is the MyQuizController class which handles all the request methods
*/

import com.fasterxml.jackson.core.JsonProcessingException;
import nz.ac.op.cs.FinalAssignment.Dev.Vora.models.MyQuiz;
import nz.ac.op.cs.FinalAssignment.Dev.Vora.models.MyQuizParam;
import nz.ac.op.cs.FinalAssignment.Dev.Vora.service.MyQuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyQuizController {
    //The @Autowired annotation can be used to autowire bean on the setter method just like @Required annotation,
    // constructor, a property or methods with arbitrary names and/or multiple arguments.
    @Autowired
    private MyQuizService myQuizService;
    //@GetMapping annotated methods handle the HTTP GET requests matched with given URI expression.
    @GetMapping("/myquiz")
    public List<MyQuiz> getQuiz(){
        return myQuizService.getAllQuiz();
    }
    //@GetMapping annotated methods handle the HTTP GET requests matched with given URI expression.
    @GetMapping("/myquiz/{id}")
    public MyQuiz getQuiz(@PathVariable Long id)
    {
        return myQuizService.getQuiz(id);
    }
    //@PostMapping annotated methods handle the HTTP POST requests matched with given URI expression.
    @PostMapping("/myquiz")
    public void addQuiz(@RequestBody MyQuizParam quizParam) throws JsonProcessingException {
        myQuizService.createQuiz(quizParam);
    }
    //@DeleteMapping annotated methods handle the HTTP POST requests matched with given URI expression.
    @DeleteMapping("/myquiz/{id}")
    public void deleteQuiz(@PathVariable Long id){
        myQuizService.deleteQuiz(id);
    }

}
