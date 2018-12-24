package ru.aaxee.spring.homework1.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.aaxee.spring.homework1.entity.Student;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ConsoleStudentServiceTest {

    @Test
    @DisplayName("Имя-фамилия")
    void getStudent() {
        List<String> input = new LinkedList<>(Arrays.asList("Petrov", "Ivan"));
        InOutService inOutService = new FakeInOutService(input, new LinkedList<>());
        StudentService studentService = new ConsoleStudentService(inOutService, new NoI18n());

        Student student = studentService.getStudent();

        assertThat(student)
                .isNotNull()
                .hasFieldOrPropertyWithValue("firstName", "Ivan")
                .hasFieldOrPropertyWithValue("lastName", "Petrov");
    }
}