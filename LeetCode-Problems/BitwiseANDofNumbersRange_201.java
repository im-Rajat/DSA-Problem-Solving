// 201. Bitwise AND of Numbers Range
// https://leetcode.com/problems/bitwise-and-of-numbers-range/


// Time Complexity = O(32)
class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        
        int shiftCount = 0;
        
        while (left != right) {
            left = left >> 1;
            right = right >> 1;
            shiftCount++;
        }
        
        return left << shiftCount;
    }
}
