package com.example.inscripcion.models;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name="student_has_subject_group")
@IdClass(PKStudentHasSubjectGroup.class)
public class StudentHasSubjectGroupModel {

    @Id
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "student_username", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private StudentModel student;

    @Id
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumns({
            @JoinColumn(name="subject_group_number", referencedColumnName="number"),
            @JoinColumn(name="subject_group_subject_code", referencedColumnName="subject_code")
    })
    @OnDelete(action = OnDeleteAction.CASCADE)
    private SubjectGroupModel subjectGroup;

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
