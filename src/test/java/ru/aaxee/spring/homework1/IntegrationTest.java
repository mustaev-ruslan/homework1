package ru.aaxee.spring.homework1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import ru.aaxee.spring.homework1.entity.*;
import ru.aaxee.spring.homework1.exception.QuizException;
import ru.aaxee.spring.homework1.service.*;
import ru.aaxee.spring.homework1.service.fake.NoI18n;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@SpringBootTest
class IntegrationTest {

    @TestConfiguration
    static class TestConfig {
        @Bean
        I18n i18n() {
            return new NoI18n();
        }
    }

    @MockBean
    QuizLoaderService quizLoaderService;

    @MockBean
    InOutService inOutService;

    @Captor
    ArgumentCaptor<String> writeCaptor;

    @Autowired
    ConsoleStudentService studentService;

    @Autowired
    ConsoleQuizService quizService;

    @Autowired
    ConsoleResultPrintService resultPrintService;

    @Test
    @DisplayName("Интеграция")
    void run() throws QuizException {
        when(quizLoaderService.getQuizQuestionList(anyString())).thenReturn(Arrays.asList(
                new QuizQuestion("q1", "a1"),
                new QuizQuestion("q2", "a2")
        ));
        when(inOutService.read()).thenReturn("Petrov", "Ivan", "a1", "a2");

        Student student = studentService.getStudent();
        List<QuizQuestion> quizQuestionList = quizLoaderService.getQuizQuestionList("");
        QuizResult quizResult = quizService.run(quizQuestionList, 2);
        resultPrintService.print(student, quizResult);

        verify(inOutService, times(6)).write(writeCaptor.capture());
        assertThat(writeCaptor.getAllValues()).isEqualTo(Arrays.asList(
                "Second name:",
                "First name:",
                "Attention!",
                "q1",
                "q2",
                "Congratulation! Petrov Ivan, Your answered on 2 questions. All count: 2"
        ));
    }
}
