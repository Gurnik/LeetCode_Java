package page_01._0001_two_sum;

public class TwoSumMyBruteForce implements TwoSum {
    // My Solution - Using Brute Force
    // Time: O(n^2)
    // Space: O(1)
    @Override
    public int[] twoSum(int[] nums, int target) {
        for(int basePointer = 0; basePointer < nums.length; basePointer++) {
            for(int compareWithPointer = basePointer + 1; compareWithPointer < nums.length; compareWithPointer ++) {
                if(AreEqual(nums[basePointer] + nums[compareWithPointer], target)) {
                    return new int[] {basePointer, compareWithPointer};
                }
            }
        }
        return null;
    }

    private boolean AreEqual(int num1, int num2) {
        return num1 == num2;
    }

    public static void main(String[] args) {
        TwoSumMyBruteForce twoSum = new TwoSumMyBruteForce();
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
