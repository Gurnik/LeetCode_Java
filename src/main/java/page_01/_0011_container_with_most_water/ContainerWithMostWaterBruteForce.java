package page_01._0011_container_with_most_water;

public class ContainerWithMostWaterBruteForce implements ContainerWithMostWater {

    @Override
    public int maxArea(int[] height) {
        int maxarea = 0;
        for (int left = 0; left < height.length; left++) {
            for (int right = left + 1; right < height.length; right++) {
                int width = right - left;
                maxarea = Math.max(maxarea, Math.min(height[left], height[right]) * width);
            }
        }
        return maxarea;
    }

    public static void main(String[] args) {
        ContainerWithMostWater fud = new ContainerWithMostWaterBruteForce();
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(fud.maxArea(height));
        int[] height1 = {1,1};
        System.out.println(fud.maxArea(height1));
    }
}
