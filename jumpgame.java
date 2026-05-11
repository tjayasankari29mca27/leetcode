class Solution {
    public boolean canJump(int[] nums) {
        int farthest = 0;
        
        for (int i = 0; i < nums.length; i++) {
            // If the current index is greater than the farthest we can reach,
            // it means we are stuck and cannot proceed.
            if (i > farthest) {
                return false;
            }
            
            // Update the farthest reachable index
            farthest = Math.max(farthest, i + nums[i]);
            
            // Optimization: If farthest already reaches or exceeds the last index, return true
            if (farthest >= nums.length - 1) {
                return true;
            }
        }
        
        return false;
    }
}
