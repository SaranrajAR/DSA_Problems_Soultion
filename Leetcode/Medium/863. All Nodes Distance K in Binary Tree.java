/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ans=new ArrayList<>();
        if(root==null) return ans;
        HashMap<TreeNode,TreeNode> parentMap=new HashMap<>();
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int n=queue.size();
            for(int i=0;i<n;i++){
                TreeNode temp=queue.poll();
                if(temp.left!=null){
                    queue.offer(temp.left);
                    parentMap.put(temp.left,temp);
                }
                if(temp.right!=null){
                    queue.offer(temp.right);
                    parentMap.put(temp.right,temp);
                }
            }
        }
        queue=new LinkedList<>();
        Set<TreeNode> visited=new HashSet<>();
        queue.offer(target);
        while(k>0){
            int n=queue.size();
            for(int i=0;i<n;i++){
                TreeNode temp=queue.poll();
                visited.add(temp);
                if(parentMap.containsKey(temp) && !visited.contains(parentMap.get(temp))){
                    queue.offer(parentMap.get(temp));
                }
                if(temp.left!=null && !visited.contains(temp.left)){
                    queue.offer(temp.left);
                }
                if(temp.right!=null && !visited.contains(temp.right)){
                    queue.offer(temp.right);
                }
            }
            k--;
        }
        while(!queue.isEmpty()){
            ans.add(queue.poll().val);
        }
        return ans;
    }
}
