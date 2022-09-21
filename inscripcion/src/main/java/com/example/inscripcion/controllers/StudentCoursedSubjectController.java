package com.example.inscripcion.controllers;

import com.example.inscripcion.models.StudentCoursedSubjectDTO;
import com.example.inscripcion.models.StudentCoursedSubjectModel;
import com.example.inscripcion.services.StudentCoursedSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/studentcoursedsubject")
public class StudentCoursedSubjectController {
    @Autowired
    StudentCoursedSubjectService studentCoursedSubjectService;

    @GetMapping("/{username}")
    public ArrayList<StudentCoursedSubjectModel> findStudentCoursedSubjects(@PathVariable("username") String student_username){
        return studentCoursedSubjectService.findStudentCoursedSubjects(student_username);
    }

    @PostMapping()
    public String insertIntoStudentCoursedSubject(@RequestBody StudentCoursedSubjectDTO studentCoursedSubjectDTO){
        boolean ok = studentCoursedSubjectService.insertIntoStudentCoursedSubject(studentCoursedSubjectDTO.getSubject_code(), studentCoursedSubjectDTO.getStudent_username());
        if(ok){
            return "The student has related to the subject";
        }else{
            return "The student could not be related to the subject or was already related to the subject";
        }
    }

    @DeleteMapping("/{username}/{subject_code}")
    public String deleteStudentCoursedSubject(@PathVariable("subject_code") Integer subject_code, @PathVariable("username") String username){
        boolean ok = studentCoursedSubjectService.deleteFromStudentCoursedSubject(subject_code, username);
        if(ok){
            return "Register was deleted";
        }else{
            return "The indicated register did not exist in the database";
        }
    }

}
