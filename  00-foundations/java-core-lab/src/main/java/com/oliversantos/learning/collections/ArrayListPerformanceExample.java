package com.oliversantos.learning.collections;

import java.util.ArrayList;
import java.util.List;

public class ArrayListPerformanceExample {

    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>();

        long startInsert = System.nanoTime();

        for (int i = 0; i < 1_000_000; i++) {
            numbers.add(i);
        }

        long endInsert = System.nanoTime();

        System.out.println(
                "Insertion time: "
                        + ((endInsert - startInsert) / 1_000_000)
                        + " ms"
        );

        long startGet = System.nanoTime();

        Integer value = numbers.get(500_000);

        long endGet = System.nanoTime();

        System.out.println(
                "Access time: "
                        + (endGet - startGet)
                        + " ns"
        );

        System.out.println("Value found: " + value);
    }
}