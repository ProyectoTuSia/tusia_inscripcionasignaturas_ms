package com.example.inscripcion.services;

import com.example.inscripcion.models.StudentModel;
import com.example.inscripcion.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public ArrayList<StudentModel> findAllStudents(){
        return (ArrayList<StudentModel>) studentRepository.findAll();
    }

    public StudentModel saveStudent(StudentModel student){
        return studentRepository.save(student);
    }

    public Optional<StudentModel> findByIdStudent(String username){
        return studentRepository.findById(username);
    }

    public boolean deleteByIdStudent(String username){
        try{
            studentRepository.deleteById(username);
            return true;
        }catch(Exception err){
            return false;
        }
    }
}
