package ru.aaxee.spring.homework1;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.aaxee.spring.homework1.entity.QuizQuestion;
import ru.aaxee.spring.homework1.entity.QuizResult;
import ru.aaxee.spring.homework1.entity.QuizSettings;
import ru.aaxee.spring.homework1.entity.Student;
import ru.aaxee.spring.homework1.exception.QuizException;
import ru.aaxee.spring.homework1.service.QuizLoaderService;
import ru.aaxee.spring.homework1.service.QuizService;
import ru.aaxee.spring.homework1.service.ResultPrintService;
import ru.aaxee.spring.homework1.service.StudentService;

import java.util.List;

@Service
@RequiredArgsConstructor
class Application {

    private final StudentService studentService;
    private final QuizLoaderService quizLoaderService;
    private final QuizService quizService;
    private final ResultPrintService resultPrintService;

    @Value("${quiz.name}")
    private String quizName;

    @Value("#{new Integer('${quiz.maxQuestions}')}")
    private Integer maxQuestions;

    void run() throws QuizException {
        QuizSettings quizSettings = new QuizSettings(quizName, maxQuestions);
        Student student = studentService.getStudent();
        List<QuizQuestion> quizQuestionList = quizLoaderService.getQuizQuestionList(quizSettings.getQuizName());
        QuizResult quizResult = quizService.run(quizQuestionList, quizSettings.getMaxQuestions());
        resultPrintService.print(student, quizResult);
    }
}