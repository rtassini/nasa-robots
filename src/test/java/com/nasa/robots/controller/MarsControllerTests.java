package com.nasa.robots.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MarsControllerTests {

	@Autowired
    private MockMvc mockMvc;

    @Test
    public void testeDirecaoMMRMMLMM() throws Exception {

        this.mockMvc.perform(get("/rest/mars/MMRMMLMM")).andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$").value("2 4 NORTE"));
    }

    @Test
    public void testeBadRequest() throws Exception {

        this.mockMvc.perform(get("/rest/mars/AAAA")).andDo(print()).andExpect(status().isBadRequest());
    }

}
