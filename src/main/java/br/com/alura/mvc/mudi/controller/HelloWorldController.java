package br.com.alura.mvc.mudi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloWorldController {

    @GetMapping("/hello")
    public String helloWorld(Model model) {
        model.addAttribute("mensagem", "Hello, World!");
        return "hello-world";
    }
}
