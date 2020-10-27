package com.thoughtworks.capability.gtb.entrancequiz.service;

import com.thoughtworks.capability.gtb.entrancequiz.domain.Student;
import com.thoughtworks.capability.gtb.entrancequiz.domain.StudentGroup;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.thoughtworks.capability.gtb.entrancequiz.constants.StudentConstants.TOTAL_GROUPS;

@Service
public class GroupService {

    final StudentService studentService;
    private final List<StudentGroup> groups = new ArrayList<>();
    private final Random rand = new Random();

    public GroupService(StudentService studentService) {
        this.studentService = studentService;
    }

    public List<StudentGroup> getGroups() {
        return groups;
    }

    private List<Student> popRandomNStudents(List<Student> students, int n) {
        List<Student> poppedStudents = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            int randomIndex = rand.nextInt(students.size());
            poppedStudents.add(students.remove(randomIndex));
        }
        return poppedStudents;
    }

    public List<StudentGroup> regroup() {
        final List<Student> students = new ArrayList<>(studentService.getStudents());
        groups.clear();
        for (int i = 0; i < TOTAL_GROUPS; i++) {
            int remainGroups = TOTAL_GROUPS - i;
            String groupName = String.format("%d 组", remainGroups);
            int groupSize = students.size() / remainGroups;
            List<Student> groupStudents = popRandomNStudents(students, groupSize);
            groups.add(new StudentGroup(groupName, groupStudents));
        }
        return groups;
    }
}
