// 130. Surrounded Regions
// https://leetcode.com/problems/surrounded-regions/


// DFS (Recursion)
class Solution {
    public void solve(char[][] board) {
        
        int rows = board.length;
        int cols = board[0].length;
        
        for (int r = 0; r < rows; r++) {
            for (int c  = 0; c < cols; c++) {
                if (r == 0 || r == rows - 1 || c == 0 || c == cols - 1) {
                    if (board[r][c] == 'O') {
                        DFS(board, r, c);
                    }
                }
            }
        }
        
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (board[r][c] == 'O') {
                    board[r][c] = 'X';
                }
                else if (board[r][c] == '*') {
                    board[r][c] = 'O';
                }
            }
        }
    }
    
    public void DFS(char[][] board, int row, int col) {
        board[row][col] = '*';
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        
        for (int[] d : dir) {
            int r = row + d[0];
            int c = col + d[1];
            
            if (r >= 0 && c >= 0 && r < board.length && c < board[0].length && board[r][c] == 'O') {
                DFS(board, r, c);
            }
        }
    }
}
