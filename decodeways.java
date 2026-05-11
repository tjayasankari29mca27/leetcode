class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }

        int n = s.length();
        int[] dp = new int[n + 1];
        
        // Base cases
        dp[0] = 1; // Empty string has 1 way to be decoded
        dp[1] = 1; // First char is guaranteed not to be '0' due to check above

        for (int i = 2; i <= n; i++) {
            // Check single digit (current char)
            int oneDigit = Integer.parseInt(s.substring(i - 1, i));
            if (oneDigit >= 1) {
                dp[i] += dp[i - 1];
            }

            // Check two digits (previous and current char)
            int twoDigits = Integer.parseInt(s.substring(i - 2, i));
            if (twoDigits >= 10 && twoDigits <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[n];
    }
}
