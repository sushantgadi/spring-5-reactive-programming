package com.spring.poc.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.spring.poc.models.Employee;

import reactor.core.publisher.Flux;

public interface EmployeeRespository extends ReactiveMongoRepository<Employee, String> {
    Flux<Employee> findByEmpName(String name);
}
