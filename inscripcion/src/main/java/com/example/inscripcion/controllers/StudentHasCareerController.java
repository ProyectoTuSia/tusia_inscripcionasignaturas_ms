package com.example.inscripcion.controllers;

import com.example.inscripcion.models.StudentHasCareerDTO;
import com.example.inscripcion.models.StudentHasCareerModel;
import com.example.inscripcion.services.StudentHasCareerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/studenthascareer")
public class StudentHasCareerController {
    @Autowired
    StudentHasCareerService studentHasCareerService;

    @GetMapping("/{username}")
    public ArrayList<StudentHasCareerModel> findStudentCareers(@PathVariable("username") String username){
        return studentHasCareerService.findStudentCareers(username);
    }

    @PostMapping()
    public String insertIntoStudentHasCareer(@RequestBody StudentHasCareerDTO studentHasCareerDTO){
        boolean ok = studentHasCareerService.insertIntoStudentHasCareer(studentHasCareerDTO.getStudent_username(),studentHasCareerDTO.getCareer_code());
        if (ok){
            return "The student has related to the career";
        }else{
            return "The student could not be related to the career or was already related to the career";
        }
    }

    @DeleteMapping("/{username}/{career}")
    public String deleteStudentHasCareer(@PathVariable("username") String student_username, @PathVariable("career") Integer career_code){
        boolean ok = studentHasCareerService.deleteStudentHasCareer(student_username,career_code);
        if(ok){
            return "Register was deleted";
        }else{
            return "The indicated register did not exist in the database";
        }
    }
}

