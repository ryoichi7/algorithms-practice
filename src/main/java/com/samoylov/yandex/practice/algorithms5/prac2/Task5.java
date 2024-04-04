package com.samoylov.yandex.practice.algorithms5.prac2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.TreeSet;

import static java.lang.Math.max;
import static java.lang.String.join;
import static java.util.Arrays.stream;

/**
 * Домашний питомец мальчика Васи — улитка Петя. Петя обитает на бесконечном в обе стороны вертикальном столбе,
 * который для удобства можно представить как числовую прямую. Изначально Петя находится в точке 0.
 * Вася кормит Петю ягодами. У него есть n ягод, каждая в единственном экземпляре. Вася
 * знает, что если утром он даст Пете ягоду с номером і, то поев и набравшись сил, за остаток
 * дня Петя поднимется на аi единиц вверх по столбу, но при этом за ночь, потяжелев, съедет на
 * bi единиц вниз. Параметры различных ягод могут совпадать.
 * Пете стало интересно, а как оно там, наверху, и Вася взялся ему в этом помочь.
 * Ближайшие n дней он будет кормить Петю ягодами из своего запаса таким образом, чтобы максимальная высота,
 * на которой побывал Петя за эти n дней была максимальной. К сожалению, Вася не умеет программировать,
 * поэтому он попросил вас о помощи. Найдите, максимальную высоту, на которой Петя сможет побывать за эти n дней
 * и в каком порядке Вася должен давать Пете ягоды, чтобы Петя смог её достичь!
 * Формат ввода
 * В первой строке входных данных дано число п (1 ≤ n ≤ 5 • 10^5) — количество ягод у Васи.
 * В последующих n строках описываются параметры каждой ягоды. В і + 1 строке дано два числа аi и bi (0 ≤ аi, bi ≤ 10^9) — то,
 * насколько поднимется улитка за день после того, как съест і ягоду и насколько опуститься за ночь.
 * Формат вывода
 * В первой строке выходных данных выведите единственное число — максимальную высоту, которую сможет достичь Петя,
 * если Вася будет его кормить оптимальным образом.
 * В следующей строке выведите и различных целых чисел от 1 до n — порядок, в котором Вася должен кормить Петю
 * (i число в строке соответствует номеру ягоды, которую Вася должен
 * дать Пете в і день чтобы Петя смог достичь максимальной высоты).
 */

//TODO: WA TEST 14
public class Task5 {

    private static class ChangeWithIndex {
        public Integer change;

        public Integer a;
        public Integer index;

        public ChangeWithIndex(Integer change, Integer index, Integer a) {
            this.change = change;
            this.index = index + 1;
            this.a = a;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ChangeWithIndex that = (ChangeWithIndex) o;
            return Objects.equals(change, that.change);
        }

        @Override
        public int hashCode() {
            return Objects.hash(change);
        }

        @Override
        public String toString() {
            return index.toString();
        }
    }

    public static void main(String[] args) throws IOException {
        try (var reader = new BufferedReader(new InputStreamReader(System.in))) {
            var berriesAmount = Integer.parseInt(reader.readLine());
            var goodChanges = new TreeSet<ChangeWithIndex>((o1, o2) -> {
                if (!o1.change.equals(o2.change)) {
                    return o2.change - o1.change;
                } else {
                    return o1.index.compareTo(o2.index);
                }
            });
            var badChanges = new TreeSet<ChangeWithIndex>((o1, o2) -> {
                if (!o1.a.equals(o2.a)) {
                    return o2.a - o1.a;
                } else {
                    return o1.index.compareTo(o2.index);
                }
            });

            var maxHeight = 0;
            var currentHeight = 0;
            for (int i = 0; i < berriesAmount; i++) {
                var pair = stream(reader.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
                var change = pair[0] - pair[1];
                if (change >= 0) {
                    goodChanges.add(new ChangeWithIndex(change, i, pair[0]));
                } else {
                    badChanges.add(new ChangeWithIndex(change, i, pair[0]));
                }
            }
            for (ChangeWithIndex change : goodChanges) {
                maxHeight = max(currentHeight + change.a, maxHeight);
                currentHeight += change.change;
            }
            for (ChangeWithIndex change : badChanges) {
                maxHeight = max(currentHeight + change.a, maxHeight);
                currentHeight += change.change;
            }
            System.out.println(maxHeight);
            System.out.print(join(" ",
                    goodChanges.stream()
                            .map(ChangeWithIndex::toString)
                            .toList()
            ));
            System.out.println(" " + join(" ",
                    badChanges.stream()
                            .map(ChangeWithIndex::toString)
                            .toList()
            ));
        }
    }
}
