package me.config;

import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;

@Spring5Test
@WebAppConfiguration
public class SpringBeanTest {

  @Autowired
  WebApplicationContext applicationContext;

  @Test
  void print_all_spring_beans(){
    Arrays.stream(applicationContext.getBeanDefinitionNames()).forEach((name)->{
      System.out.println(applicationContext.getBean(name).getClass());
    });
  }
}
