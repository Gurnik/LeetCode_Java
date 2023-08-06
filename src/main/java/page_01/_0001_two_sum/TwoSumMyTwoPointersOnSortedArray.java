package page_01._0001_two_sum;

import java.util.Arrays;

public class TwoSumMyTwoPointersOnSortedArray implements TwoSum {
    // My Solution - Two Pointers on Sorted Array, Therefore, we first sort the given array nums
    // Time: O(n * log(n)) + O(n) = O(n * log(n))
    // Space: O(1)

    // NOTE: This approach we will lose the track of the indexes because of the sorting operation,
    // instead we will return the numbers that produce num1 + num2 = target
    @Override
    public int[] twoSum(int[] nums, int target) {
        Arrays.sort(nums); // Sort the array nums --> Time: O(n * log(n))

        int leftIndex = 0;
        int rightIndex = nums.length - 1;

        while(leftIndex < nums.length && leftIndex <= rightIndex) {
            if(nums[leftIndex] + nums[rightIndex] > target) {
                rightIndex --;
            } else if(nums[leftIndex] + nums[rightIndex] < target) {
                leftIndex ++;
            } else {
                //nums[leftIndex] + nums[rightIndex] == target)
                return new int[] {nums[leftIndex], nums[rightIndex]};
            }
        }

        return null;
    }

    public static void main(String[] args) {
        TwoSumMyTwoPointersOnSortedArray twoSum = new TwoSumMyTwoPointersOnSortedArray();
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
