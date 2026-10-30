package com.example.studentscourses.service;

import com.example.studentscourses.dto.StudentDto;
import com.example.studentscourses.entity.Enrollment;
import com.example.studentscourses.entity.Student;
import com.example.studentscourses.repository.EnrollmentRepository;
import com.example.studentscourses.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final EnrollmentRepository enrollmentRepository;

    public StudentService(StudentRepository studentRepository,
                          EnrollmentRepository enrollmentRepository) {
        this.studentRepository = studentRepository;
        this.enrollmentRepository = enrollmentRepository;
    }

    public List<StudentDto> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        List<StudentDto> result = new ArrayList<>();
        for (Student s : students) {
            StudentDto dto = new StudentDto();
            dto.setId(s.getId());
            dto.setFullName(s.getFullName());
            dto.setEmail(s.getEmail());
            dto.setGroupName(s.getGroupName());
            result.add(dto);
        }
        return result;
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public void enrollStudent(Long studentId, Long courseId) {
        Student student = studentRepository.findById(studentId).orElse(null);
        if (student == null) {
            throw new RuntimeException("Student not found");
        }
        Enrollment enrollment = new Enrollment();
        enrollment.setStudent(student);
        enrollment.setCourse(null);
        enrollmentRepository.save(enrollment);
    }

    public Double calculateAverageGrade(Long studentId) {
        List<Enrollment> enrollments = enrollmentRepository.findByStudentId(studentId);
        double sum = 0;
        int count = 0;
        for (Enrollment e : enrollments) {
            if (e.getGrade() != null) {
                sum += e.getGrade();
                count++;
            }
        }
        if (count == 0) return 0.0;
        return sum / count;
    }
}
