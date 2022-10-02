package com.example.inscripcion.services;

import com.example.inscripcion.models.StudentHasSubjectGroupDTO;
import com.example.inscripcion.models.StudentHasSubjectGroupModel;
import com.example.inscripcion.models.SubjectGroupModel;
import com.example.inscripcion.repositories.StudentHasSubjectGroupRepository;
import com.example.inscripcion.repositories.SubjectGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
public class StudentHasSubjectGroupService {
    @Autowired
    StudentHasSubjectGroupRepository studentHasSubjectGroupRepository;

    @Autowired
    SubjectGroupRepository subjectGroupRepository;

    public ArrayList<StudentHasSubjectGroupModel> findStudentSubjectGroups(String student_username){
        return studentHasSubjectGroupRepository.findStudentSubjectGroups(student_username);
    }

    public ArrayList<StudentHasSubjectGroupModel> findStudentsInSubjectGroup(Integer group_number, Integer subject_code){
        return studentHasSubjectGroupRepository.findStudentsInSubjectGroup(group_number,subject_code);
    }

    //Hacer una transaccion, de manera que las querys se hagan como una transacción
    @Transactional
    public boolean insertIntoStudentHasSubjectGroup(ArrayList<StudentHasSubjectGroupDTO> list){
        try{
            //Intentar realizar la insercion de todas las materias para el estudiante
            for(int i = 0; i < list.size();i++) {
                //QUERY general para la inscripcion de una lista de asignaturas a un estudiante
                //Obtener informacion del grupo
                SubjectGroupModel subjectGroupInfo = subjectGroupRepository.findSubjectGroupByNumberAndSubjectCode(list.get(i).getSubject_group_number(),list.get(i).getSubject_group_subject_code()).get(0);
                //Verificar que la cantidad de cupos sea mayor a cero
                if(subjectGroupInfo.getSlots() > 0){
                    //Si hay cupos, entonces intentar inscribirlo
                    studentHasSubjectGroupRepository.insertIntoStudentHasSubjectGroup(list.get(i).getSubject_group_number(),list.get(i).getSubject_group_subject_code(),list.get(i).getStudent_username());

                    //Si se logro inscribirlo entonces reducir 1 cupo de la asignatura
                    subjectGroupRepository.decreaseOneSubjectGroupSlots(list.get(i).getSubject_group_number(),list.get(i).getSubject_group_subject_code());
                }else{
                    //Si no hay cupos entonces lanzar una excepcion para cancelar insercion
                    throw new RuntimeException();
                }
            }
        }catch(Exception err){
            return false;
        }
        //Si fue correcto entonces retornar true
        return true;
    }

    public boolean deleteStudentHasSubjectGroup(Integer group_number, Integer subject_code, String username){
        int result = studentHasSubjectGroupRepository.deleteStudentHasSubjectGroup(group_number,subject_code,username);
        if(result>0){
            return true;
        }else{
            return false;
        }
    }
}

