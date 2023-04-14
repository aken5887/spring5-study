package me.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

  @GetMapping("/hello")
  public String hello(@RequestParam(value="greeting", defaultValue = "World") String greeting, Model model) {
    model.addAttribute("greeting", greeting);
    return "hello";
  }

  @GetMapping("/greeting")
  @ResponseBody
  public String greeting(@RequestParam(value="greeting", defaultValue = "World") String greeting) {
    return "Hello, "+greeting;
  }
}
