package ru.aaxee.spring.homework1.service;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class FakeInOutService implements InOutService {

    private List<String> input;
    private List<String> output;

    @Override
    public void write(String text) {
        output.add(text);
    }

    @Override
    public String read() {
        return input.remove(0);
    }
}
