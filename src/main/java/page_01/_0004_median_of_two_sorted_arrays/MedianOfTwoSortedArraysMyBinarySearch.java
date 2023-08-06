package page_01._0004_median_of_two_sorted_arrays;

public class MedianOfTwoSortedArraysMyBinarySearch implements MedianOfTwoSortedArrays {
    // Using Binary Search
    // Time: O(log(min{n, m}))
    // Space: O(1)
    @Override
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length) {
            // nums2 is smaller than  nums1
            return findMedianSortedArrays(nums2, nums1);
        }

        int start = 0;
        int end = nums1.length;
        int midMergeArray = (nums1.length + nums2.length + 1) / 2;

        while(start <= end) {
            int mid = (start + end) / 2;
            int leftNums1size = mid;
            int leftNums2size = midMergeArray - mid;
            int leftNums1 = (leftNums1size > 0) ? nums1[leftNums1size - 1] : Integer.MIN_VALUE;
            // checking overflow of indices
            int leftNums2 = (leftNums2size > 0) ? nums2[leftNums2size - 1] : Integer.MIN_VALUE;
            int rightNums1 = (leftNums1size < nums1.length) ? nums1[leftNums1size] : Integer.MAX_VALUE;
            int rightNums2 = (leftNums2size < nums2.length) ? nums2[leftNums2size] : Integer.MAX_VALUE;

            // if correct partition is done
            if (leftNums1 <= rightNums2 && leftNums2 <= rightNums1) {
                if ((nums1.length + nums2.length) % 2 == 0)
                    return (Math.max(leftNums1, leftNums2) + Math.min(rightNums1, rightNums2)) / 2.0;
                return Math.max(leftNums1, leftNums2);
            }
            else if (leftNums1 > rightNums2) {
                end = mid - 1;
            }
            else
                start = mid + 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        MedianOfTwoSortedArrays fud = new MedianOfTwoSortedArraysMyBinarySearch();
        int[] e1nums1 = {1, 3};
        int[] e1nums2 = {2};
        System.out.println(fud.findMedianSortedArrays(e1nums1, e1nums2));
        System.out.println(fud.findMedianSortedArrays(e1nums2, e1nums1));

        int[] e2nums1 = {1, 2};
        int[] e2nums2 = {3, 4};
        System.out.println(fud.findMedianSortedArrays(e2nums1, e2nums2));
        System.out.println(fud.findMedianSortedArrays(e2nums2, e2nums1));

        int[] e3nums1 = {1, 2, 3, 4, 5};
        int[] e3nums2 = {1, 2, 3, 5, 5, 6, 7, 8};
        System.out.println(fud.findMedianSortedArrays(e3nums1, e3nums2));
        System.out.println(fud.findMedianSortedArrays(e3nums2, e3nums1));

        int[] e4nums1 = {1, 2, 3, 4};
        int[] e4nums2 = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(fud.findMedianSortedArrays(e4nums1, e4nums2));
        System.out.println(fud.findMedianSortedArrays(e4nums2, e4nums1));

        int[] e5nums1 = {};
        int[] e5nums2 = {1};
        System.out.println(fud.findMedianSortedArrays(e5nums1, e5nums2));
        System.out.println(fud.findMedianSortedArrays(e5nums2, e5nums1));

        int[] e6nums1 = {1, 3};
        int[] e6nums2 = {2, 7};
        System.out.println(fud.findMedianSortedArrays(e6nums1, e6nums2));
        System.out.println(fud.findMedianSortedArrays(e6nums2, e6nums1));

        int[] e7nums1 = {};
        int[] e7nums2 = {2, 3};
        System.out.println(fud.findMedianSortedArrays(e7nums1, e7nums2));
        System.out.println(fud.findMedianSortedArrays(e7nums2, e7nums1));

        int[] e8nums1 = {2, 3, 4, 5, 6};
        int[] e8nums2 = {1};
        System.out.println(fud.findMedianSortedArrays(e8nums1, e8nums2));
        System.out.println(fud.findMedianSortedArrays(e8nums2, e8nums1));

        int[] e9nums1 = {-5, 3, 6, 12, 15};
        int[] e9nums2 = {-12, -10, -6, -3, 4, 10};
        System.out.println(fud.findMedianSortedArrays(e9nums1, e9nums2));
        System.out.println(fud.findMedianSortedArrays(e9nums2, e9nums1));
    }
}
