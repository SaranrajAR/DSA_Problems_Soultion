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
    boolean isFalse;
    public int dfs(TreeNode root){
        if(root==null) return 0;
        if(!isFalse) return -1;
        int lh=dfs(root.left);
        int rh=dfs(root.right);
        if(Math.abs(lh-rh)>1){
            isFalse=false;
            return -1;
        }

        return 1+Math.max(lh,rh);
    }
    public boolean isBalanced(TreeNode root) {
        isFalse=true;
        dfs(root);
        return isFalse;
    }
}
