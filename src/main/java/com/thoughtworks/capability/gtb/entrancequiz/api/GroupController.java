package com.thoughtworks.capability.gtb.entrancequiz.api;


import com.thoughtworks.capability.gtb.entrancequiz.domain.StudentGroup;
import com.thoughtworks.capability.gtb.entrancequiz.service.GroupService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class GroupController {
    final GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping("/groups")
    ResponseEntity<List<StudentGroup>> getGroups() {
        return ResponseEntity.ok(groupService.getGroups());
    }

    @PostMapping("/groups/regroup")
    ResponseEntity<List<StudentGroup>> regroup() {
        return ResponseEntity.ok(groupService.regroup());
    }
}
