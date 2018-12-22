package ru.aaxee.spring.homework1.domain.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.aaxee.spring.homework1.domain.entity.Student;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;

class ConsoleStudentServiceTest {

    @Test
    @DisplayName("Имя-фамилия")
    void getStudent() {
        InputStream fakeInput = new ByteArrayInputStream("Petrov\nIvan".getBytes());
        StudentService studentService = new ConsoleStudentService(fakeInput);

        Student student = studentService.getStudent();

        assertThat(student)
                .isNotNull()
                .hasFieldOrPropertyWithValue("firstName", "Ivan")
                .hasFieldOrPropertyWithValue("lastName", "Petrov");
    }
}