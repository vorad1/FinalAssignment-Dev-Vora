package nz.ac.op.cs.FinalAssignment.Dev.Vora.models;
/*
* This is the class where the questions will be stored after calling them from OpenTDB
*/

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.context.annotation.PropertySource;

import javax.persistence.*;
import java.util.List;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Question {
    @Id
    @GeneratedValue( strategy= GenerationType.AUTO )
    Long id;


    String category;
    String type;
    String difficulty;
    String question;
    String correct_answer;
    Integer correctAnsIdx;

    @ElementCollection
    @CollectionTable(name = "answers", joinColumns = @JoinColumn(name = "id")) // 2
    List<String> answers;

    public Question(){

    }

    public Question(Long id, String category, String type, String difficulty, String question, String correct_answer, Integer correctAnsIdx, List<String> answers) {
        this.id = id;
        this.category = category;
        this.type = type;
        this.difficulty = difficulty;
        this.question = question;
        this.correct_answer = correct_answer;
        this.correctAnsIdx = correctAnsIdx;
        this.answers = answers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getCorrect_answer() {
        return correct_answer;
    }

    public void setCorrect_answer(String correct_answer) {
        this.correct_answer = correct_answer;
    }

    public Integer getCorrectAnsIdx() {
        return correctAnsIdx;
    }

    public void setCorrectAnsIdx(Integer correctAnsIdx) {
        this.correctAnsIdx = correctAnsIdx;
    }
    @JsonProperty("answers")
    public List<String> getAnswers() {
        return answers;
    }
    @JsonProperty("incorrect_answers")
    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }
}
