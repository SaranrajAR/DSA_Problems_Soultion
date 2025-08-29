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
    List<List<Integer>> ans;
    public void dfs(TreeNode root,int tar,int curr,List<Integer> temp){
        if(root==null) return;
        curr+=root.val;
        temp.add(root.val);
        if(curr==tar && root.left==null && root.right==null){
            ans.add(new ArrayList<>(temp));
        }
        dfs(root.left,tar,curr,temp);
        dfs(root.right,tar,curr,temp);
        temp.remove(temp.size()-1);
        
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        ans=new ArrayList<>();
        dfs(root,targetSum,0,new ArrayList<>());
        return ans;

    }
}
