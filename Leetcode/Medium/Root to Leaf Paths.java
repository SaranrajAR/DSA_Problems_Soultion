/*

Definition for Binary Tree Node
class Node
{
    int data;
    Node left;
    Node right;

    Node(int data)
    {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    public static void dfs(Node root,ArrayList<Integer> list,ArrayList<ArrayList<Integer>> ans){
        if(root==null) return;
        list.add(root.data);
        if(root.left==null && root.right==null){
            ans.add(new ArrayList<>(list));
        }
        else{
            dfs(root.left,list,ans);
            dfs(root.right,list,ans);
        }
        
        list.remove(list.size()-1);
    }
    public static ArrayList<ArrayList<Integer>> Paths(Node root) {
        // code here
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
       
        dfs(root,new ArrayList<>(),ans);
        
        return ans;
    }
}
