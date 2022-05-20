// 202. Happy Number
// https://leetcode.com/problems/happy-number/


// Using Set
class Solution {
    
    int sum(int num) {
        int prod = 0;
        while (num >= 1) {
            int div = num % 10;
            num = num / 10;
            prod = prod + (div * div);
           
        }
        
        return prod;
    }
    
    public boolean isHappy(int n) {
        
        if (n == 1) {
            return true;
        }
        
        HashSet<Integer> set = new HashSet<>();
        
        int num = n;
        
        while (num != 1) {
            if (set.contains(num) == true) {
                return false;
            }
            set.add(num);
            num = sum(num);
        }
        
        return true;
    }
}
