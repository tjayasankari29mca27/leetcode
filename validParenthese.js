/**
 * @param {string} s
 * @return {boolean}
 */
var isValid = function(s) {
    // 1. Initialize a stack
    const stack = [];
    
    // 2. Map closing brackets to their corresponding opening brackets
    const bracketMap = {
        ')': '(',
        '}': '{',
        ']': '['
    };

    // 3. Iterate through each character in the string
    for (let char of s) {
        // If the character is a closing bracket
        if (bracketMap[char]) {
            // Pop the top element from the stack (or use a dummy value if stack is empty)
            const topElement = stack.length === 0 ? '#' : stack.pop();
            
            // If the popped element doesn't match the required opening bracket, return false
            if (topElement !== bracketMap[char]) {
                return false;
            }
        } else {
            // If it's an opening bracket, push it onto the stack
            stack.push(char);
        }
    }

    // 4. If the stack is empty, the string is valid
    return stack.length === 0;
};
