package com.samoylov.yandex.practice.algorithms1.prac7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Observer;

import static java.util.Arrays.stream;

/**
 * A. Наблюдение за студентами
 */
public class Task1 {
    public static void main(String[] args) throws IOException {
        try (var reader = new BufferedReader(new InputStreamReader(System.in))) {
            var input = stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            var studentsAmount = input[0];
            var observersAmount = input[1];
            var observers = new ArrayList<Observer>();
            for (int i = 0; i < observersAmount; i++) {
                var desks = stream(reader.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
                observers.add(new Observer(desks[0], 0));
                observers.add(new Observer(desks[1], 1));
            }
            observers.sort((a, b) -> {
                if (a.desk != b.desk) {
                    return a.desk - b.desk;
                }
                return a.type - b.type;
            });

            var result = countStudents(observers);
            System.out.println(studentsAmount - result);
        }
    }

    private static int countStudents(ArrayList<Observer> observers) {

        return 0;
    }


    public static class Observer {
        public int desk;
        public int type;

        public Observer(int desk, int type) {
            this.desk = desk;
            this.type = type;
        }
    }
}