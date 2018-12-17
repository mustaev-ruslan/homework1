package ru.aaxee.spring.homework1.domain.service;

import lombok.AllArgsConstructor;
import ru.aaxee.spring.homework1.domain.entity.Student;

import java.io.InputStream;
import java.util.Scanner;

@AllArgsConstructor
public class ConsoleStudentService implements StudentService {

    private InputStream inputStream;

    public Student getStudent() {
        Scanner scanner = new Scanner(inputStream);
        System.out.println("Фамилия:");
        String lastName = scanner.nextLine();
        System.out.println("Имя:");
        String firstName = scanner.nextLine();
        return new Student(firstName, lastName);
    }
}
