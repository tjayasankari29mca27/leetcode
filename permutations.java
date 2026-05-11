import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums) {
        // If the current list matches the input length, we found a permutation
        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList));
        } else {
            for (int i = 0; i < nums.length; i++) {
                // Skip if the element is already in the current permutation
                if (tempList.contains(nums[i])) continue;
                
                tempList.add(nums[i]);
                backtrack(result, tempList, nums);
                // Remove the last element to try the next possibility
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
