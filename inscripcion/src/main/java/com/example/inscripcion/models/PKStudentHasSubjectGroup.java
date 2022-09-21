package com.example.inscripcion.models;

import java.io.Serializable;
import java.util.Objects;

public class PKStudentHasSubjectGroup implements Serializable {

    private StudentModel student;
    private SubjectGroupModel subjectGroup;

    public PKStudentHasSubjectGroup() {
    }

    public PKStudentHasSubjectGroup(StudentModel student, SubjectGroupModel subjectGroup) {
        this.student = student;
        this.subjectGroup = subjectGroup;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PKStudentHasSubjectGroup that)) return false;
        return student.equals(that.student) && subjectGroup.equals(that.subjectGroup);
    }

    @Override
    public int hashCode() {
        return Objects.hash(student, subjectGroup);
    }

    public StudentModel getStudent() {
        return student;
    }

    public void setStudent(StudentModel student) {
        this.student = student;
    }

    public SubjectGroupModel getSubjectGroup() {
        return subjectGroup;
    }

    public void setSubjectGroup(SubjectGroupModel subjectGroup) {
        this.subjectGroup = subjectGroup;
    }
}

