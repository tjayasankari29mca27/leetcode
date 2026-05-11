class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }

        // 'i' is the pointer where the next valid element will be placed
        int i = 2;

        // Start checking from the third element (index 2)
        for (int j = 2; j < nums.length; j++) {
            // If current element is different from the element 2 spots back, 
            // it means we haven't seen more than two of this number yet.
            if (nums[j] != nums[i - 2]) {
                nums[i] = nums[j];
                i++;
            }
        }

        return i;
    }
}
