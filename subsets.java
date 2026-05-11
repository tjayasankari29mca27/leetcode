import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, int start) {
        // Add the current subset to the result (including the empty set)
        result.add(new ArrayList<>(tempList));

        for (int i = start; i < nums.length; i++) {
            // Include the current number
            tempList.add(nums[i]);
            
            // Move to the next element
            backtrack(result, tempList, nums, i + 1);
            
            // Backtrack: remove the last element to explore other subsets
            tempList.remove(tempList.size() - 1);
        }
    }
}
