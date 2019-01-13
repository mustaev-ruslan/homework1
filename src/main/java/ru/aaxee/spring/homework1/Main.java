package ru.aaxee.spring.homework1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.aaxee.spring.homework1.entity.QuizQuestion;
import ru.aaxee.spring.homework1.entity.QuizResult;
import ru.aaxee.spring.homework1.entity.QuizSettings;
import ru.aaxee.spring.homework1.entity.Student;
import ru.aaxee.spring.homework1.service.QuizLoaderService;
import ru.aaxee.spring.homework1.service.QuizService;
import ru.aaxee.spring.homework1.service.ResultPrintService;
import ru.aaxee.spring.homework1.service.StudentService;
import ru.aaxee.spring.homework1.exception.QuizException;

import java.util.List;

public class Main {

    public static void main(String[] args) throws QuizException {

        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");

        StudentService studentService = context.getBean(StudentService.class);
        QuizLoaderService quizLoaderService = context.getBean(QuizLoaderService.class);
        QuizService quizService = context.getBean(QuizService.class);
        ResultPrintService resultPrintService = context.getBean(ResultPrintService.class);

        QuizSettings quizSettings = new QuizSettings("geo_quiz", 5);

        Student student = studentService.getStudent();
        List<QuizQuestion> quizQuestionList = quizLoaderService.getQuizQuestionList(quizSettings.getQuizName());
        QuizResult quizResult = quizService.run(quizQuestionList, quizSettings.getMaxQuestions());
        resultPrintService.print(student, quizResult);
    }
}
