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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans=new ArrayList<>();
        if(root==null) return ans;
        Queue<TreeNode> queue=new LinkedList<>();
        
        queue.offer(root);
        while(!queue.isEmpty()){
            int n=queue.size();
            double curr=0;
            for(int i=0;i<n;i++){
                TreeNode temp=queue.poll();
                curr+=temp.val;
                if(temp.left!=null) queue.offer(temp.left);
                if(temp.right!=null) queue.offer(temp.right);
                
            }
            curr=curr/n;
            ans.add(curr);
        }
        return ans;
    }
}
