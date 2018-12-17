package ru.aaxee.spring.homework1.domain.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.aaxee.spring.homework1.domain.entity.QuizQuestion;
import ru.aaxee.spring.homework1.domain.entity.QuizResult;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ConsoleQuizServiceTest {

    @Test
    @DisplayName("Run quiz")
    void run() {
        InputStream fakeInput = new ByteArrayInputStream("Ответ1\nНе ответ".getBytes());
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream fakePrint = new PrintStream(byteArrayOutputStream);
        QuizService quizService = new ConsoleQuizService(fakeInput, fakePrint);
        List<QuizQuestion> quizQuestions = new ArrayList<>();
        quizQuestions.add(new QuizQuestion("Вопрос1", "Ответ1"));
        quizQuestions.add(new QuizQuestion("Вопрос2", "Ответ2"));

        QuizResult result = quizService.run(quizQuestions, 3);

        assertThat(result).isNotNull();
        assertThat(result.getQuestionsCount()).isEqualTo(2);
        assertThat(result.getCorrectAnswersCount()).isEqualTo(1);
        assertThat(byteArrayOutputStream.toString()).contains("Внимание!");
    }
}