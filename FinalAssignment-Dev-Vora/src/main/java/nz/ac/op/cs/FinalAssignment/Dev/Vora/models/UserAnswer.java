package nz.ac.op.cs.FinalAssignment.Dev.Vora.models;

/*
* */

public class UserAnswer {
    Long questionId;
    Integer answer;

    public UserAnswer(Long questionId, Integer answer){
        this.questionId = questionId;
        this.answer = answer;
    }

    public Long getQuestionId() {
        return questionId;
    }
    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public Integer getAnswer() {
        return answer;
    }
    public void setAnswer(Integer answer) {
        this.answer = answer;
    }
}
