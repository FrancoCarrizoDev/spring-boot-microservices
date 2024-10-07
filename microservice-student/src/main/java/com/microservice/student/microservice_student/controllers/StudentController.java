package com.microservice.student.microservice_student.controllers;

import com.microservice.student.microservice_student.entities.Student;
import com.microservice.student.microservice_student.services.IStudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    private IStudentService studentService;

    public StudentController(IStudentService studentService){
        this.studentService = studentService;
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveStudent(@RequestBody  Student student){
        studentService.save(student);
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return ResponseEntity.ok(studentService.findById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAllStudent(){
        return ResponseEntity.ok(studentService.findAll());
    }


    @GetMapping("/search-by-course/{id}")
    public ResponseEntity<?> findByCourseId(@PathVariable Long id){
        return ResponseEntity.ok(studentService.findByCourseId(id));
    }
}
