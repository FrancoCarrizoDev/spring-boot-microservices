package com.microservice.course.controllers;


import com.microservice.course.entities.Course;
import com.microservice.course.services.ICourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    private ICourseService courseService;

    public CourseController(ICourseService courseService){
        this.courseService = courseService;
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveStudent(@RequestBody Course course){
        courseService.save(course);
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return ResponseEntity.ok(courseService.findById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAllStudent(){
        return ResponseEntity.ok(courseService.findAll());
    }

    @GetMapping("/search-students/${courseId}")
    public ResponseEntity<?> findStudentsByCourseId(@PathVariable Long courseId){
        return ResponseEntity.ok(courseService.findStudentsByCourseId(courseId));
    };
}
