package com.thoughtworks.capability.gtb.entrancequiz.service;

import com.thoughtworks.capability.gtb.entrancequiz.domain.Student;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.thoughtworks.capability.gtb.entrancequiz.constants.StudentConstants.INITIAL_STUDENT_NAMES;

@Service
public class StudentService {
    private List<Student> students;

    public StudentService() {
        resetStudents();
    }

    public void resetStudents() {
        students = IntStream.range(0, INITIAL_STUDENT_NAMES.length)
                .mapToObj(index -> new Student(index + 1, INITIAL_STUDENT_NAMES[index]))
                .collect(Collectors.toList());
    }

    public List<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        student.setId(this.students.size() + 1);
        students.add(student);
    }
}
