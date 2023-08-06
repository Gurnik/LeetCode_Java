package page_01._0011_container_with_most_water;

public class ContainerWithMostWaterTwoPointerApproach implements ContainerWithMostWater {
    // Using Two Pointer Approach
    // Time: O(n)
    // Space: O(1)
    @Override
    public int maxArea(int[] height) {
        int maxarea = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int width = right - left;
            maxarea = Math.max(maxarea, Math.min(height[left], height[right]) * width);
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxarea;
    }

    public static void main(String[] args) {
        ContainerWithMostWater fud = new ContainerWithMostWaterTwoPointerApproach();
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(fud.maxArea(height));
        int[] height1 = {1,1};
        System.out.println(fud.maxArea(height1));
    }
}
