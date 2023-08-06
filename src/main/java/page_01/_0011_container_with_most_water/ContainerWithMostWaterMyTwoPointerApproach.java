package page_01._0011_container_with_most_water;

public class ContainerWithMostWaterMyTwoPointerApproach implements ContainerWithMostWater {
    // Using Two Pointer Approach
    // Time: O(n)
    // Space: O(1)
    @Override
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while(left < right) {
            int min_height = height[left] < height[right]? height[left] : height[right];
            int width = right - left;
            int area = min_height * width;
            if(maxArea < area) {
                maxArea = area;
            }
            if(height[left] <= height[right]) {
                left ++;
            } else {
                right --;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        ContainerWithMostWater fud = new ContainerWithMostWaterMyTwoPointerApproach();
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(fud.maxArea(height));
        int[] height1 = {1,1};
        System.out.println(fud.maxArea(height1));
    }
}
