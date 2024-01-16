package org.example.kata;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FooBarQix {

    static String applyRules(int number) {
        Map<Integer, String> mappings = new HashMap<>();
        mappings.put(3, "Foo");
        mappings.put(5, "Bar");

        String part1 = mappings.keySet().stream()
                .filter(divisor -> number % divisor == 0)
                .map(mappings::get)
                .collect(Collectors.joining());

        String part2 = String.valueOf(number).chars()
                .mapToObj(digit -> mappings.getOrDefault(Character.getNumericValue(digit), ""))
                .collect(Collectors.joining());

        return (part1.isEmpty() && part2.isEmpty()) ? String.valueOf(number) : part1 + part2;
    }

    public void withoutIf() {
        IntStream.rangeClosed(1, 100)
                .mapToObj(FooBarQix::applyRules)
                .forEach(System.out::println);
    }
}
