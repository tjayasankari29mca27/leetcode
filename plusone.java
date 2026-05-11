class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        
        // Start from the last digit and move backwards
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                // We're done! No more carries needed.
                return digits;
            }
            
            // If the digit is 9, it becomes 0 and the carry continues
            digits[i] = 0;
        }
        
        // Edge case: If we exit the loop, it means the number was all 9s (e.g., 999)
        // The result should be 1 followed by n zeros (e.g., 1000)
        int[] result = new int[n + 1];
        result[0] = 1;
        return result;
    }
}
