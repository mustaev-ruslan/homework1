package ru.aaxee.spring.homework1.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.aaxee.spring.homework1.entity.QuizResult;
import ru.aaxee.spring.homework1.entity.Student;

@Service
@AllArgsConstructor
public class ConsoleResultPrintService implements ResultPrintService {

    private final InOutService inOutService;
    private final I18n i18n;

    @Override
    public void print(Student student, QuizResult quizResult) {

        //String Congratulation! = messageSource.getMessage("Congratulation!", null, Locale.getDefault());

        inOutService.write(
                i18n.tr("Congratulation!") + " " +
                        student.getLastName() + " " + student.getFirstName() + ", " +
                        i18n.tr("Your answered on {0} questions. All count: {1}",
                                quizResult.getCorrectAnswersCount(),
                                quizResult.getQuestionsCount()
                        )
        );

    }
}
