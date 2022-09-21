package com.example.inscripcion.controllers;

import com.example.inscripcion.models.StudentModel;
import com.example.inscripcion.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping()
    public ArrayList<StudentModel> findAllStudents(){
        return studentService.findAllStudents();
    }

    @PostMapping()
    public StudentModel saveStudent(@RequestBody StudentModel student){
        return studentService.saveStudent(student);
    }

    @GetMapping(path = "/{username}")
    public Optional<StudentModel> findByIdStudent(@PathVariable("username") String username){
        return studentService.findByIdStudent(username);
    }

    @DeleteMapping(path = "/{username}")
    public String deleteByIdStudent(@PathVariable("username") String username){
        boolean ok = studentService.deleteByIdStudent(username);
        if(ok){
            return "Student with username "+username+" was deleted";
        }else{
            return "Student with username "+username+" could not be deleted";
        }
    }
}
