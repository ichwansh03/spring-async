package com.ichwan.async.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/students")
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    Mono<Student> save(@RequestBody StudentRequest request){
        return studentService.create(request);
    }

    @GetMapping
    Flux<Student> findAll() {
        return studentService.getAll();
    }

    @GetMapping("/{id}")
    Mono<Student> findById(@PathVariable("id") Long id) {
        return studentService.getById(id);
    }

    @PutMapping("/{id}")
    Mono<Student> update(@PathVariable("id") Long id, @RequestBody StudentRequest request) {
        return studentService.update(id, request);
    }

    @DeleteMapping("/{id}")
    Mono<Void> delete(@PathVariable("id") Long id) {
        return studentService.delete(id);
    }
}
