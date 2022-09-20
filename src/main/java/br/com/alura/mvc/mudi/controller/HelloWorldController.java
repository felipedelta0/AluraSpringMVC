package br.com.alura.mvc.mudi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HelloWorldController {

    @GetMapping("/hello")
    public String helloWorld(HttpServletRequest request) {
        request.setAttribute("mensagem", "Hello, World!");
        return "hello-world";
    }
}
