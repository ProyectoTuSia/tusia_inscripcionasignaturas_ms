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
        try{
            //Intentar insertar la lista de grupos del estudiante
            studentHasSubjectGroupService.insertIntoStudentHasSubjectGroup(listStudentHasSubjectGroupDTO);
            return true;
        }catch(Exception err){
            //No se pudo realizar la insercion de la lista de grupos del estudiante
            return false;
        }
    }

    @DeleteMapping()
    public Boolean deleteStudentHasSubjectGroup(@RequestBody ArrayList<StudentHasSubjectGroupDTO> listStudentHasSubjectGroupDTO){
        try {
            //Intentar borrar una lista de grupos del estudiante
            studentHasSubjectGroupService.deleteStudentHasSubjectGroup(listStudentHasSubjectGroupDTO);
            return true;
        }catch(Exception err){
            //Se intento eliminar un estudiante de un grupo en el que no estaba
            return false;
        }
    }
}

