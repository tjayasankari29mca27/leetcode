class Solution {
    public double myPow(double x, int n) {
        long N = n; // Use long to prevent overflow during negation
        
        // Handle negative power: x^-n = (1/x)^n
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        
        return fastPow(x, N);
    }

    private double fastPow(double x, long n) {
        if (n == 0) return 1.0;
        
        double half = fastPow(x, n / 2);
        
        // If n is even: x^n = (x^(n/2))^2
        if (n % 2 == 0) {
            return half * half;
        } 
        // If n is odd: x^n = x * (x^(n/2))^2
        else {
            return half * half * x;
        }
    }
}
