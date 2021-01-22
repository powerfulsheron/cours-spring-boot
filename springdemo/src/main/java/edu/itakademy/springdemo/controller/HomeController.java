package edu.itakademy.springdemo.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore
@Controller
public class HomeController {

//    @GetMapping("/")
//    public String index() {
//        return "hello";
//    }
    
    @RequestMapping("/home")
    public String home(Map<String, Object> model) {
        model.put("message", "Hey");
        return "welcome";
    }

}
 