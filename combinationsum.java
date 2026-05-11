import java.util.*;
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), results);
        return results;
    }
    private void backtrack(int[] candidates, int remain, int start, List<Integer> current, List<List<Integer>> results) {
        if (remain == 0) {
            results.add(new ArrayList<>(current));
            return;
        }
        if (remain < 0) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            current.add(candidates[i]);
            backtrack(candidates, remain - candidates[i], i, current, results);
            current.remove(current.size() - 1);
        }
    }
}
