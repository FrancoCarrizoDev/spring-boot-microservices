package com.microservice.student.microservice_student.services;

import com.microservice.student.microservice_student.entities.Student;
import com.microservice.student.microservice_student.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements IStudentService {

    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }


    @Override
    public List<Student> findAll() {

        return (List<Student>) studentRepository.findAll();
    }

    @Override
    public Student findById(Long id) {
        Optional<Student> student = studentRepository.findById(id);
        return student.orElse(null);
    }

    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }

    @Override
    public List<Student> findByCourseId(Long courseId) {
        return studentRepository.findAllByCourseId(courseId);
    }
}
