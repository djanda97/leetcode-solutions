package leetCodeSolutions.array;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindPivotIndexTest {
    int pivotIndex(int[] nums) {
        int leftSum = 0;
        int rightSum = IntStream.of(nums).sum();
        for (int i = 0; i < nums.length; i++) {
            leftSum += nums[i];
            if (leftSum == rightSum) return i;
            rightSum -= nums[i];
        }
        return -1;
    }

    @Test
    void test() {
        int[] nums = new int[]{1, 7, 3, 6, 5, 6};
        assertEquals(3, pivotIndex(nums));
        nums = new int[]{1, 2, 3};
        assertEquals(-1, pivotIndex(nums));
        nums = new int[]{2, 1, -1};
        assertEquals(0, pivotIndex(nums));
    }
}
