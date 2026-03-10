/**
 * @param {string} digits
 * @return {string[]}
 */
var letterCombinations = function(digits) {
    // If the input is empty, return an empty array
    if (digits.length === 0) return [];

    // Map of digits to letters
    const phoneMap = {
        '2': 'abc',
        '3': 'def',
        '4': 'ghi',
        '5': 'jkl',
        '6': 'mno',
        '7': 'pqrs',
        '8': 'tuv',
        '9': 'wxyz'
    };

    const result = [];

    /**
     * Helper function for backtracking
     * @param {number} index - Current index in the digits string
     * @param {string} currentCombination - The string built so far
     */
    function backtrack(index, currentCombination) {
        // Base case: if the current combination is the same length as digits
        if (index === digits.length) {
            result.push(currentCombination);
            return;
        }

        // Get the letters corresponding to the current digit
        const letters = phoneMap[digits[index]];

        // Iterate through those letters and move to the next digit
        for (let char of letters) {
            backtrack(index + 1, currentCombination + char);
        }
    }

    // Start the recursion from the first digit (index 0)
    backtrack(0, "");

    return result;
};
