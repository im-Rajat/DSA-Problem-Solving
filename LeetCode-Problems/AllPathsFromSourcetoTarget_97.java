// 97. All Paths From Source to Target
// https://leetcode.com/problems/all-paths-from-source-to-target/


// Using DFS (Backtracking)
class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        
        DFS(graph, 0, path, result);
        
        return result;
    }
    
    public void DFS(int[][] graph, int node, List<Integer> path, List<List<Integer>> result) {
        path.add(node);
        
        if (node == graph.length - 1) {
            result.add(new ArrayList<Integer>(path));
            return;
        }
        
        for (int nextNode : graph[node]) {
            DFS(graph, nextNode, path, result);
            path.remove(path.size() - 1);
        }
        
    }
}
