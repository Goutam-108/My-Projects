package com.example.spring_sec_demo;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    List<Student> students = new ArrayList<>(List.of(
            new Student(1,"Jay", "Java"),
            new Student(2,"Jay", "Java"),
            new Student(3,"Jay", "Java"),
            new Student(4,"Jay", "Java")
            ));

        @GetMapping("/students")
    public List<Student> getStudents(){
            return students;
        }

        @GetMapping("/csrf-token")
        public CsrfToken getCsrfToken(HttpServletRequest request){
            return (CsrfToken) request.getAttribute("_csrf");
        }

        @PostMapping("/students")
    public void addStudent(@RequestBody Student student){
            System.out.println(student.getName()+" "+student.getId());
            students.add(student);
        }
}
