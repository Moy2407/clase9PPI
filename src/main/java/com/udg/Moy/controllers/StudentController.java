package com.udg.Moy.controllers;

import com.udg.Moy.models.StudentModel;
import com.udg.Moy.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/students") //localhost:8080/
public class StudentController {
    @Autowired
    StudentService studentService;
    @GetMapping
    public ArrayList<StudentModel> getAllStudents(){
        return studentService.getAllStudents();
    }

    @PostMapping
    public StudentModel saveStudent(@RequestBody StudentModel student){
        return studentService.saveStudent(student);
    }

    @GetMapping("/{id}")
    public Optional<StudentModel> findById(@PathVariable Long id){
        return studentService.findById(id);
    }

    @PutMapping
    public StudentModel editStudent(StudentModel studentModel){
        return studentService.saveStudent(studentModel);
    }


    @DeleteMapping("/{id}")
    public String deleteStudentById(@PathVariable Long id){
        return studentService.deleteStudent(id);
    }

    //search by code
    @GetMapping("/{code}")//localhost:8080/students/{code}
    public Optional<StudentModel> findByCode(@RequestParam("code")String code){
        return studentService.findByCode(code);
    }
    //search by name
    //@GetMapping("/{name}")//localhost:8080/students/{name}
    //public ArrayList<StudentModel> findByName(@RequestParam("name")String name){
    //    return studentService.findByName(name);
    //}


}