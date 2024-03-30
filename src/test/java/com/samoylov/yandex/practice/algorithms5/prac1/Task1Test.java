package com.samoylov.yandex.practice.algorithms5.prac1;

import com.samoylov.yandex.practice.algorithms5.prac1.Task1;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Task1Test {

    @Test
    void treePaintingDefaultCase() {
        assertThat(Task1.treePainting(0, 7, 12, 5))
                .isEqualTo(25);
    }

    @Test
    void bothRangesCross(){
        assertThat(Task1.treePainting(0, 3, 5, 3))
                .isEqualTo(12);
    }

    @Test
    void oneRangeContainAnother(){
        assertThat(Task1.treePainting(0, 3, 5, 13))
                .isEqualTo(27);
    }

    @Test
    void BothRangesSeparate(){
        assertThat(Task1.treePainting(0, 3, 8, 2))
                .isEqualTo(12);
    }
}