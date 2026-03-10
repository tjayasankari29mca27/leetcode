public class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = (len1 > len2) ? len1 : len2;
            if (len > (end - start + 1)) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return buildSubstring(s, start, end);
    }
    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
    private String buildSubstring(String s, int start, int end) {
        int length = end - start + 1;
        char[] result = new char[length];
        for (int i = 0; i < length; i++) {
            result[i] = s.charAt(start + i);
        }
        return new String(result);
    }
}
