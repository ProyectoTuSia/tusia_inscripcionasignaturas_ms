package com.example.inscripcion.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class StudentModel {


    @Id
    @Column(unique=true, nullable = false, length = 60)
    private String username;

    @Column(name = "available_credits")
    private Integer available_credits;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAvailable_credits() {
        return available_credits;
    }

    public void setAvailable_credits(Integer available_credits) {
        this.available_credits = available_credits;
    }
}
