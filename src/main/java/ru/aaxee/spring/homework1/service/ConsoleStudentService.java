package ru.aaxee.spring.homework1.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.aaxee.spring.homework1.entity.Student;

@Service
@AllArgsConstructor
public class ConsoleStudentService implements StudentService {

    private final I18n i18n;
    private final InOutService inOutService;

    @Override
    public Student getStudent() {
        inOutService.write(i18n.translate("Second name:"));
        String lastName = inOutService.read();
        inOutService.write(i18n.translate("First name:"));
        String firstName = inOutService.read();
        return new Student(firstName, lastName);
    }
}
