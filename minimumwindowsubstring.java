import java.util.HashMap;
import java.util.Map;

class Solution {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) return "";

        // 1. Map to store the frequency of characters in t
        Map<Character, Integer> dictT = new HashMap<>();
        for (char c : t.toCharArray()) {
            dictT.put(c, dictT.getOrDefault(c, 0) + 1);
        }

        int required = dictT.size(); // Number of unique chars in t that must be in window
        int formed = 0; // Number of unique chars in current window that meet t's frequency

        // Map to store character counts in the current window
        Map<Character, Integer> windowCounts = new HashMap<>();

        // ans list: [window length, left, right]
        int[] ans = {-1, 0, 0};
        int l = 0, r = 0;

        while (r < s.length()) {
            // Expand the window by adding the character at the right pointer
            char c = s.charAt(r);
            windowCounts.put(c, windowCounts.getOrDefault(c, 0) + 1);

            // If the frequency of the current char matches the desired frequency in t
            if (dictT.containsKey(c) && windowCounts.get(c).intValue() == dictT.get(c).intValue()) {
                formed++;
            }

            // Try and contract the window until it ceases to be 'desirable'
            while (l <= r && formed == required) {
                c = s.charAt(l);

                // Update the smallest window found so far
                if (ans[0] == -1 || r - l + 1 < ans[0]) {
                    ans[0] = r - l + 1;
                    ans[1] = l;
                    ans[2] = r;
                }

                // The character at 'l' is no longer part of the window
                windowCounts.put(c, windowCounts.get(c) - 1);
                if (dictT.containsKey(c) && windowCounts.get(c) < dictT.get(c)) {
                    formed--;
                }

                l++; // Contract the window
            }
            r++; // Keep expanding the window
        }

        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }
}
