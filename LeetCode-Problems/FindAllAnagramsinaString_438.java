// 438. Find All Anagrams in a String
// https://leetcode.com/problems/find-all-anagrams-in-a-string/


// Using 2 HashMap (Frequency Array)
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        List<Integer> result = new ArrayList<>();
        
        int sLen = s.length();
        int pLen = p.length();
        
        if (sLen < pLen) {
            return result;
        }
        
        
        int[] pHash = new int[26];
        int[] sHash = new int[26];
        
        for (int i = 0; i < pLen; i++) {
            pHash[p.charAt(i) - 'a']++;
            sHash[s.charAt(i) - 'a']++;
        }
        
        if (areEqual(sHash, pHash)) {
            result.add(0);
        }
        
        for (int i = pLen; i < sLen; i++) {
            sHash[s.charAt(i) - 'a']++;
            sHash[s.charAt(i - pLen) - 'a']--;
            if (areEqual(sHash, pHash)) {
                result.add(i - pLen + 1);
            }
        }
        
        return result;
    }
    
    public boolean areEqual(int[] sHash, int[] pHash) {
        for (int i = 0; i < 26; i++) {
            if (sHash[i] != pHash[i]) {
                return false;
            }
        }
        return true;
    }
}
