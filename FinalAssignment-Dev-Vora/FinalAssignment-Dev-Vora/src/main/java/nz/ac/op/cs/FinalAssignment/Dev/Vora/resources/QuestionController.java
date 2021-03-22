package nz.ac.op.cs.FinalAssignment.Dev.Vora.resources;

/*
 * This is the QuestionController class which handles all the request methods
 */

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import nz.ac.op.cs.FinalAssignment.Dev.Vora.models.Question;
import nz.ac.op.cs.FinalAssignment.Dev.Vora.models.QuizResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
//Spring RestController annotation is used to create RESTful web services using Spring MVC.
// Spring RestController takes care of mapping request data to the defined request handler method
@RestController
public class QuestionController {
    //The @Autowired annotation can be used to autowire bean on the setter method just like @Required annotation,
    // constructor, a property or methods with arbitrary names and/or multiple arguments.
    @Autowired
    private RestTemplate restTemplate;

    //@GetMapping annotated methods handle the HTTP GET requests matched with given URI expression.
    @GetMapping("/questions")
    public String getQuestions(){
        String url ="https://opentdb.com/api.php?amount=10&category=9&difficulty=easy&type=multiple";
        String jsonRes = restTemplate.getForObject(url,String.class);
        return jsonRes;

    }
    //@GetMapping annotated methods handle the HTTP GET requests matched with given URI expression.
    @GetMapping("/questions/{count}")
    public String getQuestions(@PathVariable("count") String count){
        String url ="https://opentdb.com/api.php?amount="+count +"&category=9&difficulty=easy&type=multiple";
        String jsonRes = restTemplate.getForObject(url,String.class);
        return jsonRes;

    }
    //@GetMapping annotated methods handle the HTTP GET requests matched with given URI expression.
    @GetMapping("/qlist")
    public List<Question> getQuestionsList() throws JsonProcessingException {
        //Task
        //Make external API call to OpenTDB
        //Get JSON response
        //Parse JSON response and read JSON List
        String url ="https://opentdb.com/api.php?amount="+10 +"&category=9&difficulty=easy&type=multiple";
        String jsonRes = restTemplate.getForObject(url,String.class);
        System.out.println(jsonRes);
        ObjectMapper mapper = new ObjectMapper();
        QuizResponse quizResponse = mapper.readValue(jsonRes,QuizResponse.class);
        System.out.println(quizResponse.getResults().size());
        //return  JSON List

        return quizResponse.getResults();
    }
    //@GetMapping annotated methods handle the HTTP GET requests matched with given URI expression.
    @GetMapping("/qlist2")
    public List<Question> getQuestionsList2() throws JsonProcessingException {
        //Task
        //Make external API call to OpenTDB
        //Get JSON response
        //Parse JSON response and read JSON List
        String url ="https://opentdb.com/api.php?amount="+10 +"&category=9&difficulty=easy&type=multiple";
        String jsonRes = restTemplate.getForObject(url,String.class);

        String questions = jsonRes.substring(29, jsonRes.length()-1);
        System.out.println(jsonRes);
        System.out.println(questions);
        ObjectMapper mapper = new ObjectMapper();

        List<Question> questionsList = mapper.readValue(questions,new TypeReference<List<Question>>(){});
        //System.out.println(quizResponse.getResults().size());
        //return  JSON List

        return questionsList;
    }

}
