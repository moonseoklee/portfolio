package com.example.portfolio.controller;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



public class MainTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    Main main;

    @Before
    public void setup(){
        mvc = MockMvcBuilders.standaloneSetup(main).build();
    }

    @Test
    public void root() throws Exception {
        mvc.perform(get("/"))
                .andExpect(status().isOk());

    }
    @Test
    public void downloadImg() throws Exception {
        mvc.perform(get("/download"))
                .andExpect(status().isOk());

    }
}