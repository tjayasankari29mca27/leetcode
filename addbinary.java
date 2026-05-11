class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;

        // Loop as long as there are digits to process or a carry left over
        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = carry;
            
            if (i >= 0) sum += a.charAt(i--) - '0'; // Convert char to int
            if (j >= 0) sum += b.charAt(j--) - '0';
            
            // Append the bit (sum % 2) and update the carry (sum / 2)
            sb.append(sum % 2);
            carry = sum / 2;
        }

        // The bits were added in reverse order, so we flip it back
        return sb.reverse().toString();
    }
}
