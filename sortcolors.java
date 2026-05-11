class Solution {
    public void sortColors(int[] nums) {
        int low = 0;           // Boundary for 0s (Red)
        int mid = 0;           // Current element pointer
        int high = nums.length - 1; // Boundary for 2s (Blue)

        while (mid <= high) {
            if (nums[mid] == 0) {
                // Found a 0: swap with low pointer and move both forward
                swap(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                // Found a 1: it's in the right place for now, just move mid
                mid++;
            } else {
                // Found a 2: swap with high pointer and move high backward
                // Don't move mid yet, because the swapped element needs checking
                swap(nums, mid, high);
                high--;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
