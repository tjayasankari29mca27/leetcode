public class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1 || s.length() <= numRows) {
            return s;
        }
        int n = s.length();
        char[][] rows = new char[numRows][n];
        int[] rowSizes = new int[numRows]; // To keep track of column index for each row
        int currentRow = 0;
        boolean goingDown = false;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            rows[currentRow][rowSizes[currentRow]] = c;
            rowSizes[currentRow]++;
            if (currentRow == 0 || currentRow == numRows - 1) {
                goingDown = !goingDown;
            }
            currentRow += goingDown ? 1 : -1;
        }
        char[] result = new char[n];
        int k = 0;
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < rowSizes[i]; j++) {
                result[k++] = rows[i][j];
            }
        }
        return new String(result);
    }
}
