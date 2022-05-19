// 322. Coin Change
// https://leetcode.com/problems/coin-change/


// Using Dynamic Pr0gramming
class Solution {
    public int coinChange(int[] coins, int amount) {
        
        if (amount < 1) {
            return 0;
        }
        
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE-1);
        dp[0] = 0;
        
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j]) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        
        if (dp[amount] > amount) {
            return -1;
        }
        else {
            return dp[amount];
        }
    }
}
