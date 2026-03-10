/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var threeSumClosest = function(nums, target) {
    // 1. Sort the array in ascending order
    nums.sort((a, b) => a - b);
    
    // Initialize closestSum with the sum of the first three elements
    let closestSum = nums[0] + nums[1] + nums[2];
    
    // 2. Iterate through the array
    for (let i = 0; i < nums.length - 2; i++) {
        let left = i + 1;
        let right = nums.length - 1;
        
        // 3. Use two pointers to find the best sum for the current nums[i]
        while (left < right) {
            const currentSum = nums[i] + nums[left] + nums[right];
            
            // If we found the exact target, return it immediately
            if (currentSum === target) {
                return currentSum;
            }
            
            // 4. Update closestSum if the current distance is smaller
            if (Math.abs(target - currentSum) < Math.abs(target - closestSum)) {
                closestSum = currentSum;
            }
            
            // 5. Move pointers based on the sum comparison
            if (currentSum < target) {
                left++;
            } else {
                right--;
            }
        }
    }
    
    return closestSum;
};
