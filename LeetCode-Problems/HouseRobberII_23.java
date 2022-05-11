// 213. House Robber II
// https://leetcode.com/problems/house-robber-ii/


// Using DP
class Solution {
    public int rob(int[] nums) {
        
        int len = nums.length;
        
        if (len == 1) {
            return nums[0];
        }
        
        int[] dp = new int[len + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        
        for (int i = 1; i < len - 1; i++) {
            dp[i + 1] = Math.max(dp[i], dp[i - 1] + nums[i]);
        }
        
        int r1 = dp[len - 1];
        
        dp[0] = 0;
        dp[1] = 0;
        
        for (int i = 1; i < len; i++) {
            dp[i + 1] = Math.max(dp[i], dp[i - 1] + nums[i]);
        }
        
        int r2 = dp[len];
        
        
        return Math.max(r1, r2);
    }
}
