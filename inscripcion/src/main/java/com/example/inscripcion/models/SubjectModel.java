package com.example.inscripcion.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="subject")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class SubjectModel {

    @Id
    @Column(unique=true, nullable = false)
    private Integer code;

    @Column(nullable = false, length = 60)
    private String name;

    @Column(nullable = false)
    private Integer credits;

    @Column(nullable = false, length = 60)
    private String faculty;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCredits() {
        return credits;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

}

