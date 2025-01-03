package com.samoylov.yandex.practice.algorithms5.prac1;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Task2 {

    private static final int HOME = 1;
    private static final int GUEST = 2;

    private static final int TEAM1 = 0;
    private static final int TEAM2 = 1;

    public static int footballAnnouncer(List<Integer> game1, List<Integer> game2, int homeOrGuest) {
        return 0;
    }

    public static void main(String[] args) {
        try (var scanner = new Scanner(System.in)) {
            var game1 = scanner.nextLine();
            var game2 = scanner.nextLine();
            var homeOrGuest = scanner.nextInt();
            var gm1 = Arrays.stream(game1.split(":")).map(Integer::valueOf).toList();
            var gm2 = Arrays.stream(game2.split(":")).map(Integer::valueOf).toList();
            System.out.println(footballAnnouncer(gm1, gm2, homeOrGuest));
        }
    }
}
