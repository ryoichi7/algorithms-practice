package com.samoylov.yandex.practice.algorithms5.prac2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Task9 {
    public static class Ship {
        public Integer row;
        public Integer col;

        public Ship(Integer row, Integer col) {
            this.row = row;
            this.col = col;
        }
    }
    public static void main(String[] args) throws IOException {
        try (var reader = new BufferedReader(new InputStreamReader(System.in))) {
            var n = Integer.parseInt(reader.readLine());
            var ships = new ArrayList<Ship>();
            for (int i = 0; i < n; i++) {
                var input = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                ships.add(new Ship(input[0], input[1]));
            }
            ships.sort((ship1, ship2) -> {
                if (!ship1.row.equals(ship2.row)){
                    return ship1.row - ship2.row;
                } else {
                    return ship1.col - ship2.col;
                }
            });

            var result = getLeastMoves(n, ships);

            System.out.println(result);
            System.gc();
        }
    }

    private static int getLeastMoves(int n, ArrayList<Ship> ships) {
        var result = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            var moves = 0;
            for (int j = 0; j < n; j++){
                var ship = ships.get(j);
                var colCells = Math.abs(i + 1 - ship.col);
                var rowCells = Math.abs(j + 1 - ship.row);
                var columnShift= colCells / 4 == 0 ? colCells % 4 : colCells / 4;
                var rowShift= rowCells / 4 == 0 ? rowCells % 4 : rowCells / 4;
                moves +=  columnShift + rowShift;
            }
            result = Math.min(result, moves);
        }
        return result;
    }
}
