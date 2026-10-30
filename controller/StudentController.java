package com.example.studentscourses.controller;

import com.example.studentscourses.dto.StudentDto;
import com.example.studentscourses.entity.Student;
import com.example.studentscourses.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<StudentDto> getAll() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @PostMapping
    public Student create(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @PostMapping("/{studentId}/enroll/{courseId}")
    public void enroll(@PathVariable Long studentId, @PathVariable Long courseId) {
        studentService.enrollStudent(studentId, courseId);
    }

    @GetMapping("/{id}/average")
    public Double getAverage(@PathVariable Long id) {
        return studentService.calculateAverageGrade(id);
    }
}
