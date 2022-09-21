package com.example.inscripcion.models;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name="career_has_subject")
@IdClass(PKCareerHasSubject.class)
public class CareerHasSubjectModel {

    @Id
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "career_code", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private CareerModel career;

    @Id
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "subject_code", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private SubjectModel subject;

    @Column(nullable = false, columnDefinition = "ENUM('disciplinar optativa', 'disciplinar obligatoria', 'fundamentacion optativa', 'fundamentacion obligatoria', 'nivelacion', 'libre eleccion', 'trabajo de grado')")
    private String typology;

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

    public String getTypology() {
        return typology;
    }

    public void setTypology(String typology) {
        this.typology = typology;
    }
}

