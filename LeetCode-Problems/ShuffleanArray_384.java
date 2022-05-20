// 384. Shuffle an Array
// https://leetcode.com/problems/shuffle-an-array/


class Solution {

    private int[] numsArray;
    private int[] original;
    
    private Random rand = new Random();
    
    private int randRange(int min, int max) {
        return rand.nextInt(max - min) + min;
    }
    
    private void swapNum(int i, int j) {
        int temp = numsArray[i];
        numsArray[i] = numsArray[j];
        numsArray[j] = temp;
    }
    
    public Solution(int[] nums) {
        numsArray = nums;
        original = nums.clone();
    }
    
    public int[] reset() {
        numsArray = original;
        original = original.clone();
        return original;
    }
    
    public int[] shuffle() {
        for (int i = 0; i < numsArray.length; i++) {
            swapNum(i, randRange(i, numsArray.length));
        }
        
        return numsArray;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
