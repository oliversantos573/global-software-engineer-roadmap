package com.oliversantos.learning.collections;

import java.util.ArrayList;
import java.util.List;

public class ArrayListExample {

    public static void main(String[] args) {

        List<String> technologies = new ArrayList<>();

        technologies.add("Java");
        technologies.add("Spring Boot");
        technologies.add("Kafka");
        technologies.add("AWS");
        technologies.add("Kubernetes");

        technologies.forEach(System.out::println);
    }
}