import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return result;
        }

        int n = s.length();
        int numWords = words.length;
        int wordLen = words[0].length();
        int totalLen = numWords * wordLen;

        // 1. Create a frequency map of the words we are looking for
        Map<String, Integer> wordCounts = new HashMap<>();
        for (String word : words) {
            wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
        }

        // 2. We only need to run the sliding window 'wordLen' times 
        // starting at different offsets to cover all word alignments.
        for (int i = 0; i < wordLen; i++) {
            int left = i;
            int right = i;
            int count = 0;
            Map<String, Integer> windowMap = new HashMap<>();

            // 3. Slide the window by wordLen increments
            while (right + wordLen <= n) {
                String word = s.substring(right, right + wordLen);
                right += wordLen;

                if (wordCounts.containsKey(word)) {
                    windowMap.put(word, windowMap.getOrDefault(word, 0) + 1);
                    count++;

                    // If we have more of 'word' than required, shrink from the left
                    while (windowMap.get(word) > wordCounts.get(word)) {
                        String leftWord = s.substring(left, left + wordLen);
                        windowMap.put(leftWord, windowMap.get(leftWord) - 1);
                        count--;
                        left += wordLen;
                    }

                    // If all words are matched
                    if (count == numWords) {
                        result.add(left);
                    }
                } else {
                    // Invalid word encountered, reset the window
                    windowMap.clear();
                    count = 0;
                    left = right;
                }
            }
        }

        return result;
    }
}
