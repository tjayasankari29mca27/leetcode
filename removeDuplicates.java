class Solution {
    public int removeDuplicates(int[] nums) {
        // Base case: if the array is empty, return 0
        if (nums.length == 0) {
            return 0;
        }

        // Pointer 'i' tracks the position of the current unique element
        int i = 0;

        // Pointer 'j' scans through the array starting from the second element
        for (int j = 1; j < nums.length; j++) {
            // If we find a value different from the current unique element
            if (nums[j] != nums[i]) {
                // Move the unique pointer forward
                i++;
                // Place the new unique element at the next available position
                nums[i] = nums[j];
            }
        }

        // The number of unique elements is the index 'i' + 1
        return i + 1;
    }
}
