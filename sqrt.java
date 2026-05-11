class Solution {
    public int mySqrt(int x) {
        if (x < 2) return x;

        int left = 2;
        int right = x / 2;
        int result = 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            long num = (long) mid * mid;

            if (num == x) {
                return mid;
            } else if (num < x) {
                result = mid; // Potential answer, keep looking for a larger one
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }
}
