package com.samoylov.yandex.practice.algorithms1.prac2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;


public class Task5 {
    public static void main(String[] args) throws IOException {
        try (var reader = new BufferedReader(new InputStreamReader(System.in))) {
            var size = Integer.parseInt(reader.readLine());
            var members = stream(reader.readLine().split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            var max = Integer.MIN_VALUE;
            for (int i = 0; i < size; ++i){
                if (members.get(i) > max){
                    max = members.get(i);
                }
            }
            var target = 0;
            var targetPos = -1;
            for (int i = 0; i < size - 2; ++i){
                var mayBeWinner = members.get(i);
                var mayBeTarget = members.get(i + 1);
                var mayBeLoser = members.get(i + 2);
                if (mayBeWinner == max && mayBeTarget % 10 == 5 && mayBeTarget > mayBeLoser){
                    target = mayBeTarget;
                    targetPos = i + 1;
                }
            }
            if (targetPos == -1){
                System.out.println(0);
                return;
            }
            var placement = 1;
            for (int i = 0; i < size; ++i){
                var member = members.get(i);
                if (member > target){
                    placement++;
                }
            }
            System.out.println(placement);
        }
    }
}
