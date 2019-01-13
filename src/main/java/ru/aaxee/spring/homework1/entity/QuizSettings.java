package ru.aaxee.spring.homework1.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Locale;

@ToString
@Getter
@AllArgsConstructor
public class QuizSettings {

    private String quizName;
    private int maxQuestions;
    private Locale locale;

    public String getFilePath() {
        return quizName + "/" + quizName + "_" + locale.toLanguageTag() + ".csv";
    }
}
