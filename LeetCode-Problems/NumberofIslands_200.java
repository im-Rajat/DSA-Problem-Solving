// 200. Number of Islands
// https://leetcode.com/problems/number-of-islands/


// Using DFS
class Solution {
    public int numIslands(char[][] grid) {
        
        int count = 0;
        
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                if (grid[r][c] == '1') {
                    count++;
                    DFS(grid, r, c);
                }
            }
        }
        
        return count;
    }
    
    public void DFS(char[][] grid, int r, int c) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[r].length || grid[r][c] == '0') {
            return;
        }
        
        grid[r][c] = '0';
        DFS(grid, r - 1, c);
        DFS(grid, r, c - 1);
        DFS(grid, r + 1, c);
        DFS(grid, r, c + 1);
    }
}
