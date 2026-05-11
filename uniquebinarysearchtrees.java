class Solution {
    public int numTrees(int n) {
        // dp[i] stores the number of unique BSTs with i nodes
        int[] dp = new int[n + 1];
        
        // Base cases
        dp[0] = 1; // Empty tree
        dp[1] = 1; // Single node tree
        
        // Build up from 2 nodes to n nodes
        for (int nodes = 2; nodes <= n; nodes++) {
            for (int root = 1; root <= nodes; root++) {
                // Left subtree has (root - 1) nodes
                // Right subtree has (nodes - root) nodes
                dp[nodes] += dp[root - 1] * dp[nodes - root];
            }
        }
        
        return dp[n];
    }
}
