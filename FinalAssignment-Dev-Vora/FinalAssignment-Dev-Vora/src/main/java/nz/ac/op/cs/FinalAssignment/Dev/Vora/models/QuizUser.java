package nz.ac.op.cs.FinalAssignment.Dev.Vora.models;
/*
* This is used to capture all the details of the user
*/

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="quiz_user")
public class QuizUser {
    @Id
    String id;
    String name;
    String address;


    public QuizUser(){

    }

    public QuizUser(String id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
