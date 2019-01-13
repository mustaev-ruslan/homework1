package ru.aaxee.spring.homework1.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.aaxee.spring.homework1.aspect.Log;
import ru.aaxee.spring.homework1.entity.Student;

@Service
@AllArgsConstructor
public class ConsoleStudentService implements StudentService {

    private final InOutService inOutService;
    private final I18n i18n;

    @Log
    @Override
    public Student getStudent() {
        inOutService.write(i18n.tr("Second name:"));
        String lastName = inOutService.read();
        inOutService.write(i18n.tr("First name:"));
        String firstName = inOutService.read();
        return new Student(firstName, lastName);
    }
}
