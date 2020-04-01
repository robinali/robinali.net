/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private boolean isValidBST(TreeNode node, Integer lower, Integer upper) {
        if(node == null) return true;
        
        if(lower != null && node.val <= lower) return false;
        if(upper != null && node.val >= upper) return false;
        if(!isValidBST(node.right, node.val, upper)) return false;
        if(!isValidBST(node.left, lower, node.val)) return false;
        return true;
    }
    
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }
}