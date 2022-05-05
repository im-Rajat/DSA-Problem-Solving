// 713. Subarray Product Less Than K
// https://leetcode.com/problems/subarray-product-less-than-k/


class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        
        if (k <= 1) {
            return 0;
        }
        
        int left = 0, right = 0;
        int result = 0;
        int product = 1;
        
        while (right < nums.length) {
            product = product * nums[right];
            
            while (product >= k) {
                product = product / nums[left];
                left++;
            }
            
            result = result + (right - left + 1);
            
            right++;
        }
        
        return result;
    }
}
