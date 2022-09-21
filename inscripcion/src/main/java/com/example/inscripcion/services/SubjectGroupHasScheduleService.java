package com.example.inscripcion.services;

import com.example.inscripcion.models.SubjectGroupHasScheduleModel;
import com.example.inscripcion.repositories.SubjectGroupHasScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class SubjectGroupHasScheduleService {

    @Autowired
    SubjectGroupHasScheduleRepository subjectGroupHasScheduleRepository;

    public boolean insertIntoSubjectGroupHasSchedule(Integer group_number, Integer subject_code, Integer schedule_id){
        try{
            subjectGroupHasScheduleRepository.insertIntoSubjectGroupHasSchedule(group_number,subject_code,schedule_id);
            return true;
        }catch(Exception err){
            return false;
        }
    }

    public ArrayList<SubjectGroupHasScheduleModel> findSchedulesOfGroup(Integer group_number, Integer subject_code){
        return subjectGroupHasScheduleRepository.findSchedulesOfGroup(group_number,subject_code);
    }

    public boolean deleteScheduleFromGroup(Integer group_number, Integer subject_code, Integer schedule_id){
        int result = subjectGroupHasScheduleRepository.deleteScheduleFromGroup(group_number,subject_code,schedule_id);
        if(result>0){
            return true;
        }else{
            return false;
        }
    }
}