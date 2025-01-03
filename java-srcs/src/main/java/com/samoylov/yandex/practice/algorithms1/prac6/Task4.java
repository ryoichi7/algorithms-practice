package com.samoylov.yandex.practice.algorithms1.prac6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

import static java.util.Arrays.stream;

/**
 * D. Космическое поселение
 */
public class Task4 {
    public static void main(String[] args) throws IOException {
        try (var reader = new BufferedReader(new InputStreamReader(System.in))) {
            var input = stream(reader.readLine().split(" "))
                    .mapToLong(Long::parseLong)
                    .toArray();
            var n = BigInteger.valueOf(input[0]);
            var a = BigInteger.valueOf(input[1]);
            var b = BigInteger.valueOf(input[2]);
            var w = BigInteger.valueOf(input[3]);
            var h = BigInteger.valueOf(input[4]);

            var maxLayer = getMaxLayer(w, h, a, b, n);

            System.out.println(maxLayer);
        }
    }

    public static BigInteger getMaxLayer(BigInteger w, BigInteger h, BigInteger a, BigInteger b, BigInteger n) {
        var maxLayer = BigInteger.ZERO;

        var left = BigInteger.ZERO;
        var right =  w.multiply(h);

        while (left.compareTo(right) <= 0) {
            var mid = left.add(right).divide(BigInteger.TWO);
            var curHeight = a.add(mid.multiply(BigInteger.TWO));
            var curWidth = b.add(mid.multiply(BigInteger.TWO));

            var widthRaw = w.divide(curWidth);
            var widthReversed = w.divide(curHeight);

            var heightRaw = h.divide(curHeight);
            var heightReversed = h.divide(curWidth);

            var basesReversed = widthReversed.multiply(heightReversed);
            var curBasesAmount = widthRaw.multiply(heightRaw).max(basesReversed);

            if (curBasesAmount.compareTo(n) >= 0){
                maxLayer = maxLayer.max(mid);
                left = mid.add(BigInteger.ONE);
            } else {
                right = mid.subtract(BigInteger.ONE);
            }
        }
        return maxLayer;
    }
}
