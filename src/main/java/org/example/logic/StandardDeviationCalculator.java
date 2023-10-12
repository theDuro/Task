package org.example.logic;

import org.example.data.Person;
import org.example.data.Team;

import java.util.Arrays;
import java.util.List;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StandardDeviationCalculator {
    public double calculate(List<Team> teams) {
        List<Double> numbers =teams.stream()
                .mapToDouble(Team::getAverageRating)
                .boxed()
                .toList();

        double mean = numbers.stream()
                .mapToDouble(Double::doubleValue)
                .average()
                .orElse(0.0);


        double sumOfSquaredDifferences = numbers.stream()
                .mapToDouble(num -> Math.pow(num - mean, 2))
                .sum();

        return Math.sqrt(sumOfSquaredDifferences / numbers.size());

    }
}

