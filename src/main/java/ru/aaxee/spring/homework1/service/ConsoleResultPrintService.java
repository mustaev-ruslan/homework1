package ru.aaxee.spring.homework1.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.aaxee.spring.homework1.entity.QuizResult;
import ru.aaxee.spring.homework1.entity.Student;

@Service
@AllArgsConstructor
public class ConsoleResultPrintService implements ResultPrintService {

    private String congratulation;
    private InOutService inOutService;

    @Override
    public void print(Student student, QuizResult quizResult) {

        inOutService.write(
                congratulation + " " +
                        student.getLastName() + " " + student.getFirstName() + ", " +
                        "Вы ответили на " + quizResult.getCorrectAnswersCount() +
                        " из " + quizResult.getQuestionsCount() + " вопросов."
        );
    }
}
