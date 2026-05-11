class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        // dp[i][j] will be the edit distance between word1.substring(0, i) 
        // and word2.substring(0, j)
        int[][] dp = new int[m + 1][n + 1];

        // Base cases: 
        // If word2 is empty, we must delete all characters of word1
        for (int i = 0; i <= m; i++) dp[i][0] = i;
        // If word1 is empty, we must insert all characters of word2
        for (int j = 0; j <= n; j++) dp[0][j] = j;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    // Characters match, no new operation needed
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // Characters don't match, take the min of three operations:
                    // 1 + dp[i-1][j]   -> Delete
                    // 1 + dp[i][j-1]   -> Insert
                    // 1 + dp[i-1][j-1] -> Replace
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], 
                                   Math.min(dp[i - 1][j], dp[i][j - 1]));
                }
            }
        }

        return dp[m][n];
    }
}
