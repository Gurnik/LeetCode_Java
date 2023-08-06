package page_01._0001_two_sum;

import java.util.HashMap;

public class TwoSumMyOnePassHashTable implements TwoSum {
    // My Solution - Using One Pass Hash Table
    // Time: O(n)
    // Space: O(n)
    @Override
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(int index = 0; index < nums.length; index ++) {
            // num1 + num2 == target ---> num2 = target - num1
            int num1 = nums[index];
            int num2 = target - num1;

            // Check if num1 (current number) is inside the hash table
            if(hashMap.containsKey(num1)) {
                // Return num1 index and current index
                return new int[] {hashMap.get(num1), index};
            } else {
                // Insert num2 as a key to hash table, and the index of num1 as the value
                hashMap.put(num2, index);
            }
        }
        // Not found
        return null;
    }

    public static void main(String[] args) {
        TwoSumMyOnePassHashTable twoSum = new TwoSumMyOnePassHashTable();
        // Example 1:
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        twoSum.twoSum(nums1, target1);
        int[] output1 = {0, 1};

        // Example 2:
        int[] nums2 = {3, 2, 4};
        int target2 = 6;
        twoSum.twoSum(nums2, target2);
        int[] output2 = {1, 2};

        // Example 3:
        int[] nums3 = {3, 3};
        int target3 = 6;
        twoSum.twoSum(nums3, target3);
        int[] output3 = {0, 1};

        // Example 4:
        int[] nums4 = {4, -2, 5, 0, 6, 3, 2, 7};
        int target4 = 1;
        twoSum.twoSum(nums4, target4);
        int[] output4 = {1, 4};
    }

}
