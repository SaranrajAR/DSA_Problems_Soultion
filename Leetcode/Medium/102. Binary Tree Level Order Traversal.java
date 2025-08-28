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
    Queue<TreeNode> queue;
    List<List<Integer>> list;
    public void bfs(TreeNode root){
        TreeNode temp=root;
        while(!queue.isEmpty()){
            int levelSize=queue.size();
            List<Integer> subList=new ArrayList<>();
            for(int i=0;i<levelSize;i++){
                if(queue.peek().left!=null) queue.offer(queue.peek().left);
                if(queue.peek().right!=null) queue.offer(queue.peek().right);
                subList.add(queue.poll().val);

            }
            list.add(subList);
        }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        queue=new LinkedList<>();
        list=new ArrayList<>();
        if(root==null) return list;
        queue.offer(root);
        bfs(root);
        return list;
        
    }
}
