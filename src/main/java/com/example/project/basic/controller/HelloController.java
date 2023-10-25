package com.example.project.basic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello-template")
    public String helloTemplate(Model model){
        model.addAttribute("name","basic");

        return "basic/hello-template";
    }

    // MVC와 템플릿 엔진
    // 뷰리졸버를 사용함
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name",name);

        return "hello-template";
    }

    // API
    // @ResponseBody 문자 반환
    // 뷰리졸버를 사용하지 않음
    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam String name){
        return "hello" + name;
    }

    // API
    // @ResponseBody 객체 반환
    // 뷰리졸버를 사용하지 않음
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam String name){
        Hello hello = new Hello();
        hello.setName(name);

        return hello;
    }

    static class Hello{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name){
            this.name = name;
        }
    }

}
