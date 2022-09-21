package com.example.inscripcion.services;

import com.example.inscripcion.models.SubjectGroupModel;
import com.example.inscripcion.repositories.SubjectGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class SubjectGroupService {

    @Autowired
    SubjectGroupRepository subjectGroupRepository;

    public ArrayList<SubjectGroupModel> findAllSubjectGroups(){
        return (ArrayList<SubjectGroupModel>) subjectGroupRepository.findAll();
    }

    public boolean insertSubjectGroup(int number, int slots, int subject_code){
        try{
            subjectGroupRepository.insertSubjectGroup(number, slots, subject_code);
            return true;
        }catch(Exception err){
            return false;
        }
    }

    public SubjectGroupModel findGroupOfSubject(int number, int subject_code){
        ArrayList<SubjectGroupModel> result = subjectGroupRepository.findSubjectGroupByNumberAndSubjectCode(number, subject_code);
        if(result.size() > 0){
            return result.get(0);
        }else{
            return null;
        }
    }

    public ArrayList<SubjectGroupModel> findGroupsOfSubject(int subject_code){
        return subjectGroupRepository.findSubjectGroupBySubjectCode(subject_code);
    }

    public boolean deleteSubjectGroup(int number, int subject_code){
        int result = subjectGroupRepository.deleteSubjectGroup(number,subject_code);
        if(result>0){
            return true;
        }else{
            return false;
        }
    }

}

