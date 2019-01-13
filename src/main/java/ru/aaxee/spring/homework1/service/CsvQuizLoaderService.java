package ru.aaxee.spring.homework1.service;

import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvParser;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import ru.aaxee.spring.homework1.entity.QuizQuestion;
import ru.aaxee.spring.homework1.exception.QuizException;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;

public class CsvQuizLoaderService implements QuizLoaderService {

    @Override
    public List<QuizQuestion> getQuizQuestionList(String quizName) throws QuizException {
        Resource geoQuizResource = new ClassPathResource(quizName + ".csv");
        InputStream geoQuizInputStream;
        List<List<String>> quizQuestionRows;
        try {
            geoQuizInputStream = geoQuizResource.getInputStream();
            quizQuestionRows = new CsvMapper()
                    .readerFor(List.class)
                    .withFeatures(CsvParser.Feature.WRAP_AS_ARRAY)
                    .with(CsvSchema.emptySchema().withColumnSeparator(';'))
                    .readValue(geoQuizInputStream);
        } catch (IOException e) {
            throw new QuizException("Cannot get quiz " + quizName, e);
        }
        List<QuizQuestion> quizQuestionList = quizQuestionRows.stream()
                .map(row -> new QuizQuestion(row.get(0), row.get(1)))
                .collect(Collectors.toList());
        return quizQuestionList;
    }
}
