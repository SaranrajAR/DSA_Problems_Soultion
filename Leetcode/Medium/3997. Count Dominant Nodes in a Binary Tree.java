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
    int res;
    public int dfs(TreeNode root){
        if(root==null) return -1;
        int leftMax=dfs(root.left);
        int rightMax=dfs(root.right);
        int curr=root.val;
        if(curr>=leftMax && curr>=rightMax){
            res++;
            return curr;
        }
        return Math.max(leftMax,rightMax);
    }
    public int countDominantNodes(TreeNode root) {
        res=0;
        int max=dfs(root);
        return res;
    }
}
