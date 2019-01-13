package ru.aaxee.spring.homework1.service;

import java.util.Scanner;

public class ConsoleInOutService implements InOutService {

    private static Scanner scanner = new Scanner(System.in);

    @Override
    public void write(String text) {
        System.out.println(text);
    }

    @Override
    public String read() {
        return scanner.nextLine();
    }
}
