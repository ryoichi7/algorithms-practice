package com.samoylov.yandex.contest.school.backend.part2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.stream;

public class Task1 {
    public static void main(String[] args) throws IOException {
        try (var reader = new BufferedReader(new InputStreamReader(System.in))) {
            var n = Integer.parseInt(reader.readLine());
            var field = new HashMap<String, Integer>();
            String winner = "Draw";
            for (int i = 1; i <= n; ++i) {
                var move = stream(reader.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
                field.put(move[0] + "," + move[1], i % 2);
                winner = checkWinner(field, move, i % 2);
                if (!winner.equals("Draw") && i < n) {
                    System.out.println("Inattention");
                    return;
                }
            }
            System.out.println(winner);
        }
    }

    private static String checkWinner(Map<String, Integer> field, int[] lastMove, int player) {
        var directions = new ArrayList<>(List.of(
                new int[]{0, 1}, // up/down
                new int[]{1, 0}, // left/right
                new int[]{1, 1}, // up-right/left-down
                new int[]{-1, 1} // up-left/down-right
        ));

        for (var direction : directions) {
            var count = 1;
            var rowOffset = direction[0];
            var colOffset = direction[1];
            for (int i = 1; i < 5; ++i) {
                var curKey = (lastMove[0] + rowOffset * i) + "," + (lastMove[1] + colOffset * i);
                if (field.getOrDefault(curKey, -1) == player) {
                    count++;
                } else {
                    break;
                }
            }

            for (int i = 1; i < 5; ++i) {
                var curKey = (lastMove[0] - rowOffset * i) + "," + (lastMove[1] - colOffset * i);
                if (field.getOrDefault(curKey, -1) == player) {
                    count++;
                } else {
                    break;
                }

            }
            if (count >= 5) {
                if (player == 0){
                    return "Second";
                } else {
                    return "First";
                }
            }
        }
        return "Draw";
    }
}
