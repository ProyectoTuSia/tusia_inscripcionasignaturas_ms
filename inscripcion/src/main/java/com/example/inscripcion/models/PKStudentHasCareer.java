package com.example.inscripcion.models;

import java.io.Serializable;
import java.util.Objects;

public class PKStudentHasCareer implements Serializable {

    private StudentModel student;
    private CareerModel career;

    public PKStudentHasCareer() {
    }

    public PKStudentHasCareer(StudentModel student, CareerModel career) {
        this.student = student;
        this.career = career;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PKStudentHasCareer that)) return false;
        return student.equals(that.student) && career.equals(that.career);
    }

    @Override
    public int hashCode() {
        return Objects.hash(student, career);
    }

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


