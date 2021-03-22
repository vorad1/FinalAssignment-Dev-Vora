package nz.ac.op.cs.FinalAssignment.Dev.Vora.models;

/*
 * This is our Database for our MyQuiz class that will enable us to store the questions and the options for
 * a particular quiz in here
 */

import javax.persistence.*;
import java.util.List;
@Entity
public class MyQuiz {
    /*
     * The Primary key, in this case the Id will be generated automatically to make sure no two primary keys match
     */
    @Id
    @GeneratedValue( strategy= GenerationType.AUTO )
    Long id;
    String start_date;
    Integer amount;
    /*
     * We are using a relationship here to call the users from the users class
     */
    @ManyToOne
    QuizUser user;

    /*
     * We are using a relationship here to call the Questions for the quiz from the questions class
     * */
    @OneToMany( targetEntity=Question.class )
    private List<Question> questions;

    public MyQuiz(){
    }


    public MyQuiz(Long id, String start_date, Integer amount) {
        this.id = id;
        this.start_date = start_date;
        this.amount = amount;
    }

    /*
     * Generating getters and setters for all the fields
     */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public QuizUser getUser() {
        return user;
    }

    public void setUser(QuizUser user) {
        this.user = user;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}
