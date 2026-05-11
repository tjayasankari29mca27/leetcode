import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // 1. Sort to make duplicates adjacent
        Arrays.sort(nums);
        backtrack(result, new ArrayList<>(), nums, new boolean[nums.length]);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, boolean[] used) {
        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // Skip if element is already used in this path
            if (used[i]) continue;

            // 2. Skip duplicates: 
            // If the current number is the same as the previous one AND 
            // the previous one was not used in the current recursion level.
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;

            used[i] = true;
            tempList.add(nums[i]);
            
            backtrack(result, tempList, nums, used);
            
            // Backtrack
            used[i] = false;
            tempList.remove(tempList.size() - 1);
        }
    }
}
