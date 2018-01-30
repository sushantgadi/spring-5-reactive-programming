package com.spring.poc.controllers;

import com.spring.poc.models.Employee;
import com.spring.poc.repositories.EmployeeRespository;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;

import static org.springframework.web.reactive.function.server.RequestPredicates.method;
import static org.springframework.web.reactive.function.server.RequestPredicates.path;
import static org.springframework.web.reactive.function.server.RouterFunctions.nest;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Configuration
public class RoutesConfiguration {

    @Bean
    RouterFunction<?> routes(EmployeeRespository personRespository) {
        return nest(path("/employee"),

          route(RequestPredicates.GET("/{id}"),
            request -> ok().body(personRespository.findById(request.pathVariable("id")), Employee.class))

            .andRoute(method(HttpMethod.POST),
              request -> {
                personRespository.insert(request.bodyToMono(Employee.class)).subscribe();
            return ok().build();
        })
        );
    }
}
