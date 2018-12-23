package ru.aaxee.spring.homework1;

import lombok.AllArgsConstructor;
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
@AllArgsConstructor
class Application {

    private StudentService studentService;
    private QuizLoaderService quizLoaderService;
    private QuizService quizService;
    private ResultPrintService resultPrintService;

    void run() throws QuizException {
        QuizSettings quizSettings = new QuizSettings("geo_quiz", 5);
        Student student = studentService.getStudent();
        List<QuizQuestion> quizQuestionList = quizLoaderService.getQuizQuestionList(quizSettings.getQuizName());
        QuizResult quizResult = quizService.run(quizQuestionList, quizSettings.getMaxQuestions());
        resultPrintService.print(student, quizResult);
    }
}
