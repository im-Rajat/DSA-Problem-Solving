// 209. Minimum Size Subarray Sum
// https://leetcode.com/problems/minimum-size-subarray-sum/


// Using 2 Pointer
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        
        int minLength = Integer.MAX_VALUE;
        
        int left = 0;
        int right = 0;
        
        int sum = 0;
        
        while (right < nums.length) {
            sum = sum + nums[right];
            
            while (sum >= target) {
                int len = right - left + 1;
                minLength = Math.min(minLength, len);
                sum = sum - nums[left];
                left++;
            }
            
            right++;
        }
        
        if (minLength == Integer.MAX_VALUE) {
            return 0;
        }
        else {
            return minLength;
        }
    }
}
