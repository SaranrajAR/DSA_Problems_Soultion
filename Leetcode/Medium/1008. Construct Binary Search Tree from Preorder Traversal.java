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
    int i;
    public TreeNode buildTree(int[] preOrder,int bound){
        if(i==preOrder.length || preOrder[i]>bound) return null;
        TreeNode root=new TreeNode(preOrder[i++]);
        root.left=buildTree(preOrder,root.val);
        root.right=buildTree(preOrder,bound);
        return root;
    }
    public TreeNode bstFromPreorder(int[] preOrder) {
        int i=0;
        return buildTree(preOrder,Integer.MAX_VALUE);
    }
}
