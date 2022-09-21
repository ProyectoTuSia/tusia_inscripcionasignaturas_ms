package com.example.inscripcion.models;

import java.io.Serializable;
import java.util.Objects;

public class PKSubjectGroup implements Serializable {
    private Integer number;
    private SubjectModel subject;

    public PKSubjectGroup() {
    }

    public PKSubjectGroup(Integer number, SubjectModel subject) {
        this.number = number;
        this.subject = subject;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PKSubjectGroup that)) return false;
        return number.equals(that.number) && subject.equals(that.subject);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, subject);
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public SubjectModel getSubject() {
        return subject;
    }

    public void setSubject(SubjectModel subject) {
        this.subject = subject;
    }
}

