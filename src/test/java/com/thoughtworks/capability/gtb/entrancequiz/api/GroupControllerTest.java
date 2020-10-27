package com.thoughtworks.capability.gtb.entrancequiz.api;

import com.thoughtworks.capability.gtb.entrancequiz.service.GroupService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static com.thoughtworks.capability.gtb.entrancequiz.constants.StudentConstants.TOTAL_GROUPS;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class GroupControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    GroupService groupService;

    @BeforeEach
    void setUp() {
        groupService.reset();
    }

    @Test
    void should_get_empty_groups_before_regroup() throws Exception {
        mockMvc.perform(get("/groups"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(0)));
    }

    @Test
    void should_get_fixed_size_groups_after_regroup() throws Exception {
        mockMvc.perform(post("/groups/regroup"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(TOTAL_GROUPS)));
    }
}
