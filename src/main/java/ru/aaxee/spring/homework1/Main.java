package ru.aaxee.spring.homework1;

import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvParser;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import ru.aaxee.spring.homework1.domain.QuizQuestion;
import ru.aaxee.spring.homework1.domain.Student;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Фамилия:");
        String lastName = scanner.nextLine();
        System.out.println("Имя:");
        String firstName = scanner.nextLine();
        Student student = new Student(firstName, lastName);

        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        Resource geoQuizResource = new ClassPathResource("geo_quiz.csv");
        InputStream geoQuizInputStream = geoQuizResource.getInputStream();

        List<List<String>> quizQuestionRows = new CsvMapper()
                .readerFor(List.class)
                .withFeatures(CsvParser.Feature.WRAP_AS_ARRAY)
                .with(CsvSchema.emptySchema().withColumnSeparator(';'))
                .readValue(geoQuizInputStream);
        List<QuizQuestion> quizQuestionList = quizQuestionRows.stream()
                .map(row -> new QuizQuestion(row.get(0), row.get(1)))
                .collect(Collectors.toList());

        System.out.println("Внимание!");
        int correctAnswersCount = 0;
        final int answersCount = 3;
        for (QuizQuestion quizQuestion : quizQuestionList.subList(0, answersCount)) {
            System.out.println(quizQuestion.getQuestion());
            String userAnswer = scanner.nextLine();
            if (userAnswer.equals(quizQuestion.getAnswer())) {
                correctAnswersCount++;
            }
        }

        System.out.println(student.getLastName() + " " + student.getFirstName() +
                ", Вы ответили на " + correctAnswersCount + " из " + answersCount + " вопросов.");
    }
}
