package com.kelechi.andela.hellobooks.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kelechi.andela.hellobooks.dto.UserDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@WebMvcTest(UsersController.class)
public class SignupControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    private UsersController signupControllerMock;

    @Test
    public void signinUser() {

        try {
            mvc.perform(MockMvcRequestBuilders.post("/api/v1/users/signup")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsBytes(new UserDTO("pards", "fsgsh@ffs.com"))))
                    .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}