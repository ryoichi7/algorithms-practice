package com.samoylov.yandex.practice.algorithms1.prac6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

import static java.util.Arrays.stream;

/**
 * C. Димпломы
 */
public class Task3 {
    public static void main(String[] args) throws IOException {
        try (var reader = new BufferedReader(new InputStreamReader(System.in))) {
            var input = stream(reader.readLine().split(" "))
                    .mapToLong(Long::parseLong)
                    .toArray();

            var weight = BigInteger.valueOf(input[0]);
            var height = BigInteger.valueOf(input[1]);
            var n = BigInteger.valueOf(input[2]);
            var minEdge = getBigInteger(weight, height, n);
            System.out.println(minEdge);
        }
    }

    public static BigInteger getBigInteger(BigInteger weight, BigInteger height, BigInteger n) {
        var right = weight.multiply(height).multiply(n);
        var left = right.sqrt();
        var minEdge = right.add(BigInteger.ONE);
        while (left.compareTo(right) <= 0) {
            var mid = left.add(right).divide(BigInteger.TWO);
            var heightCount = mid.divide(height);
            var weightCount = mid.divide(weight);
            if (heightCount.multiply(weightCount).compareTo(n) >= 0){
                right = mid.subtract(BigInteger.ONE);
                minEdge = minEdge.min(mid);
            } else {
                left = mid.add(BigInteger.ONE);
            }
        }
        return minEdge;
    }
}
