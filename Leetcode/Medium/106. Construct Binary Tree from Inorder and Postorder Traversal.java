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
    public TreeNode buildHelper(int[] postorder,int pStart,int pEnd,int[] inorder,int iStart,int iEnd,HashMap<Integer,Integer> inMap){
        if(iStart>iEnd || pStart>pEnd) return null;

        TreeNode root=new TreeNode(postorder[pEnd]);
        int inRoot=inMap.get(root.val);
        int leftValues=inRoot-iStart;
        root.left=buildHelper(postorder,pStart,pStart+leftValues-1,inorder,iStart,inRoot-1,inMap);
        root.right=buildHelper(postorder,pStart+leftValues,pEnd-1,inorder,inRoot+1,iEnd,inMap);
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer,Integer> inMap=new HashMap<>();
        int n=inorder.length;
        for(int i=0;i<n;i++){
            inMap.put(inorder[i],i);
        }
        return buildHelper(postorder,0,n-1,inorder,0,n-1,inMap);
    }
}
