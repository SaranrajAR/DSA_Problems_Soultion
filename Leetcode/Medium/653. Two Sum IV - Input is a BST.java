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
class BSTIterator{
    boolean isReverse;
    Stack<TreeNode> stack;
    BSTIterator(TreeNode root,boolean isReverse){
        this.stack=new Stack<>();
        this.isReverse=isReverse;
        pushAll(root);
    }

    public int next(){
        TreeNode root=stack.pop();
        int ans=root.val;
        if(isReverse) pushAll(root.left);
        else pushAll(root.right);
        return ans;
    }
    public boolean hasNext(){
        return !stack.isEmpty();
    }

    public void pushAll(TreeNode root){
        while(root!=null){
            stack.push(root);
            if(isReverse){
                root=root.right;
            }
            else{
                root=root.left;
            }
        }
    }
} 
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        if(root==null) return false;
        BSTIterator l=new BSTIterator(root,false);
        BSTIterator r=new BSTIterator(root,true);
        int i=l.next();
        int j=r.next(); //r.before()

        while(i<j){
            int sum=i+j;
            if(sum == k) return true;
            if(sum > k) j=r.next();
            else i=l.next();
        }
        return false;

    }
}
