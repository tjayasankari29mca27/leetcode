import java.util.HashMap;
import java.util.Map;

class Solution {
    // Memoization map to store results of previously computed string pairs
    private Map<String, Boolean> memo = new HashMap<>();

    public boolean isScramble(String s1, String s2) {
        // Base case: strings are equal
        if (s1.equals(s2)) return true;
        
        // Quick check: if character frequencies don't match, they can't be scrambles
        if (!hasSameLetters(s1, s2)) return false;

        String key = s1 + " " + s2;
        if (memo.containsKey(key)) return memo.get(key);

        int n = s1.length();
        for (int i = 1; i < n; i++) {
            // Case 1: No swap at this split point
            if (isScramble(s1.substring(0, i), s2.substring(0, i)) && 
                isScramble(s1.substring(i), s2.substring(i))) {
                memo.put(key, true);
                return true;
            }

            // Case 2: Swap at this split point
            // s1's prefix matches s2's suffix AND s1's suffix matches s2's prefix
            if (isScramble(s1.substring(0, i), s2.substring(n - i)) && 
                isScramble(s1.substring(i), s2.substring(0, n - i))) {
                memo.put(key, true);
                return true;
            }
        }

        memo.put(key, false);
        return false;
    }

    private boolean hasSameLetters(String s1, String s2) {
        int[] count = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }
        for (int c : count) {
            if (c != 0) return false;
        }
        return true;
    }
}
