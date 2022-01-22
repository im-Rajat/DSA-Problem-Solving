// 101. Symmetric Tree
// https://leetcode.com/problems/symmetric-tree/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        
        return checkSymmetric(root, root);
    }
    
    public boolean checkSymmetric(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null) {
            return true;
        }
        
        if(root1 != null && root2 != null && root1.val == root2.val && checkSymmetric(root1.left, root2.right) && checkSymmetric(root1.right, root2.left)){
            return true;
        }
        else {
            return false;
        }
    
    }
}
