package com.example.inscripcion.models;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name="student_has_career")
@IdClass(PKStudentHasCareer.class)
public class StudentHasCareerModel {

    @Id
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "student_username", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private StudentModel student;

    @Id
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "career_code", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private CareerModel career;

    public StudentModel getStudent() {
        return student;
    }

    public void setStudent(StudentModel student) {
        this.student = student;
    }

    public CareerModel getCareer() {
        return career;
    }

    public void setCareer(CareerModel career) {
        this.career = career;
    }
}

