package ru.aaxee.spring.homework1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import ru.aaxee.spring.homework1.entity.QuizQuestion;
import ru.aaxee.spring.homework1.entity.QuizResult;
import ru.aaxee.spring.homework1.entity.Student;
import ru.aaxee.spring.homework1.exception.QuizException;
import ru.aaxee.spring.homework1.service.*;
import ru.aaxee.spring.homework1.service.fake.NoI18n;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@SpringBootTest
//@ExtendWith(MockitoExtension.class)
class IntegrationTest {

    @Mock
    QuizLoaderService quizLoaderService;

    @Mock
    InOutService inOutService;

    @Spy
    NoI18n i18n;

    @Captor
    ArgumentCaptor<String> writeCaptor;

    @InjectMocks
    ConsoleStudentService studentService;

    @InjectMocks
    ConsoleQuizService quizService;

    @InjectMocks
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
