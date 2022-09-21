package com.example.inscripcion.services;

import com.example.inscripcion.models.CareerHasSubjectModel;
import com.example.inscripcion.repositories.CareerHasSubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CareerHasSubjectService {
    @Autowired
    CareerHasSubjectRepository careerHasSubjectRepository;

    public CareerHasSubjectModel findCareerHasSubjectBySubCodeAndCarCode(Integer subject_code, Integer career_code){
        ArrayList<CareerHasSubjectModel> result = careerHasSubjectRepository.findCareerHasSubjectBySubCodeAndCarCode(subject_code,career_code);
        if(result.size() > 0){
            return result.get(0);
        }else{
            return null;
        }
    }

    public ArrayList<CareerHasSubjectModel> findCareerHasSubjectByTypAndCarCode(String typology, Integer career_code){
        return careerHasSubjectRepository.findCareerHasSubjectByTypAndCarCode(typology,career_code);
    }

    public boolean insertIntoCareerHasSubject(String typology, Integer subject_code, Integer career_code){
        try{
            careerHasSubjectRepository.insertIntoCareerHasSubject(typology,subject_code,career_code);
            return true;
        }catch(Exception err){
            return false;
        }
    }

    public boolean deleteCareerHasSubjectBySubCodeAndCarCode(Integer subject_code, Integer career_code){
        int result = careerHasSubjectRepository.deleteCareerHasSubjectBySubCodeAndCarCode(subject_code,career_code);
        if(result>0){
            return true;
        }else{
            return false;
        }
    }
}