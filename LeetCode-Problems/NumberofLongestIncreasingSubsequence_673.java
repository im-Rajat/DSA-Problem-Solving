// 673. Number of Longest Increasing Subsequence
// https://leetcode.com/problems/number-of-longest-increasing-subsequence/


// Using Dynamic Programming
class Solution {
    public int findNumberOfLIS(int[] nums) {
        
        if (nums.length <= 1) {
            return nums.length;
        }
        
        int[] length = new int[nums.length];
        int[] count = new int[nums.length];
        
        Arrays.fill(length, 1);
        Arrays.fill(count, 1);
        
        int maxLen = 1;
        int result = 0;
        
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (length[i] < length[j] + 1) {
                        length[i] = length[j] + 1;
                        count[i] = count[j];
                    }
                    else if (length[i] == length[j] + 1) {
                        count[i] = count[i] + count[j];
                    }
                }
            }
            
            maxLen = Math.max(maxLen, length[i]);
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (length[i] == maxLen) {
                result = result + count[i];
            }
        }
        
        return result;
    }
}
