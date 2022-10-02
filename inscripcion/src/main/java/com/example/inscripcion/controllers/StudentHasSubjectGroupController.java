package com.example.inscripcion.controllers;

import com.example.inscripcion.models.StudentHasSubjectGroupDTO;
import com.example.inscripcion.models.StudentHasSubjectGroupModel;
import com.example.inscripcion.services.StudentHasSubjectGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/studenthassubjectgroup")
public class StudentHasSubjectGroupController {

    @Autowired
    StudentHasSubjectGroupService studentHasSubjectGroupService;

    @GetMapping("/{username}")
    public ArrayList<StudentHasSubjectGroupModel> findStudentSubjectGroups(@PathVariable("username") String username){
        return studentHasSubjectGroupService.findStudentSubjectGroups(username);
    }

    @GetMapping("/{subject_code}/{group_number}")
    public ArrayList<StudentHasSubjectGroupModel> findStudentsInSubjectGroup(@PathVariable("subject_code") Integer subject_code, @PathVariable("group_number") Integer group_number){
        return studentHasSubjectGroupService.findStudentsInSubjectGroup(group_number,subject_code);
    }

    @PostMapping()
    public Boolean insertIntoStudentHasSubjectGroup(@RequestBody ArrayList<StudentHasSubjectGroupDTO> listStudentHasSubjectGroupDTO){
        boolean ok = studentHasSubjectGroupService.insertIntoStudentHasSubjectGroup(listStudentHasSubjectGroupDTO);
        if(ok){
            //El estudiante si se pudo unir, entonces retornar un true
            return true;
        }else{
            //El estudiante no se pudo unir, puede ser que ya estaba o que ya no hay cupos
            return false;
        }
    }

    @DeleteMapping("/{subject_code}/{group_number}/{username}")
    public String deleteStudentHasSubjectGroup(@PathVariable("subject_code") Integer subject_code, @PathVariable("group_number") Integer group_number, @PathVariable("username") String username){
        boolean ok = studentHasSubjectGroupService.deleteStudentHasSubjectGroup(group_number,subject_code,username);
        if(ok){
            return "Register was deleted";
        }else{
            return "The indicated register did not exist in the database";
        }
    }
}

