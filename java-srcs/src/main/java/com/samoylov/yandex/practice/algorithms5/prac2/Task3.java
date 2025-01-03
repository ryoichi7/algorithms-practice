package com.samoylov.yandex.practice.algorithms5.prac2;

import java.util.Scanner;

import static java.lang.Math.max;
import static java.util.Arrays.stream;

public class Task3 {
    public static void main(String[] args) {
        try (var scanner = new Scanner(System.in)) {
            var ropesAmount = Integer.parseInt(scanner.nextLine());
            var ropes = stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            var sum = 0;
            var maxRope = 0;
            for (var i = 0; i < ropesAmount; ++i){
                var rope = ropes[i];
                sum += rope;
                maxRope = max(rope, maxRope);
            }
            if (sum - maxRope < maxRope){
                System.out.println(maxRope * 2 - sum);
            } else {
                System.out.println(sum);
            }
        }
    }
}
