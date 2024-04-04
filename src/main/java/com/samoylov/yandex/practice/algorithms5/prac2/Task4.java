package com.samoylov.yandex.practice.algorithms5.prac2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;


/**
 * Из шахматной доски по границам клеток выпилили связную (не распадающуюся на части) фигуру без дыр. Требуется определить ее периметр.
 * <p>
 * Формат ввода
 * Сначала вводится число N (1 ≤ N ≤ 64) – количество выпиленных клеток. В следующих N строках вводятся координаты выпиленных клеток, разделенные пробелом (номер строки и столбца – числа от 1 до 8). Каждая выпиленная клетка указывается один раз.
 * <p>
 * Формат вывода
 * Выведите одно число – периметр выпиленной фигуры (сторона клетки равна единице).
 */
public class Task4 {
    public static void main(String[] args) {
        try (var scanner = new Scanner(System.in)) {
            int n = Integer.parseInt(scanner.nextLine());
            var cells = new ArrayList<Integer>();
            var set = new HashSet<Integer>();
            var result = 0;

            for (int i = 0; i < n; i++) {
                var parts = scanner.nextLine().split(" ");
                var cell = Integer.parseInt(parts[0]) * 10 + Integer.parseInt(parts[1]);
                cells.add(cell);
                set.add(cell);
            }

            for (Integer cell : cells) {
                var cellPerimeter = 4;
                if (set.contains(cell - 1)){
                    cellPerimeter--;
                } if (set.contains(cell + 1)){
                    cellPerimeter--;
                } if (set.contains(cell + 10)){
                    cellPerimeter--;
                } if (set.contains(cell - 10)){
                    cellPerimeter--;
                }
                result += cellPerimeter;
            }
            System.out.println(result);
        }
    }
}