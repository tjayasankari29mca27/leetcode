class Solution {
    public int removeElement(int[] nums, int val) {
        // Pointer k tracks the position of the next element not equal to val
        int k = 0;
        
        // Iterate through the array with pointer i
        for (int i = 0; i < nums.length; i++) {
            // If the current element is not the value to remove
            if (nums[i] != val) {
                // Place it at the k-th position
                nums[k] = nums[i];
                // Increment k to prepare for the next valid element
                k++;
            }
        }
        
        // k is the count of elements not equal to val
        return k;
    }
}
