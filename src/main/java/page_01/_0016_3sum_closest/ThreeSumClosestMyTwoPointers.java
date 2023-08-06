package page_01._0016_3sum_closest;

import java.util.Arrays;

public class ThreeSumClosestMyTwoPointers implements ThreeSumClosest {
    // Using Two Pointers
    // Time: O(n^2)
    // Space: O(log(n)) to O(n), depending on the implementation of the sorting algorithm.
    @Override
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int difference = Integer.MAX_VALUE;

        for(int i = 0; i < nums.length - 2; i++) {
                int left = i + 1;
                int right = nums.length - 1;

                while (left < right) {
                    int sum = nums[i] + nums[left] + nums[right];
                    if(Math.abs(target - sum) < Math.abs(difference)) {
                        difference = target - sum;
                    }
                    if(sum == target) {
                        return sum;
                    } else if(sum > target) {
                        right--;
                    } else {
                        // sum < target
                        left++;
                    }
                }
        }
        return target - difference;
    }

    public static void main(String[] args) {
        ThreeSumClosest fut = new ThreeSumClosestMyTwoPointers();
        int[] nums1 = {-1, 2, 1, -4};
        int target = 1;
        System.out.println(fut.threeSumClosest(nums1, target));
        int[] nums2 = {0, 0, 0};
        target = 1;
        System.out.println(fut.threeSumClosest(nums2, target));
        int[] nums3 = {1, 1, 1, 1};
        target = 0;
        // Expected: 3
        // Output: 2147483647
        System.out.println(fut.threeSumClosest(nums3, target));
        int[] nums4 = {1, 1, 1, 0};
        target = 100;
        // Expected: 3
        // Output: 2
        System.out.println(fut.threeSumClosest(nums4, target));
        int[] nums5 = {4, 0, 5, -5, 3, 3, 0, -4, -5};
        target = -2;
        // Expected: -2
        // Output = -4
        System.out.println(fut.threeSumClosest(nums5, target));
    }
}
