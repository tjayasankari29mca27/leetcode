class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        if (s.length() < 4 || s.length() > 12) return result;
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(String s, int start, List<String> current, List<String> result) {
        // Base case: Found 4 segments
        if (current.size() == 4) {
            if (start == s.length()) {
                result.add(String.join(".", current));
            }
            return;
        }

        // Try lengths 1, 2, and 3 for the next segment
        for (int len = 1; len <= 3; len++) {
            if (start + len > s.length()) break;

            String part = s.substring(start, start + len);
            
            if (isValid(part)) {
                current.add(part);
                backtrack(s, start + len, current, result);
                current.remove(current.size() - 1); // Undo choice
            }
        }
    }

    private boolean isValid(String part) {
        // Check leading zeros
        if (part.length() > 1 && part.startsWith("0")) return false;
        // Check numerical range
        int val = Integer.parseInt(part);
        return val >= 0 && val <= 255;
    }
}
