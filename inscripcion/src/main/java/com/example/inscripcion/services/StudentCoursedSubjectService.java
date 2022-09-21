package com.example.inscripcion.services;

import com.example.inscripcion.models.StudentCoursedSubjectModel;
import com.example.inscripcion.repositories.StudentCoursedSubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StudentCoursedSubjectService {
    @Autowired
    StudentCoursedSubjectRepository studentCoursedSubjectRepository;

    public ArrayList<StudentCoursedSubjectModel> findStudentCoursedSubjects(String student_username){
        return studentCoursedSubjectRepository.findStudentCoursedSubjects(student_username);
    }

    public boolean insertIntoStudentCoursedSubject(Integer subject_code, String student_username){
        try{
            studentCoursedSubjectRepository.insertIntoStudentCoursedSubject(subject_code,student_username);
            return true;
        }catch(Exception err){
            return false;
        }
    }

    public boolean deleteFromStudentCoursedSubject(Integer subject_code, String student_username){
        int result = studentCoursedSubjectRepository.deleteStudentCoursedSubject(subject_code,student_username);
        if(result>0){
            return true;
        }else{
            return false;
        }
    }
}

