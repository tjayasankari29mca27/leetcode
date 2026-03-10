class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLength = 0;
        int[] lastIndex = new int[128];
        for (int i = 0; i < 128; i++) {
            lastIndex[i] = -1;
        }
        int left = 0;
        for (int right = 0; right < n; right++) {
            char currentChar = s.charAt(right);
            if (lastIndex[currentChar] >= left) {
                left = lastIndex[currentChar] + 1;
            }
            lastIndex[currentChar] = right;
            int currentWindowLength = right - left + 1;
            if (currentWindowLength > maxLength) {
                maxLength = currentWindowLength;
            }
        }
        return maxLength; 
    }
}
