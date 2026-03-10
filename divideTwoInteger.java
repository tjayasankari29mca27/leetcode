class Solution {
    public int divide(int dividend, int divisor) {
        // Special Case: Handle 32-bit signed integer overflow
        // -2^31 / -1 = 2^31, which is 1 greater than the max signed 32-bit int (2^31 - 1)
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Determine the sign of the result
        // If both have the same sign, result is positive; otherwise, negative
        boolean isNegative = (dividend < 0) ^ (divisor < 0);

        // Convert to long to handle the absolute value of Integer.MIN_VALUE
        // Math.abs(Integer.MIN_VALUE) results in overflow if kept as an int
        long absDividend = Math.abs((long) dividend);
        long absDivisor = Math.abs((long) divisor);

        int quotient = 0;

        // Main logic: Subtract multiples of the divisor using bit shifting
        while (absDividend >= absDivisor) {
            long tempDivisor = absDivisor;
            long multiple = 1;

            // Keep doubling the divisor until it's just under the current dividend
            // tempDivisor << 1 is equivalent to tempDivisor * 2
            while (absDividend >= (tempDivisor << 1)) {
                tempDivisor <<= 1;
                multiple <<= 1;
            }

            // Subtract the largest found multiple of divisor
            absDividend -= tempDivisor;
            // Add the count of divisors found to the quotient
            quotient += multiple;
        }

        return isNegative ? -quotient : quotient;
    }
}
