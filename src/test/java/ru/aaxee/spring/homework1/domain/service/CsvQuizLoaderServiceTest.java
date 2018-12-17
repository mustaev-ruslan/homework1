package ru.aaxee.spring.homework1.domain.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.aaxee.spring.homework1.domain.entity.QuizQuestion;
import ru.aaxee.spring.homework1.infrastructure.exception.QuizException;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

class CsvQuizLoaderServiceTest {

    @Test
    @DisplayName("Корректный квиз")
    void getCorrectQuizQuestionList() throws QuizException {
        QuizLoaderService quizLoaderService = new CsvQuizLoaderService();

        List<QuizQuestion> quizQuestionList = quizLoaderService.getQuizQuestionList("geo_quiz");

        assertThat(quizQuestionList)
                .isNotEmpty()
                .hasOnlyElementsOfType(QuizQuestion.class);
        assertThat(quizQuestionList.get(0)).hasNoNullFieldsOrProperties();
    }

    @Test
    @DisplayName("Некорректный квиз")
    void getUncorrectQuizQuestionList() {
        QuizLoaderService quizLoaderService = new CsvQuizLoaderService();

        Throwable thrown = catchThrowable(() -> quizLoaderService.getQuizQuestionList("nothing"));

        assertThat(thrown)
                .isInstanceOf(QuizException.class)
                .hasMessageContaining("Cannot");

    }
}