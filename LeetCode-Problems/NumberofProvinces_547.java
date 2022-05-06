// 547. Number of Provinces
// https://leetcode.com/problems/number-of-provinces/


// Using DFS
class Solution {
    
    private int n;
    
    public int findCircleNum(int[][] isConnected) {
        
        n = isConnected.length;
        int count = 0;
        
        for (int i = 0; i < n; i++) {
            if (isConnected[i][i] == 1) {
                count++;
                DFS(isConnected, i);
            }
        }
        
        return count;
    }
    
    public void DFS(int[][] isConnected, int i) {
        isConnected[i][i] = 0;
        
        for (int j = 0; j < n; j++) {
            if (isConnected[i][j] == 1) {
                isConnected[i][j] = 0;
                if (isConnected[j][j] == 1) {
                    DFS(isConnected, j);
                }
            }
        }
    }
    
}
