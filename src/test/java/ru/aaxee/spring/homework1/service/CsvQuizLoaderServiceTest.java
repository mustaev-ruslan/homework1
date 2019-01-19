package ru.aaxee.spring.homework1.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.aaxee.spring.homework1.entity.QuizQuestion;
import ru.aaxee.spring.homework1.exception.QuizException;
import ru.aaxee.spring.homework1.service.fake.NoI18n;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class CsvQuizLoaderServiceTest {

    @Spy
    NoI18n i18n;

    // Комментарий ниже
//    @Mock
//    I18n i18n;

    @InjectMocks
    CsvQuizLoaderService quizLoaderService;

    @Test
    @DisplayName("Корректный квиз")
    void getCorrectQuizQuestionList() throws QuizException {
        List<QuizQuestion> quizQuestionList = quizLoaderService.getQuizQuestionList("geo_quiz/geo_quiz_ru-RU.csv");

        assertThat(quizQuestionList)
                .isNotEmpty()
                .hasOnlyElementsOfType(QuizQuestion.class);
        assertThat(quizQuestionList.get(0)).hasNoNullFieldsOrProperties();
    }

    @Test
    @DisplayName("Некорректный квиз")
    void getUncorrectQuizQuestionList() {
        // Можно так, но ведь проще иметь fake-класс NoI18n,
        // тем более что он во всех тестах нужен, не писать же каждый раз эту фейковую реализацию
//        when(i18n.tr(any(), any())).thenCallRealMethod(); // default-метод интерфейса
//        when(i18n.translate(any(), any())).thenAnswer((Answer<String>) invocation -> {
//            // Подставляем аргументы сообщения если они есть без перевода
//            String message = invocation.getArgument(0);
//            Object[] args = invocation.getArguments();
//            Object[] messageArgs = Arrays.copyOfRange(args, 1, args.length);
//            return MessageFormat.format(message, messageArgs);
//        });

        Throwable thrown = catchThrowable(() -> quizLoaderService.getQuizQuestionList("nothing"));

        assertThat(thrown)
                .isInstanceOf(QuizException.class)
                .hasMessageContaining("Cannot");

    }
}