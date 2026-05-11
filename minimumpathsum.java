class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // 1. Initialize the first column (only one way to move: Down)
        for (int i = 1; i < m; i++) {
            grid[i][0] += grid[i - 1][0];
        }

        // 2. Initialize the first row (only one way to move: Right)
        for (int j = 1; j < n; j++) {
            grid[0][j] += grid[0][j - 1];
        }

        // 3. Fill the rest of the grid
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // Min path = current value + min(from above, from left)
                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }

        return grid[m - 1][n - 1];
    }
}
