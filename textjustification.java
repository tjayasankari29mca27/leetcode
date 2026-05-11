import java.util.*;

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int i = 0;
        int n = words.length;

        while (i < n) {
            int j = i + 1;
            int lineLength = words[i].length();
            
            // 1. Find words that fit in this line
            while (j < n && lineLength + 1 + words[j].length() <= maxWidth) {
                lineLength += 1 + words[j].length();
                j++;
            }

            StringBuilder sb = new StringBuilder();
            int diff = j - i - 1; // Number of gaps between words

            // 2. Handle Last Line or Single Word Line (Left Justified)
            if (j == n || diff == 0) {
                for (int k = i; k < j; k++) {
                    sb.append(words[k]);
                    if (k < j - 1) sb.append(" ");
                }
                while (sb.length() < maxWidth) sb.append(" ");
            } 
            // 3. Handle Fully Justified Line
            else {
                int totalSpaces = maxWidth - (lineLength - diff);
                int spacesPerGap = totalSpaces / diff;
                int extraSpaces = totalSpaces % diff;

                for (int k = i; k < j; k++) {
                    sb.append(words[k]);
                    if (k < j - 1) {
                        int spacesToApply = spacesPerGap + (extraSpaces-- > 0 ? 1 : 0);
                        for (int s = 0; s < spacesToApply; s++) sb.append(" ");
                    }
                }
            }

            result.add(sb.toString());
            i = j; // Move to the next set of words
        }

        return result;
    }
}
