package com.samoylov.leetcode.medium

/**
 * <a href="https://leetcode.com/problems/number-of-black-blocks/description/">task link</a>
 */
object NumberOfBlackBlocks {
    fun countBlackBlocks(m: Int, n: Int, coordinates: Array<IntArray>): LongArray {
        val result = LongArray(5)
        val blocksAmount = (m - 1L) * (n - 1L)

        val blocks = mutableMapOf<Long, Int>()
        coordinates.forEach {
            countAffectedBlocks(blocks, it, m, n)
        }

        blocks.values.forEach {
            result[it]++
        }
        result[0] = blocksAmount - blocks.size
        return result
    }

    private fun countAffectedBlocks(
        blocks: MutableMap<Long, Int>,
        coordinate: IntArray,
        m: Int,
        n: Int
    ) {
        val (x, y) = coordinate
        for (dx in -1..0) {
            for (dy in -1..0) {
                val blockX = x + dx
                val blockY = y + dy

                if (blockX in 0 until m - 1 && blockY in 0 until n - 1) {
                    val blockIndex = blockX * (n - 1L) + blockY
                    blocks[blockIndex] = blocks.getOrDefault(blockIndex, 0) + 1
                }
            }
        }
    }
}