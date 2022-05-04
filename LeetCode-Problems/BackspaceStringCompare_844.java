// 844. Backspace String Compare
// https://leetcode.com/problems/backspace-string-compare/


// Using 2 Pointers
class Solution {
    public boolean backspaceCompare(String s, String t) {
        
        int sPtr = s.length() - 1;
        int tPtr = t.length() - 1;
        int sSkip = 0;
        int tSkip = 0;
        
        while (sPtr >= 0 || tPtr >= 0) {
            while (sPtr >= 0) {
                if (s.charAt(sPtr) == '#') {
                    sSkip++;
                    sPtr--;
                }
                else if (sSkip > 0) {
                    sPtr--;
                    sSkip--;
                }
                else {
                    break;
                }
            }
            
            while (tPtr >= 0) {
                if (t.charAt(tPtr) == '#') {
                    tSkip++;
                    tPtr--;
                }
                else if (tSkip > 0) {
                    tPtr--;
                    tSkip--;
                }
                else {
                    break;
                }
            }
            
            if (sPtr >= 0 && tPtr >= 0 && s.charAt(sPtr) != t.charAt(tPtr)) {
                return false;
            }
            
            if ((sPtr >= 0) != (tPtr >= 0)) {
                return false;
            }
            
            sPtr--;
            tPtr--;
        }
        
        return true;
    }
}


/*
// Using Stack, Time : O(m + n), Space : O(m + n)
class Solution {
    public boolean backspaceCompare(String s, String t) {
        
        String new_s = usingStack(s);
        String new_t = usingStack(t);
        
        if (new_s.equals(new_t)) {
            return true;
        }
        else {
            return false;
        }
    }
    
    public String usingStack(String s) {
        
        Stack<Character> st = new Stack<>();
        
        for (char c : s.toCharArray()) {
            if (c != '#') {
                st.push(c);
            }
            else if (st.empty() == false) {
                st.pop();
            }
        }
        
        return String.valueOf(st);
    }
}
*/
