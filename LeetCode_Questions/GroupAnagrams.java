// 49. Group Anagrams
// https://leetcode.com/problems/group-anagrams/


class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        List<List<String>> result = new ArrayList<>();

        HashMap<HashMap<Character, Integer>, ArrayList<String>> hashmap = new HashMap<>();

        for (String str : strs) {
            HashMap<Character, Integer> map = new HashMap<>();

            for (char c : str.toCharArray()) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }

            if (hashmap.containsKey(map) == false) {
                ArrayList<String> list = new ArrayList<>();
                list.add(str);
                hashmap.put(map, list);
            } else {
                ArrayList<String> list = hashmap.get(map);
                list.add(str);
                hashmap.put(map, list);
            }

        }

        for (ArrayList<String> val : hashmap.values()) {
            result.add(val);
        }

        return result;
    }
}
