package org.example.Entity;

public class Person {
private int id;
private String FirstName;
private String LastName;
private String email;

public Person(int id, String firstName, String lastName, String email) {
    this.id=id;
    this.FirstName=firstName;
    this.LastName=lastName;
    this.email=email;
}
public Person(String firstName, String lastName) {

    this.FirstName=firstName;
    this.LastName=lastName;
}

    public Person() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }
}
