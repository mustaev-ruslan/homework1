package ru.aaxee.spring.homework1.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.aaxee.spring.homework1.entity.QuizResult;
import ru.aaxee.spring.homework1.entity.Student;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ConsoleResultPrintServiceTest {

    @Test
    @DisplayName("Printing")
    void print() {
        List<String> input = Collections.emptyList();
        List<String> output = new LinkedList<>();
        InOutService inOutService = new FakeInOutService(input, output);
        ResultPrintService resultPrintService = new ConsoleResultPrintService("Ура!", inOutService);
        Student student = new Student("Petrov", "Ivan");
        QuizResult result = new QuizResult(10, 7);

        resultPrintService.print(student, result);

        assertThat(output.get(0))
                .contains("10")
                .contains("7")
                .contains("Petrov")
                .contains("Ура!")
                .contains("из");
    }
}