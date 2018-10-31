package me.jun.web.mvc.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SampleController {

    @GetMapping("helloworld")
    public String helloWorld(Model model){

        model.addAttribute("name","jun");


        return "hello";
    }
}
