package ru.aaxee.spring.homework1.domain.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.aaxee.spring.homework1.domain.entity.QuizResult;
import ru.aaxee.spring.homework1.domain.entity.Student;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ConsoleResultPrintServiceTest {

    @Test
    @DisplayName("Printing")
    void print() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        ResultPrintService resultPrintService = new ConsoleResultPrintService("Ура!", printStream);
        Student student = new Student("Petrov", "Ivan");
        QuizResult result = new QuizResult(10, 7);

        resultPrintService.print(student, result);

        assertThat(byteArrayOutputStream.toString())
                .contains("10")
                .contains("7")
                .contains("Petrov")
                .contains("Ура!")
                .contains("из");
    }
}