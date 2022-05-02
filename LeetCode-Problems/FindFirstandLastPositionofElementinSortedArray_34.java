// 34. Find First and Last Position of Element in Sorted Array
// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/


class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        int[] result = new int[2];
        
        result[0] = startingIndex(nums, target);
        result[1] = endingIndex(nums, target);
        
        return result;
    }
    
    int startingIndex(int[] nums, int target) {
        int index = -1;
        
        int l = 0;
        int r = nums.length - 1;
        
        while (l <= r) {
            int m = l + (r - l) / 2;
            
            if (nums[m] >= target) {
                r = m - 1;
            }
            else {
                l = m + 1;
            }
            
            if (nums[m] == target) {
                index = m;
            }
        }
        
        return index;
    }
    
    int endingIndex(int[] nums, int target) {
        int index = -1;
        
        int l = 0;
        int r = nums.length - 1;
        
        while (l <= r) {
            int m = l + (r - l) / 2;
            
            if (nums[m] <= target) {
                l = m + 1;
            }
            else {
                r = m - 1;
            }
            
            if (nums[m] == target) {
                index = m;
            }
        }
        
        return index;
    }
}
