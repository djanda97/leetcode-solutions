package leetCodeSolutions.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

// https://leetcode.com/problems/move-zeroes
class MoveZeroesTest {
    void moveZeroes(int[] nums) {
        int lastNonZeroFound = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[lastNonZeroFound++] = nums[i];
            }
        }
        for (int i = lastNonZeroFound; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    @Test
    void test() {
        int[] nums = new int[]{0, 1, 0, 3, 12};
        moveZeroes(nums);
        assertArrayEquals(new int[]{1, 3, 12, 0, 0}, nums);
    }

    @Test
    void testSingleElement() {
        int[] nums = new int[]{0};
        moveZeroes(nums);
        assertArrayEquals(new int[]{0}, nums);
    }
}
