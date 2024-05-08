package com.samoylov.leetcode.medium;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/insert-delete-getrandom-o1/description/">...</a>
 */
public class InsertDeleteGeRandomO1 {
    class RandomizedSet {

        private int[] set;
        private int[] randomSet;
        private int capacity = 10;
        private int size;
        private final double loadFactor = 0.75;

        public RandomizedSet() {
            this.set = new int[capacity];
            this.randomSet = new int[capacity];
            Arrays.fill(randomSet, Integer.MIN_VALUE);
            Arrays.fill(set, Integer.MIN_VALUE);
        }

        public boolean insert(int val) {
            var hash = val % capacity < 0 ? val % capacity + capacity : val % capacity;
            if (set[hash] != Integer.MIN_VALUE) {
                return false;
            }
            randomSet[size++] = val;
            if ((double) size / capacity >= loadFactor) {
                capacity *= 2;
                var newSet = new int[capacity];
                for (var num : set) {
                    hash = num % capacity < 0 ? num % capacity + capacity : num % capacity;
                    newSet[hash] = num;
                }
                set = newSet;
                var newRandomSet = new int[capacity];
                for (var i = 0; i < size - 1; ++i) {
                    newRandomSet[i] = randomSet[i];
                }
                randomSet = newRandomSet;
            }
            hash = val % capacity < 0 ? val % capacity + capacity : val % capacity;
            set[hash] = val;
            randomSet[size] = val;
            return true;
        }

        public boolean remove(int val) {
            var hash = val % capacity < 0 ? val % capacity + capacity : val % capacity;
            if (set[hash] == Integer.MIN_VALUE) {
                return false;
            }
            set[hash] = Integer.MIN_VALUE;
            for (var i = 0; i < size - 1; ++i) {
                if (randomSet[i] == val) {
                    randomSet[i] = randomSet[i + 1];
                }
            }
            size--;
            return true;
        }

        public int getRandom() {
            var now = System.currentTimeMillis();
            return randomSet[(int) now % size];
        }
    }
}
