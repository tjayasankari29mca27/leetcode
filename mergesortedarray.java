class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // Pointer for the end of the actual values in nums1
        int p1 = m - 1;
        // Pointer for the end of nums2
        int p2 = n - 1;
        // Pointer for the very end of nums1 (the write position)
        int p = m + n - 1;

        // While there are elements to compare in both arrays
        while (p1 >= 0 && p2 >= 0) {
            // Compare the largest remaining elements and place the bigger one at the back
            if (nums1[p1] > nums2[p2]) {
                nums1[p--] = nums1[p1--];
            } else {
                nums1[p--] = nums2[p2--];
            }
        }

        // If there are still elements left in nums2, copy them over
        // (If elements are left in nums1, they are already in their correct sorted positions)
        while (p2 >= 0) {
            nums1[p--] = nums2[p2--];
        }
    }
}
