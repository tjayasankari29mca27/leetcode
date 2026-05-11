import java.util.ArrayList;
import java.util.List;

class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> numbers = new ArrayList<>();
        int[] factorial = new int[n + 1];
        StringBuilder sb = new StringBuilder();

        // 1. Create a list of numbers [1, 2, 3, ... n] 
        // and precompute factorials
        int sum = 1;
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            sum *= i;
            factorial[i] = sum;
            numbers.add(i);
        }

        // 2. Adjust k to be 0-indexed
        k--;

        // 3. Determine each digit of the permutation
        for (int i = 1; i <= n; i++) {
            // Number of permutations in each "block"
            int index = k / factorial[n - i];
            
            // Append the number at that index and remove it from the available pool
            sb.append(numbers.get(index));
            numbers.remove(index);
            
            // Update k for the next iteration
            k %= factorial[n - i];
        }

        return sb.toString();
    }
}
