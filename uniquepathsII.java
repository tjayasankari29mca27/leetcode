class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        // If the start or end is blocked, there are no possible paths
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) {
            return 0;
        }

        // dp[j] will store the number of ways to reach the current cell in column j
        int[] dp = new int[n];
        dp[0] = 1; // Base case: starting point

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    // Obstacle found: no paths can pass through here
                    dp[j] = 0;
                } else if (j > 0) {
                    // Current ways = ways from above (dp[j]) + ways from left (dp[j-1])
                    dp[j] += dp[j - 1];
                }
            }
        }

        return dp[n - 1];
    }
}
