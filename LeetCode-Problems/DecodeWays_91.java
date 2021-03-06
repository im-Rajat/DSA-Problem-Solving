// 91. Decode Ways
// https://leetcode.com/problems/decode-ways/


// Using Dynamic Programming
class Solution {
    public int numDecodings(String s) {
        
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int[] dp = new int[s.length() + 1];
        
        dp[0] = 1;  // empty string cam be decoded in 1 way
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        
        for (int i = 2; i <= s.length(); i++) {
            int singleDigit = Integer.valueOf(s.substring(i - 1, i));
            int doubleDigit = Integer.valueOf(s.substring(i - 2, i));
            
            if (singleDigit >= 1 && singleDigit <= 9) {
                dp[i] = dp[i] + dp[i - 1];
            }
            
            if (doubleDigit >= 10 && doubleDigit <= 26) {
                dp[i] = dp[i] + dp[i - 2];
            }
        }
        
        return dp[s.length()];
    }
}
