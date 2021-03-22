package nz.ac.op.cs.FinalAssignment.Dev.Vora;

import nz.ac.op.cs.FinalAssignment.Dev.Vora.service.MyQuizService;
import nz.ac.op.cs.FinalAssignment.Dev.Vora.service.QuestionService;
import nz.ac.op.cs.FinalAssignment.Dev.Vora.service.QuizService;
import nz.ac.op.cs.FinalAssignment.Dev.Vora.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class FinalAssignmentDevVoraApplication {
	@Bean
	public UserService getUserService() {
		return new UserService();
	}
	@Bean
	public QuestionService getQuestionService(){
		return new QuestionService();
	}
	@Bean
	public QuizService getQuizService(){
		return new QuizService();
	}
	@Bean
	public MyQuizService getMyQuizService(){
		return new MyQuizService();
	}
	@Bean
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(FinalAssignmentDevVoraApplication.class, args);
	}
}
