package com.samoylov.yandex.contest.school.backend.part1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task1 {
    public static void main(String[] args) throws IOException {
        try (var reader = new BufferedReader(new InputStreamReader(System.in))) {
            var nickname = reader.readLine();
            var hasDigit = false;
            var hasUpperCase = false;
            var hasLowerCase = false;
            if (nickname.length() < 8){
                System.out.println("NO");
                return;
            }
            for (int i = 0; i < nickname.length(); ++i){
                var ch =  nickname.charAt(i);
                if (ch >= '0' && ch <= '9'){
                    hasDigit = true;
                } else if (ch >= 'a' && ch <= 'z') {
                    hasLowerCase = true;
                } else if (ch >= 'A' && ch <= 'Z') {
                    hasUpperCase = true;
                }
            }
            if (hasDigit && hasLowerCase && hasUpperCase) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
