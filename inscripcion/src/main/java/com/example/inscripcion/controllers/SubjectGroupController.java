package com.example.inscripcion.controllers;

import com.example.inscripcion.models.SubjectGroupDTO;
import com.example.inscripcion.models.SubjectGroupModel;
import com.example.inscripcion.services.SubjectGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/subjectgroup")
public class SubjectGroupController {

    @Autowired
    SubjectGroupService subjectGroupService;

    @GetMapping()
    public ArrayList<SubjectGroupModel> findAllSubjectGroups(){
        return subjectGroupService.findAllSubjectGroups();
    }

    @PostMapping()
    public String insertSubjectGroup(@RequestBody SubjectGroupDTO subjectGroupDTO){
        boolean ok = subjectGroupService.insertSubjectGroup(subjectGroupDTO.getNumber(), subjectGroupDTO.getSlots(), subjectGroupDTO.getSubject_code());
        if(ok){
            return "Subject Group was inserted";
        }else{
            return "Subject Group could not be inserted";
        }
    }

    @GetMapping("/{subject_code}/{number}")
    public SubjectGroupModel findGroupOfSubject(@PathVariable("number") int number, @PathVariable("subject_code") int subject_code){
        return subjectGroupService.findGroupOfSubject(number, subject_code);
    }

    @GetMapping("/{subject_code}")
    public ArrayList<SubjectGroupModel> findGroupsOfSubject(@PathVariable("subject_code") int subject_code){
        return subjectGroupService.findGroupsOfSubject(subject_code);
    }

    @DeleteMapping("/{subject_code}/{number}")
    public String deleteSubjectGroup(@PathVariable("number") int number, @PathVariable("subject_code") int subject_code){
        boolean ok = subjectGroupService.deleteSubjectGroup(number, subject_code);
        if(ok){
            return "Subject Group was deleted";
        }else{
            return "The indicated group did not exist in the database";
        }
    }
}

