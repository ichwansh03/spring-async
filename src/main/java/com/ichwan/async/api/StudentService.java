package com.ichwan.async.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author Ichwan
 * Pada reactive, Flux<> digunakan untuk menampung list, jika single object gunakan Mono<>
 */
@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public Flux<Student> getAll() {
        return studentRepository.findAll();
    }

    public Mono<Student> getById(Long id){
        return studentRepository.findById(id);
    }

    public Mono<Student> create(StudentRequest request){
        return studentRepository.save(Student.builder()
                .firstname(request.firstname())
                .lastname(request.lastname())
                .age(request.age())
                .build());
    }

    public Mono<Student> update(Long id, StudentRequest request){
        return studentRepository.findById(id)
                .map(student -> {
                    student.setFirstname(request.firstname());
                    student.setLastname(request.lastname());
                    student.setAge(request.age());
                    return student;
                })
                .flatMap(studentRepository::save);
    }

    public Flux<Student> getByFirstname(String firstname){
        return studentRepository.findAllByFirstnameIgnoreCase(firstname);
    }

    public Mono<Void> delete(Long id){
        return studentRepository.deleteById(id);
    }
}
