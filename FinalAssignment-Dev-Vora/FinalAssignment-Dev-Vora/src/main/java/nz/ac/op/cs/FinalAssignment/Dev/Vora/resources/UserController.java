package nz.ac.op.cs.FinalAssignment.Dev.Vora.resources;

/*
 * This is the UserController class which handles all the request methods
 */

import nz.ac.op.cs.FinalAssignment.Dev.Vora.models.QuizUser;
import nz.ac.op.cs.FinalAssignment.Dev.Vora.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Spring RestController annotation is used to create RESTful web services using Spring MVC.
// Spring RestController takes care of mapping request data to the defined request handler method
@RestController
public class UserController {
    //The @Autowired annotation can be used to autowire bean on the setter method just like @Required annotation,
    // constructor, a property or methods with arbitrary names and/or multiple arguments.
    @Autowired
    private UserService userService;
    //@GetMapping annotated methods handle the HTTP GET requests matched with given URI expression.
    @GetMapping("/users")
    public List<QuizUser> getQuizUsers(){
        return userService.getAllQuizUsers();
    }
    //@GetMapping annotated methods handle the HTTP GET requests matched with given URI expression.
    @GetMapping("/users/{id}")
    public QuizUser getQuizUser(@PathVariable String id){
        return userService.getQuizUser(id);
    }
    //@GetMapping annotated methods handle the HTTP GET requests matched with given URI expression.
    @PostMapping("/users")
    public void addQuizUser(@RequestBody QuizUser quizUser){
        userService.addQuizUser(quizUser);
    }
    //@PutMapping annotated methods handle the HTTP POST requests matched with given URI expression.
    @PutMapping("/users")
    public void updateQuizUser(@RequestBody QuizUser quizUser){
        userService.updateQuizUser(quizUser);
    }
    //@DeleteMapping annotated methods handle the HTTP POST requests matched with given URI expression.
    @DeleteMapping("/users/{id}")
    public void deleteQuizUser(@PathVariable String id){
        userService.deleteQuizUser(id);
    }

}
