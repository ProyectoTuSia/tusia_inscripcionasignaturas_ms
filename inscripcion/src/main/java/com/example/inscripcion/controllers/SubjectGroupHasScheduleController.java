package com.example.inscripcion.controllers;

import com.example.inscripcion.models.SubjectGroupHasScheduleDTO;
import com.example.inscripcion.models.SubjectGroupHasScheduleModel;
import com.example.inscripcion.services.SubjectGroupHasScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/subjectgrouphasschedule")
public class SubjectGroupHasScheduleController {

    @Autowired
    SubjectGroupHasScheduleService subjectGroupHasScheduleService;

    @PostMapping()
    public String insertIntoSubjectGroupHasSchedule(@RequestBody SubjectGroupHasScheduleDTO subjectGroupHasScheduleDTO){
        boolean ok = subjectGroupHasScheduleService.insertIntoSubjectGroupHasSchedule(subjectGroupHasScheduleDTO.getSubject_group_number(),subjectGroupHasScheduleDTO.getSubject_group_subject_code(),subjectGroupHasScheduleDTO.getSchedule_id());
        if(ok){
            return "The schedule has related to the group";
        }else{
            return "The schedule could not be related to the group or was already related to the group";
        }
    }

    @GetMapping("/{subject_code}/{group_number}")
    public ArrayList<SubjectGroupHasScheduleModel> findSchedulesOfGroup(@PathVariable("subject_code") Integer subject_code, @PathVariable("group_number") Integer group_number){
        return subjectGroupHasScheduleService.findSchedulesOfGroup(group_number,subject_code);
    }

    @DeleteMapping("/{subject_code}/{group_number}/{schedule_id}")
    public String deleteScheduleFromGroup(@PathVariable("subject_code") Integer subject_code, @PathVariable("group_number") Integer group_number, @PathVariable("schedule_id") Integer schedule_id){
        boolean ok = subjectGroupHasScheduleService.deleteScheduleFromGroup(group_number,subject_code,schedule_id);
        if(ok){
            return "Register was deleted";
        }else{
            return "The indicated register did not exist in the database";
        }
    }
}
