package com.example.javaweek93;

import java.io.Serializable;

public class User implements Serializable {
    private String firstName;
    private String lastName;
    private String email;
    private String degreeProgram;
    private String accomplishment;

    private int image;



    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public String getEmail(){
        return email;
    }

    public String getDegreeProgram(){
        return degreeProgram;
    }

    public int getImage() {
        return image;
    }

    public String getAccomplishment(){return accomplishment;}

    public User (String firstName, String lastName, String email, String degreeProgram, int image, String accomplishment){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.degreeProgram = degreeProgram;
        this.image = image;
        this.accomplishment = accomplishment;
    }

}
