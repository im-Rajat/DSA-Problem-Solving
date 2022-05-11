// 47. Permutations II
// https://leetcode.com/problems/permutations-ii/


// Using BackTracking
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<>();
        
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        
        BackTracking(nums, visited, new ArrayList<>(), result);
        
        return result;
    }
    
    private void BackTracking(int[] nums, boolean[] visited, List<Integer> curr, List<List<Integer>> result) {
        if (curr.size() == nums.length) {
            result.add(new ArrayList<>(curr));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            if (i > 0 && nums[i - 1] == nums[i] && !visited[i - 1]) {
                continue;
            }
            
            curr.add(nums[i]);
            visited[i] = true;
            BackTracking(nums, visited, curr, result);
            visited[i] = false;
            curr.remove(curr.size() - 1);
        }
    }
}
