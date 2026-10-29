package com.tynysbai.studentapi;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    private final StudentRepository repository;

    public StudentController(StudentRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    public Map<String, String> info() {
        return Map.of(
                "application", "Tynysbai Akzhol Student API",
                "student", "Akzhol Tynysbai",
                "group", "IT2-2306",
                "studentId", "38313");
    }

    @GetMapping("/api/students")
    public List<Student> getAll() {
        return repository.findAll();
    }

    @GetMapping("/api/students/{id}")
    public Student getById(@PathVariable("id") Long id) {
        return repository.findById(id).orElse(null);
    }

    @PostMapping("/api/students")
    @ResponseStatus(HttpStatus.CREATED)
    public Student create(@RequestBody Student student) {
        student.setId(null);
        return repository.save(student);
    }

    @DeleteMapping("/api/students/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        repository.deleteById(id);
    }
}
