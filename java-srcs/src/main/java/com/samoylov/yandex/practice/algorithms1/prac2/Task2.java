package com.samoylov.yandex.practice.algorithms1.prac2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Task2 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            var num = Integer.parseInt(reader.readLine());
            var isCONSTANT = true;
            var isASCENDING = true;
            var isWEAKLY_ASCENDING = true;
            var isDESCENDING = true;
            var isWEAKLY_DESCENDING = true;
            while (true){
                var nextNum = Integer.parseInt(reader.readLine());
                if (nextNum == -2_000_000_000) break;
                if (num != nextNum) isCONSTANT = false;
                if (num >= nextNum) isASCENDING = false;
                if (num > nextNum) isWEAKLY_ASCENDING = false;
                if (num <= nextNum) isDESCENDING = false;
                if (num < nextNum) isWEAKLY_DESCENDING = false;
                num = nextNum;
            }
            if (isCONSTANT) System.out.println("CONSTANT");
            else if (isASCENDING) System.out.println("ASCENDING");
            else if (isWEAKLY_ASCENDING) System.out.println("WEAKLY ASCENDING");
            else if (isDESCENDING) System.out.println("DESCENDING");
            else if (isWEAKLY_DESCENDING) System.out.println("WEAKLY DESCENDING");
            else System.out.println("RANDOM");
        }
    }
}