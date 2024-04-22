package com.udg.Moy.services;

import com.udg.Moy.models.StudentModel;
import com.udg.Moy.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;
    public StudentModel saveStudent(StudentModel studentModel){
        //call studentById
        if(studentRepository.findStudentModelByCode(studentModel.getCode()).isEmpty()){
            return studentRepository.save(studentModel);
        } else{
            StudentModel studentError = new StudentModel();
            studentError.setId(-1L);
            return studentError;
        }

    }

    public ArrayList<StudentModel> getAllStudents(){
        return (ArrayList<StudentModel>) studentRepository.findAll();
    }

    public Optional<StudentModel> findById(Long id){
        return studentRepository.findById(id);
    }

    public String deleteStudent(Long id){
        Optional<StudentModel> respuesta = studentRepository.findById(id);
        if(respuesta.isPresent()){
            studentRepository.deleteById(id);
            return "student deleted successfully";
        }else{
            return "student not found with id";
        }
    }

    public Optional<StudentModel> findByCode(String code){
        return studentRepository.findByCode(code);
    }

    public StudentModel editById(StudentModel studentModel){
        return studentRepository.save(studentModel);
    }
}
