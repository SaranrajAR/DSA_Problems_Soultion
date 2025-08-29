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
    public boolean isTrue;
    public void dfs(TreeNode root,int tar,int curr){
        if(root==null) return;
        if(isTrue) return;
        curr+=root.val;
        if(curr==tar && root.left==null && root.right==null){
            isTrue=true;
            return;
        }
        dfs(root.left,tar,curr);
        dfs(root.right,tar,curr);

    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        isTrue=false;
        dfs(root,targetSum,0);
        return isTrue;
    }
}
