package com.samoylov.yandex.practice.algorithms5;

import java.util.HashMap;
import java.util.Scanner;

public class Task1 {


    //Memory limit solution
    public static long treePainting_old(long Vasya, long vRange, long Masha, long mRange) {
        var vLeft = Vasya - vRange;
        var vRight = Vasya + vRange;

        var mLeft = Masha - mRange;
        var mRight = Masha + mRange;

        var map = new HashMap<Long, Integer>();
        for (long i = vLeft; i <= vRight; ++i){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (long i = mLeft; i <= mRight; ++i){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        return map.size();
    }

    public static long treePainting(long Vasya, long vRange, long Masha, long mRange) {
        var vLeft = Vasya - vRange;
        var vRight = Vasya + vRange;

        var mLeft = Masha - mRange;
        var mRight = Masha + mRange;

        if (vRight < mLeft || mRight < vLeft){
            return (vRight - vLeft + 1) + (mRight - mLeft + 1);
        } else {
            return Math.max(vLeft, Math.max(vRight, Math.max(mLeft, mRight)))
                   - Math.min(vLeft, Math.min(vRight, Math.min(mLeft, mRight))) + 1;
        }
    }

    public static void main(String[] args) {
        long P, V, Q, M;
        try (var scanner = new Scanner(System.in)) {
            P = scanner.nextLong();
            V = scanner.nextLong();
            Q = scanner.nextLong();
            M = scanner.nextLong();
        }
        var result = treePainting(P, V, Q, M);
        System.out.println(result);
    }
}
