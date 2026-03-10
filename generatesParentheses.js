/**
 * @param {number} n
 * @return {string[]}
 */
var generateParenthesis = function(n) {
    const result = [];

    /**
     * Helper function for backtracking
     * @param {string} currentString - The current string being built
     * @param {number} open - Count of opening brackets used
     * @param {number} close - Count of closing brackets used
     */
    function backtrack(currentString, open, close) {
        // Base case: If the current string length is 2 * n, it's complete
        if (currentString.length === n * 2) {
            result.push(currentString);
            return;
        }

        // If we can still add an opening bracket, add it
        if (open < n) {
            backtrack(currentString + "(", open + 1, close);
        }

        // If we can add a closing bracket (it must not exceed the open count), add it
        if (close < open) {
            backtrack(currentString + ")", open, close + 1);
        }
    }

    // Start the recursion with an empty string and 0 counts
    backtrack("", 0, 0);

    return result;
};
