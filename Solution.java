import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        
        // 1. Sort the array
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 2; i++) {
            // Optimization: Since the array is sorted, if the first number is 
            // greater than 0, the sum of three numbers can never be 0.
            if (nums[i] > 0) break;
            
            // 2. Skip duplicate elements for the first position
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            
            int left = i + 1;
            int right = nums.length - 1;
            
            // 3. Use two pointers to find the other two numbers
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    
                    // 4. Skip duplicate elements for the second and third positions
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    
                    left++;
                    right--;
                } else if (sum < 0) {
                    // Sum is too small, move left pointer to a larger number
                    left++;
                } else {
                    // Sum is too large, move right pointer to a smaller number
                    right--;
                }
            }
        }
        
        return result;
    }
}
