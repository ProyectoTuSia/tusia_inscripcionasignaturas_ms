package com.example.inscripcion.models;

import java.io.Serializable;
import java.util.Objects;

public class PKCareerHasSubject implements Serializable {

    private CareerModel career;
    private SubjectModel subject;

    public PKCareerHasSubject() {
    }

    public PKCareerHasSubject(CareerModel career, SubjectModel subject) {
        this.career = career;
        this.subject = subject;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PKCareerHasSubject that)) return false;
        return career.equals(that.career) && subject.equals(that.subject);
    }

    @Override
    public int hashCode() {
        return Objects.hash(career, subject);
    }

    public CareerModel getCareer() {
        return career;
    }

    public void setCareer(CareerModel career) {
        this.career = career;
    }

    public SubjectModel getSubject() {
        return subject;
    }

    public void setSubject(SubjectModel subject) {
        this.subject = subject;
    }
}

