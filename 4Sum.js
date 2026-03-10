/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[][]}
 */
var fourSum = function(nums, target) {
    const result = [];
    const n = nums.length;
    
    // 1. Sort the array numerically
    nums.sort((a, b) => a - b);
    
    // 2. First loop for the first number
    for (let i = 0; i < n - 3; i++) {
        // Skip duplicate for i
        if (i > 0 && nums[i] === nums[i - 1]) continue;
        
        // Optimization: Smallest sum with current i is too big
        if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) break;
        // Optimization: Largest sum with current i is too small
        if (nums[i] + nums[n - 3] + nums[n - 2] + nums[n - 1] < target) continue;

        // 3. Second loop for the second number
        for (let j = i + 1; j < n - 2; j++) {
            // Skip duplicate for j
            if (j > i + 1 && nums[j] === nums[j - 1]) continue;

            // Optimization: Smallest sum with current i, j is too big
            if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) break;
            // Optimization: Largest sum with current i, j is too small
            if (nums[i] + nums[j] + nums[n - 2] + nums[n - 1] < target) continue;

            // 4. Two pointers for the third and fourth numbers
            let left = j + 1;
            let right = n - 1;

            while (left < right) {
                const sum = nums[i] + nums[j] + nums[left] + nums[right];

                if (sum === target) {
                    result.push([nums[i], nums[j], nums[left], nums[right]]);
                    
                    // Skip duplicates for left and right pointers
                    while (left < right && nums[left] === nums[left + 1]) left++;
                    while (left < right && nums[right] === nums[right - 1]) right--;
                    
                    left++;
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
    }
    
    return result;
};
