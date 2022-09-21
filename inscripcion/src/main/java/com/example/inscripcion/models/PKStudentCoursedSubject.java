package com.example.inscripcion.models;

import java.io.Serializable;
import java.util.Objects;

public class PKStudentCoursedSubject implements Serializable {

    private StudentModel student;
    private SubjectModel subject;

    public PKStudentCoursedSubject() {
    }

    public PKStudentCoursedSubject(StudentModel student, SubjectModel subject) {
        this.student = student;
        this.subject = subject;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PKStudentCoursedSubject that)) return false;
        return student.equals(that.student) && subject.equals(that.subject);
    }

    @Override
    public int hashCode() {
        return Objects.hash(student, subject);
    }

    public StudentModel getStudent() {
        return student;
    }

    public void setStudent(StudentModel student) {
        this.student = student;
    }

    public SubjectModel getSubject() {
        return subject;
    }

    public void setSubject(SubjectModel subject) {
        this.subject = subject;
    }
}

