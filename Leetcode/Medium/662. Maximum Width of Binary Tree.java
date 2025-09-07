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

class Pair{
    TreeNode root;
    int idx;
    Pair(TreeNode root,int idx){
        this.root=root;
        this.idx=idx;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> queue=new LinkedList<>();
        queue.offer(new Pair(root,0));
        int maxWidth=0;
        while(!queue.isEmpty()){
            int minIdx=queue.peek().idx;
            int n=queue.size();
            int first=0,last=0;
            for(int i=0;i<n;i++){
                TreeNode temp=queue.peek().root;
                int idx=queue.peek().idx;
                idx=idx-minIdx;
                if(i==0) first=idx;
                if(i==n-1) last=idx;
                
               
                if(temp.left!=null){
                    queue.offer(new Pair(temp.left,(2*idx)+1));
                }
                if(temp.right!=null){
                    queue.offer(new Pair(temp.right,(2*idx)+2));
                }
                queue.poll();
            }
            maxWidth=Math.max(maxWidth,last-first+1);

        }

        return maxWidth;
    }
}
