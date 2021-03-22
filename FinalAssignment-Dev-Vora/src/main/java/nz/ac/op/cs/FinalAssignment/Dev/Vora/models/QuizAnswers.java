package nz.ac.op.cs.FinalAssignment.Dev.Vora.models;

/*
* This is used to get the answers that the user will give while taking the quiz
*/
import java.util.List;

public class QuizAnswers {
    String userId;
    Long quizId;
    List<UserAnswer> answers;

    public QuizAnswers() {

    }

    public QuizAnswers(String userId, Long quizId, List<UserAnswer> answers)  {
        this.userId = userId;
        this.quizId = quizId;
        this.answers = answers;
    }

    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Long getQuizId() {
        return quizId;
    }
    public void setQuizId(Long quizId) {
        this.quizId = quizId;
    }

    public List<UserAnswer> getAnswers() {
        return answers;
    }
    public void setAnswers(List<UserAnswer> answers) {
        this.answers = answers;
    }

}


