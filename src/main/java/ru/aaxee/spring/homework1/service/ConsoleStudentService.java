package ru.aaxee.spring.homework1.service;

import lombok.AllArgsConstructor;
import ru.aaxee.spring.homework1.entity.Student;

@AllArgsConstructor
public class ConsoleStudentService implements StudentService {

    private InOutService inOutService;

    @Override
    public Student getStudent() {
        inOutService.write("Фамилия:");
        String lastName = inOutService.read();
        inOutService.write("Имя:");
        String firstName = inOutService.read();
        return new Student(firstName, lastName);
    }
}
