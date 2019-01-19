package ru.aaxee.spring.homework1.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.aaxee.spring.homework1.entity.QuizResult;
import ru.aaxee.spring.homework1.entity.Student;
import ru.aaxee.spring.homework1.service.fake.NoI18n;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ConsoleResultPrintServiceTest {

    @Spy
    NoI18n i18n;

    @Captor
    ArgumentCaptor<String> writeCaptor;

    @Mock
    InOutService inOutService;

    @InjectMocks
    ConsoleResultPrintService resultPrintService;

    @Test
    @DisplayName("Printing")
    void print() {
        Student student = new Student("Petrov", "Ivan");
        QuizResult result = new QuizResult(10, 7);

        resultPrintService.print(student, result);

        verify(inOutService, atLeastOnce()).write(writeCaptor.capture());

        assertThat(writeCaptor.getAllValues().get(0))
                .contains("10")
                .contains("7")
                .contains("Petrov")
                .contains("Congratulation")
                .contains("count");
    }
}