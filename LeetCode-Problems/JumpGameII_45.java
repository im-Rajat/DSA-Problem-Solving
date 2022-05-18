// 45. Jump Game II
// https://leetcode.com/problems/jump-game-ii/


class Solution {
    public int jump(int[] nums) {
        
        int end = 0, farthest = 0, jump = 0;
        
        for (int start = 0; start < nums.length - 1; start++) {
            farthest = Math.max(farthest, start + nums[start]);
            
            if (start == end) {
                jump++;
                end = farthest;
            }
        }
        
        return jump;
    }
}
