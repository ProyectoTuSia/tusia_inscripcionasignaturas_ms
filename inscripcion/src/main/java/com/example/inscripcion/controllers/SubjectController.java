package com.example.inscripcion.controllers;

import com.example.inscripcion.models.SubjectModel;
import com.example.inscripcion.services.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/subject")
public class SubjectController {
    @Autowired
    SubjectService subjectService;

    @GetMapping()
    public ArrayList<SubjectModel> findAllSubjects() {return subjectService.findAllSubjects();}

    @PostMapping()
    public SubjectModel saveSubject(@RequestBody SubjectModel subject){
        return subjectService.saveSubject(subject);
    }

    @GetMapping(path = "/{code}")
    public Optional<SubjectModel> findByIdSubject(@PathVariable("code") Integer code){
        return subjectService.findByIdSubject(code);
    }

    @DeleteMapping(path = "/{code}")
    public String deleteByIdSubject(@PathVariable("code") Integer code){
        boolean ok = subjectService.deleterByIdSubject(code);
        if(ok){
            return "Subject with code "+code+" was deleted";
        }else{
            return "Subject with code "+code+" could not be deleted";
        }
    }
}
