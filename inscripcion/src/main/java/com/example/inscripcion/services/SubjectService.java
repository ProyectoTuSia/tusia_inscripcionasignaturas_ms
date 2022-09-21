package com.example.inscripcion.services;

import com.example.inscripcion.models.SubjectModel;
import com.example.inscripcion.repositories.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class SubjectService {

    @Autowired
    SubjectRepository subjectRepository;

    public ArrayList<SubjectModel> findAllSubjects(){
        return (ArrayList<SubjectModel>) subjectRepository.findAll();
    }

    public SubjectModel saveSubject(SubjectModel subject) { return subjectRepository.save(subject);}

    public Optional<SubjectModel> findByIdSubject(Integer code) {return  subjectRepository.findById(code);}

    public boolean deleterByIdSubject(Integer code){
        try{
            subjectRepository.deleteById(code);
            return true;
        }catch (Exception err){
            return false;
        }
    }
}