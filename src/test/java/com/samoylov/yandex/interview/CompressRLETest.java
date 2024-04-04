package com.samoylov.yandex.interview;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompressRLETest {

    private static CompressRLE COMPRESSOR;

    @BeforeAll
    static void beforeAll() {
        COMPRESSOR = new CompressRLE();
    }

    @Test
    void case1() {
        var given = "AAAABBBCCXYZDDDDEEEFFFAAAAAABBBBBBBBBBBBBBBBBBBBBBBBBBBB";
        var expected = "A4B3C2XYZD4E3F3A6B28";
        var actual = COMPRESSOR.compress(given);
        assertEquals(expected, actual);
    }
}