package ru.aaxee.spring.homework1.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.aaxee.spring.homework1.entity.QuizQuestion;
import ru.aaxee.spring.homework1.entity.QuizResult;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

class ConsoleQuizServiceTest {

    @Test
    @DisplayName("Run quiz")
    void run() {
        List<String> input = new LinkedList<>(Arrays.asList("Ответ1", "Не ответ"));
        List<String> output = new LinkedList<>();
        InOutService inOutService = new FakeInOutService(input, output);
        QuizService quizService = new ConsoleQuizService(inOutService);
        List<QuizQuestion> quizQuestions = new ArrayList<>();
        quizQuestions.add(new QuizQuestion("Вопрос1", "Ответ1"));
        quizQuestions.add(new QuizQuestion("Вопрос2", "Ответ2"));

        QuizResult result = quizService.run(quizQuestions, 3);

        assertThat(result).isNotNull();
        assertThat(result.getQuestionsCount()).isEqualTo(2);
        assertThat(result.getCorrectAnswersCount()).isEqualTo(1);
        assertThat(output.get(0)).contains("Внимание!");
    }
}