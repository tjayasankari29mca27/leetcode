import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), 1, n, k);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int start, int n, int k) {
        // Base case: if the combination is the desired size
        if (tempList.size() == k) {
            result.add(new ArrayList<>(tempList));
            return;
        }

        // Optimization: stop if there aren't enough numbers left to reach size k
        for (int i = start; i <= n - (k - tempList.size()) + 1; i++) {
            tempList.add(i);
            // Move to the next number
            backtrack(result, tempList, i + 1, n, k);
            // Backtrack: remove the last number to try the next possibility
            tempList.remove(tempList.size() - 1);
        }
    }
}
