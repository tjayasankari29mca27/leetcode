class Solution {
    public int romanToInt(String s) {
        int total = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            int currentVal = getValue(s.charAt(i));
            if (i + 1 < n) {
                int nextVal = getValue(s.charAt(i + 1));
                if (currentVal < nextVal) {
                    total -= currentVal;
                } else {
                    total += currentVal;
                }
            } else {
                total += currentVal;
            }
        }
        return total;
    }
    public int getValue(char c) {
        if (c == 'I') 
            return 1;
        if (c == 'V') 
            return 5;
        if (c == 'X')
            return 10;
        if (c == 'L') 
            return 50;
        if (c == 'C')
             return 100;
        if (c == 'D')
             return 500;
        if (c == 'M') 
            return 1000;
        return 0;
    }
}
