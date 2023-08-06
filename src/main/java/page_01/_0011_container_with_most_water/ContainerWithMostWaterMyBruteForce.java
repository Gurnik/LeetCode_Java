package page_01._0011_container_with_most_water;

public class ContainerWithMostWaterMyBruteForce implements ContainerWithMostWater {
    // Using Brute Force
    // Time: O(n^2)
    // Space: O(1)
    @Override
    public int maxArea(int[] height) {
        int maxArea = 0;

        for(int i = 0; i < height.length; i++) {
            for(int j = i + 1; j < height.length; j++) {
                int minHeight = height[i] < height[j]? height[i] : height[j];
                int width = j - i;
                int area = minHeight * width;
                if(maxArea < area) {
                    maxArea = area;
                }
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        ContainerWithMostWater fud = new ContainerWithMostWaterMyBruteForce();
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(fud.maxArea(height));
        int[] height1 = {1,1};
        System.out.println(fud.maxArea(height1));
    }
}
