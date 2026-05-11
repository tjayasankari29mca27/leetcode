class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Start DFS if the first character matches
                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int index) {
        // Base case: all characters found
        if (index == word.length()) {
            return true;
        }

        // Check boundaries and character match
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length 
            || board[i][j] != word.charAt(index)) {
            return false;
        }

        // Mark the cell as visited using a temporary variable
        char temp = board[i][j];
        board[i][j] = '#'; 

        // Explore all 4 directions: Up, Down, Left, Right
        boolean found = dfs(board, word, i + 1, j, index + 1) ||
                        dfs(board, word, i - 1, j, index + 1) ||
                        dfs(board, word, i, j + 1, index + 1) ||
                        dfs(board, word, i, j - 1, index + 1);

        // Backtrack: restore the original character
        board[i][j] = temp;

        return found;
    }
}
