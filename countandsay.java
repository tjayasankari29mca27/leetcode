class Solution {
    public String countAndSay(int n) {
        if (n == 1) return "1";
        String s = "1";
        for (int i = 1; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0, count = 0; j < s.length(); j++) {
                count++;
                if (j + 1 == s.length() || s.charAt(j) != s.charAt(j + 1)) {
                    sb.append(count).append(s.charAt(j));
                    count = 0;
                }
            }
            s = sb.toString();
        }
        return s;
    }
}
