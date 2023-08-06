package page_01._0001_two_sum;

import java.util.HashMap;
import java.util.Map;

public class TwoSumOnePassHashTable implements TwoSum {
    // LeetCode Solution - Using One Pass Hash Table
    // Time: O(n)
    // Space: O(n)
    @Override
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        // In case there is no solution, we'll just return null
        return null;
    }
}
