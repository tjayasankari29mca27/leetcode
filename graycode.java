import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        // There are 2^n numbers in an n-bit sequence
        int numCount = 1 << n; 
        
        for (int i = 0; i < numCount; i++) {
            // Formula: Gray(i) = i ^ (i >> 1)
            result.add(i ^ (i >> 1));
        }
        
        return result;
    }
}
