package com.faisal.canteenapp.canteenapp.user;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

public class User {
    private int id;
    @Size(min = 2,message = "name should have atleast two characters")
    private String name;
    private String dep;
    @Past
    private Date date;

    public User() {
    }

    public User(int id, String name, String dep) {
        this.id = id;
        this.name = name;
        this.dep = dep;
        this.date = new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDep() {
        return dep;
    }

    public void setDep(String dep) {
        this.dep = dep;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
