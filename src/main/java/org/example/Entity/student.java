package org.example.Entity;

public class student extends Person{
    int id;
    boolean active;
    String email;
    public student(String firstName, String lastName, String email) {
        super(firstName, lastName);
        this.email=email;

    }
    public student(String firstName, String lastName) {
        super(firstName,lastName);
       //this.id=id;
    }
    public student() {
        super();

    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean getActive() {
        return active;
    }
}
