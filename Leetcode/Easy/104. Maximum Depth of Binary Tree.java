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
    int maxDepth;
    public void dfs(TreeNode root,int curr){
        if(root==null) return;
        dfs(root.left,curr+1);
        maxDepth=Math.max(maxDepth,curr+1);
        dfs(root.right,curr+1);
        maxDepth=Math.max(maxDepth,curr+1);
    }
    public int maxDepth(TreeNode root) {
        maxDepth=0;
        if(root==null) return 0;
        dfs(root,0);
        return maxDepth;
    }
}
