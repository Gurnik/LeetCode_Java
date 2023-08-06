package page_01._0016_3sum_closest;

import java.util.Arrays;

public class ThreeSumClosestTwoPointers  implements ThreeSumClosest {
    // Using Two Pointers
    // Time: O(n^2)
    // Space: O(log(n)) to O(n), depending on the implementation of the sorting algorithm.
    @Override
    public int threeSumClosest(int[] nums, int target) {
        int diff = Integer.MAX_VALUE;
        int sz = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < sz && diff != 0; ++i) {
            int lo = i + 1;
            int hi = sz - 1;
            while (lo < hi) {
                int sum = nums[i] + nums[lo] + nums[hi];
                if (Math.abs(target - sum) < Math.abs(diff)) {
                    diff = target - sum;
                }
                if (sum < target) {
                    ++lo;
                } else {
                    --hi;
                }
            }
        }
        return target - diff;
    }

    public static void main(String[] args) {
        ThreeSumClosest fut = new ThreeSumClosestTwoPointers();
        int[] nums1 = {-1, 2, 1, -4};
        int target = 1;
        System.out.println(fut.threeSumClosest(nums1, target));
        int[] nums2 = {0, 0, 0};
        target = 1;
        System.out.println(fut.threeSumClosest(nums2, target));
    }
}
