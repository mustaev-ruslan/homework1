package ru.aaxee.spring.homework1.service;

import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class ConsoleInOutService implements InOutService {

    private final static Scanner scanner = new Scanner(System.in);

    @Override
    public void write(String text) {
        System.out.println(text);
    }

    @Override
    public String read() {
        return scanner.nextLine();
    }
}
