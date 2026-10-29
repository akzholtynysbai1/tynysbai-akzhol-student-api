package com.tynysbai.studentapi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StudentApiTests {

    @Autowired
    private StudentRepository repository;

    @Test
    void contextLoads() {
    }

    @Test
    void createAndFindStudent() {
        Student saved = repository.save(
                new Student("Akzhol", "Tynysbai", "IT2-2306", "akzhol.tynysbai@example.com"));
        assertNotNull(saved.getId());
        assertEquals("Tynysbai", repository.findById(saved.getId()).orElseThrow().getLastName());
    }
}
