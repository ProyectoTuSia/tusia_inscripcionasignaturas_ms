package com.example.inscripcion.models;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name="student_coursed_subject")
@IdClass(PKStudentCoursedSubject.class)
public class StudentCoursedSubjectModel {

    @Id
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "student_username", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private StudentModel student;

    @Id
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "subject_code", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private SubjectModel subject;

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

