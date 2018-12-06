package ru.aaxee.spring.homework1.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@AllArgsConstructor
public class QuizQuestion {

    private String question;
    private String answer;
}
