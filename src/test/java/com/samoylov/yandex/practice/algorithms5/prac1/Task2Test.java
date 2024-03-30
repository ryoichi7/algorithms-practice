package com.samoylov.yandex.practice.algorithms5.prac1;

import com.samoylov.yandex.practice.algorithms5.prac1.Task2;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;


class Task2Test {

    @Test
    void footballAnnouncerCase1() {
        assertThat(Task2.footballAnnouncer(List.of(0,0), List.of(0,0), 1))
                .isEqualTo(1);
    }
    @Test
    void footballAnnouncerCase2() {
        assertThat(Task2.footballAnnouncer(List.of(0,2), List.of(0,3), 1))
                .isEqualTo(5);
    }
    @Test
    void footballAnnouncerCase3() {
        assertThat(Task2.footballAnnouncer(List.of(0,2), List.of(0,3), 2))
                .isEqualTo(6);
    }

    @Test
    void OverallLoseWinHomeGameButLoseGuest(){
        assertThat(Task2.footballAnnouncer(List.of(1,0), List.of(0,3), 1))
                .isEqualTo(3);
    }

    @Test
    void OverallLoseDrawHomeGameButLoseGuest(){
        assertThat(Task2.footballAnnouncer(List.of(0,0), List.of(0,3), 1))
                .isEqualTo(4);
    }

    @Test
    void footballAnnouncerCase5(){
        assertThat(Task2.footballAnnouncer(List.of(2,2), List.of(1,1), 2))
                .isEqualTo(1);
    }
}