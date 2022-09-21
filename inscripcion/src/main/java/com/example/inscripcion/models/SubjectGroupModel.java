package com.example.inscripcion.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;


@Entity
@Table(name="subject_group")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@IdClass(PKSubjectGroup.class)
public class SubjectGroupModel{

    @Id
    @Column(nullable = false)
    private Integer number;

    @Column(nullable = false)
    private Integer slots;

    @Id
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "subject_code", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private SubjectModel subject;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getSlots() {
        return slots;
    }

    public void setSlots(Integer slots) {
        this.slots = slots;
    }

    public SubjectModel getSubject() {
        return subject;
    }

    public void setSubject(SubjectModel subject) {
        this.subject = subject;
    }

}

