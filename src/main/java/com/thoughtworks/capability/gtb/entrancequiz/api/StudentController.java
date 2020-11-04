package com.thoughtworks.capability.gtb.entrancequiz.api;

import com.thoughtworks.capability.gtb.entrancequiz.domain.Student;
import com.thoughtworks.capability.gtb.entrancequiz.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// TODO GTB-知识点: - @CrossOrigin避免使用通配符，应指定具体的域名
@RestController
@CrossOrigin(origins = "*")
public class StudentController {

    // TODO GTB-工程实践: - 建议使用private，遵循最小访问原则
    final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // TODO GTB-知识点: - @RestController和ResponseEntity重复
    @GetMapping("/students")
    ResponseEntity<List<Student>> getStudents() {
        return ResponseEntity.ok(studentService.getStudents());
    }

    @PostMapping("/students")
    ResponseEntity<Void> addStudent(@RequestBody Student student) {
        studentService.addStudent(student);
        // TODO GTB-工程实践: - 及时清理无用代码
        //noinspection ConstantConditions
        return ResponseEntity.created(null).build();
    }
}
