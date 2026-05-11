class Solution {
    public boolean isNumber(String s) {
        boolean seenDigit = false;
        boolean seenDot = false;
        boolean seenE = false;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                seenDigit = true;
            } else if (c == '+' || c == '-') {
                // Signs can only appear at the start or immediately after 'e'/'E'
                if (i > 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') {
                    return false;
                }
            } else if (c == 'e' || c == 'E') {
                // 'e' can only appear once and must be preceded by a digit
                if (seenE || !seenDigit) {
                    return false;
                }
                seenE = true;
                seenDigit = false; // Reset to ensure an integer follows the exponent
            } else if (c == '.') {
                // Dot can only appear once and never after an 'e'
                if (seenDot || seenE) {
                    return false;
                }
                seenDot = true;
            } else {
                // Any other character is invalid
                return false;
            }
        }

        // Return true only if we've seen at least one digit 
        // (handles cases like ".", "1e", or "+")
        return seenDigit;
    }
}
