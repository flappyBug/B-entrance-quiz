package com.thoughtworks.capability.gtb.entrancequiz.domain;

import java.util.List;

public class StudentGroup {
    private String name;
    private List<Student> student;

    public StudentGroup(String name, List<Student> student) {
        this.name = name;
        this.student = student;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudent() {
        return student;
    }

    public void setStudent(List<Student> student) {
        this.student = student;
    }
}
