package com.microservice.course.services;

import com.microservice.course.client.StudentClient;
import com.microservice.course.dto.StudentDTO;
import com.microservice.course.entities.Course;
import com.microservice.course.http.response.StudentByCourseResponse;
import com.microservice.course.repositories.ICourseRepository;

import java.util.List;
import java.util.Optional;

public class CourseServiceImpl implements ICourseService{

    private ICourseRepository courseRepository;

    private StudentClient studentClient;

    public CourseServiceImpl (ICourseRepository courseRepository, StudentClient studentClient){
        this.courseRepository= courseRepository;
        this.studentClient = studentClient;
    }

    @Override
    public List<Course> findAll() {
        return (List<Course>) courseRepository.findAll();
    }

    @Override
    public Course findById(Long id) {
        return courseRepository.findById(id).orElseThrow();
    }

    @Override
    public void save(Course course) {
        courseRepository.save(course);
    }

    @Override
    public StudentByCourseResponse findStudentsByCourseId(Long courseId) {

        Course course = courseRepository.findById(courseId).orElseThrow();

        List<StudentDTO> studentDTOList = studentClient.findAllStudentByCourse(courseId);


        return StudentByCourseResponse.builder()
                .courseName(course.getName())
                .teacher(course.getTeacher())
                .studentDTOList(studentDTOList)
                .build();
    }
}
