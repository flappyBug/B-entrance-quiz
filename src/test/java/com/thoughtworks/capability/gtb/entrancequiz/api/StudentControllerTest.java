package com.thoughtworks.capability.gtb.entrancequiz.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.capability.gtb.entrancequiz.service.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static com.thoughtworks.capability.gtb.entrancequiz.constants.StudentConstants.INITIAL_STUDENT_NAMES;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    StudentService studentService;

    @BeforeEach
    void setUp() {
        studentService.resetStudents();
    }

    @Test
    void should_get_initial_student_list() throws Exception {
        ResultActions mockResult = mockMvc.perform(get("/students"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(INITIAL_STUDENT_NAMES.length)));
        for (int i = 0; i < INITIAL_STUDENT_NAMES.length; ++i) {
            mockResult.andExpect(jsonPath("$[" + i + "].name", is(INITIAL_STUDENT_NAMES[i])));
            mockResult.andExpect(jsonPath("$[" + i + "].id", is(i + 1)));
        }
    }

    @Test
    void should_add_student() throws Exception {
        mockMvc.perform(post("/students")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"张三丰\"}"))
                .andExpect(status().isCreated());
        mockMvc.perform(get("/students"))
                .andExpect(jsonPath("$[" + INITIAL_STUDENT_NAMES.length + "].name",
                        is("张三丰")));
    }
}
