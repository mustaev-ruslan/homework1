package ru.aaxee.spring.homework1.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.aaxee.spring.homework1.entity.Student;
import ru.aaxee.spring.homework1.service.fake.NoI18n;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ConsoleStudentServiceTest {

    @Spy
    NoI18n i18n;

    @Mock
    InOutService inOutService;

    @InjectMocks
    ConsoleStudentService studentService;

    @Test
    @DisplayName("Имя-фамилия")
    void getStudent() {
        when(inOutService.read()).thenReturn("Petrov", "Ivan");

        Student student = studentService.getStudent();

        assertThat(student)
                .isNotNull()
                .hasFieldOrPropertyWithValue("firstName", "Ivan")
                .hasFieldOrPropertyWithValue("lastName", "Petrov");
    }
}