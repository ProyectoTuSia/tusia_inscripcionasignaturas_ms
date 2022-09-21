package com.example.inscripcion.services;

import com.example.inscripcion.models.StudentHasSubjectGroupModel;
import com.example.inscripcion.repositories.StudentHasSubjectGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StudentHasSubjectGroupService {
    @Autowired
    StudentHasSubjectGroupRepository studentHasSubjectGroupRepository;

    public ArrayList<StudentHasSubjectGroupModel> findStudentSubjectGroups(String student_username){
        return studentHasSubjectGroupRepository.findStudentSubjectGroups(student_username);
    }

    public ArrayList<StudentHasSubjectGroupModel> findStudentsInSubjectGroup(Integer group_number, Integer subject_code){
        return studentHasSubjectGroupRepository.findStudentsInSubjectGroup(group_number,subject_code);
    }

    public boolean insertIntoStudentHasSubjectGroup(Integer group_number, Integer subject_code, String username){
        try{
            studentHasSubjectGroupRepository.insertIntoStudentHasSubjectGroup(group_number,subject_code,username);
            return true;
        }catch(Exception err){
            return false;
        }
    }

    public boolean deleteStudentHasSubjectGroup(Integer group_number, Integer subject_code, String username){
        int result = studentHasSubjectGroupRepository.deleteStudentHasSubjectGroup(group_number,subject_code,username);
        if(result>0){
            return true;
        }else{
            return false;
        }
    }
}

