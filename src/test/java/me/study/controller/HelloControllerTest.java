package me.study.controller;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import me.config.Spring5Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

@Spring5Test
@WebAppConfiguration
public class HelloControllerTest {

  @Autowired
  WebApplicationContext webApplicationContext;
  MockMvc mockMvc;

  @BeforeEach
  void before(){
    mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
        .build();
  }

  @Test
  void test_hello() throws Exception {
    mockMvc.perform(get("/hello")
            .param("greeting", "your world"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().string(containsString("your world")));
  }

  @Test
  void test_greeting() throws Exception {
    mockMvc.perform(get("/greeting")
            .param("greeting", "your world"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().string(containsString("your world")));
  }
}