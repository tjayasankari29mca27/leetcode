public class Solution {
    public int maxArea(int[] height) {
        int maxWater = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int width = right - left;
            int currentHeight;
            if (height[left] < height[right]) {
                currentHeight = height[left];
            } else {
                currentHeight = height[right];
            }
            int currentArea = width * currentHeight;
            if (currentArea > maxWater) {
                maxWater = currentArea;
            }
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxWater;
    }
}
