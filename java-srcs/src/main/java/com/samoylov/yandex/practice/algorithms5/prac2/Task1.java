package com.samoylov.yandex.practice.algorithms5.prac2;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        System.out.println(minRectangle());
    }

    public static String minRectangle() {
        int k;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        try (var scanner = new Scanner(System.in)) {
            k = scanner.nextInt();
            for (int i = 0; i < k; i++) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                maxX = Math.max(maxX, x);
                maxY = Math.max(maxY, y);
                minX = Math.min(minX, x);
                minY = Math.min(minY, y);
            }
        }
        return String.format("%d %d %d %d", minX, minY, maxX, maxY);
    }
}
