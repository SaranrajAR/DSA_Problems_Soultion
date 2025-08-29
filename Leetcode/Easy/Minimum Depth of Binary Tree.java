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
    public int min;
    public boolean minFound;
    public void bfs(TreeNode root,int curr){
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            
            curr++;
            int n=q.size();
            for(int i=0;i<n;i++){
                TreeNode temp=q.poll();
                if(temp.left==null && temp.right==null){
                    min=curr;
                    return;
                    
                }
                if(temp.left!=null) q.offer(temp.left);
                if(temp.right!=null) q.offer(temp.right);
            }
        }
    }
    public int minDepth(TreeNode root) {
        if(root==null) return 0;
        min=Integer.MAX_VALUE;
        minFound=false;
        bfs(root,0);
        return min;
    }
}
