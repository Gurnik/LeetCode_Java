package page_01._0001_two_sum;

public class TwoSumBruteForce implements TwoSum {

    // LeetCode Solution - Using Brute Force
    // Time: O(n^2)
    // Space: O(1)
    @Override
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[] { i, j };
                }
            }
        }
        // In case there is no solution, we'll just return null
        return null;
    }
}
