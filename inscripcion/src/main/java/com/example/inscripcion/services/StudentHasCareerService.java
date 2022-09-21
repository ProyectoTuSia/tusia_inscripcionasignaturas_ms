package com.example.inscripcion.services;

import com.example.inscripcion.models.StudentHasCareerModel;
import com.example.inscripcion.repositories.StudentHasCareerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StudentHasCareerService {

    @Autowired
    StudentHasCareerRepository studentHasCareerRepository;

    public ArrayList<StudentHasCareerModel> findStudentCareers(String username){
        return studentHasCareerRepository.findStudentCareers(username);
    }

    public boolean insertIntoStudentHasCareer(String student_username, Integer career_code){
        try{
            studentHasCareerRepository.insertIntoStudentHasCareer(student_username,career_code);
            return true;
        }catch(Exception err){
            return false;
        }
    }

    public boolean deleteStudentHasCareer(String student_username, Integer career_code){
        int result = studentHasCareerRepository.deleteStudentHasCareer(student_username,career_code);
        if(result>0){
            return true;
        }else{
            return false;
        }
    }
}
