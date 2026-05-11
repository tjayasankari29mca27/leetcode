class Solution {
    public int maxSubArray(int[] nums) {
        int maxSoFar = nums[0];
        int currentMax = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // Either start a new subarray at i, or extend the existing one
            currentMax = Math.max(nums[i], currentMax + nums[i]);
            // Keep track of the best sum we've seen so far
            maxSoFar = Math.max(maxSoFar, currentMax);
        }

        return maxSoFar;
    }
}
