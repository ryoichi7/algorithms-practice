package com.samoylov.yandex.practice.algorithms1.prac5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

/**
 * F. Кондиционеры
 */
public class Task6 {
    public static void main(String[] args) throws IOException {
        try (var reader = new BufferedReader(new InputStreamReader(System.in))) {
            var n = Integer.parseInt(reader.readLine());
            var result = 0;
            var requirements = stream(reader.readLine().split(" "))
                    .map(Integer::parseInt)
                    .sorted()
                    .collect(Collectors.toList());
            var m = Integer.parseInt(reader.readLine());
            var proposals = new ArrayList<Conditioner>();
            for (int i = 0; i < m; i++) {
                var input = stream(reader.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
                var power = input[0];
                var price = input[1];
                proposals.add(new Conditioner(power, price));
            }
            proposals.sort(null);
            var reqPtr = 0;
            var propPtr = 0;
            while (reqPtr < requirements.size()){
                var requiredPower = requirements.get(reqPtr);
                var proposalPower = proposals.get(propPtr).power;
                if (proposalPower >= requiredPower){
                    reqPtr++;
                    result += proposals.get(propPtr).price;
                } else {
                    propPtr++;
                }
            }
            System.out.println(result);
        }
    }

    public static class Conditioner implements Comparable<Conditioner>{
        public int power;
        public int price;

        public Conditioner(int power, int price) {
            this.power = power;
            this.price = price;
        }

        @Override
        public int compareTo(Conditioner o) {
            if (o.price != this.price){
                return this.price - o.price;
            } else {
                return o.power - this.power;
            }
        }
    }
}


