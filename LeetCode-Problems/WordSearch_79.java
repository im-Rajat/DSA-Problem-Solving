// 79. Word Search
// https://leetcode.com/problems/word-search/


// Using Backtracking
class Solution {
    public boolean exist(char[][] board, String word) {
        
        int rows = board.length;
        int cols = board[0].length;
        
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (board[r][c] == word.charAt(0) && isWordExist(board, word, r, c, 0)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    private boolean isWordExist(char[][] board, String word, int r, int c, int count) {
        if (count == word.length()) {
            return true;
        }
        
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] != word.charAt(count)) {
            return false;
        }
        
        char temp = board[r][c];
        board[r][c] = '*';
        boolean result =  isWordExist(board, word, r + 1, c, count + 1) ||
               isWordExist(board, word, r - 1, c, count + 1) ||
               isWordExist(board, word, r, c + 1, count + 1) ||
               isWordExist(board, word, r, c - 1, count + 1);
        
        board[r][c] = temp;
        
        return result;
    }
}
