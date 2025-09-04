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
    TreeMap<Integer,TreeMap<Integer,List<Integer>>> map;
    public void dfs(TreeNode root,int width,int depth){
        if(root==null) return;
        if(!map.containsKey(width)){
            List<Integer> temp=new ArrayList<>();
            temp.add(root.val);
            TreeMap<Integer,List<Integer>> t=new TreeMap<>();
            t.put(depth,temp); 
            map.put(width,t);
        }
        else{
            if(!map.get(width).containsKey(depth)){
                List<Integer> temp=new ArrayList<>();
                temp.add(root.val);
                map.get(width).put(depth,temp);
            }
            else{
                map.get(width).get(depth).add(root.val);
            }
        }
        dfs(root.left,width-1,depth+1);
        dfs(root.right,width+1,depth+1);

        
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        map=new TreeMap<>();
        List<List<Integer>> ans=new ArrayList<>();
        dfs(root,0,0);
        System.out.print(map);
        for(int key:map.keySet()){
            List<Integer> temp=new ArrayList<>();
            TreeMap<Integer,List<Integer>> m=map.get(key);
            for(int k:m.keySet()){
                Collections.sort(m.get(k));
                for(int val:m.get(k)){
                    temp.add(val);
                }
            }
            ans.add(new ArrayList<>(temp));
        }
        return ans;

    }
}
