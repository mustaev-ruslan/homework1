package ru.aaxee.spring.homework1.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.boot.test.context.SpringBootTest;
import ru.aaxee.spring.homework1.entity.QuizQuestion;
import ru.aaxee.spring.homework1.entity.QuizResult;
import ru.aaxee.spring.homework1.service.fake.NoI18n;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@SpringBootTest
class ConsoleQuizServiceTest {

    @Spy
    NoI18n i18n;

    @Captor
    ArgumentCaptor<String> writeCaptor;

    @Mock
    InOutService inOutService;

    @InjectMocks
    ConsoleQuizService quizService;

    @Test
    @DisplayName("Run quiz")
    void run() {
        when(inOutService.read()).thenReturn("Ответ 1", "Ответ2");

        List<QuizQuestion> quizQuestions = new ArrayList<>();
        quizQuestions.add(new QuizQuestion("Вопрос1", "Ответ1"));
        quizQuestions.add(new QuizQuestion("Вопрос2", "Ответ2"));

        QuizResult result = quizService.run(quizQuestions, 3);

        assertThat(result).isNotNull();
        assertThat(result.getQuestionsCount()).isEqualTo(2);
        assertThat(result.getCorrectAnswersCount()).isEqualTo(1);
        verify(inOutService, times(3)).write(writeCaptor.capture());
        assertThat(writeCaptor.getAllValues().get(0)).contains("Attention");
    }
}