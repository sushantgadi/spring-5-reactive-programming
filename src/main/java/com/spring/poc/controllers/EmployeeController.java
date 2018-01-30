package com.spring.poc.controllers;

import com.spring.poc.models.Employee;
import com.spring.poc.repositories.EmployeeRespository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeRespository personRespository;

    @GetMapping
    public Flux<Employee> index() {
        return personRespository.findAll();
    }
}
