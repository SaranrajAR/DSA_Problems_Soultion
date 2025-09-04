/************************************************************

 Following is the Binary Tree node structure:

 class TreeNode {
     int data;
     TreeNode left;
     TreeNode right;

     TreeNode(int data) {
         this.data = data;
         this.left = null;
         this.right = null;
     }
 }

 ************************************************************/
import java.util.*;
import java.util.List;

public class Solution {
    // public static List<Integer> ans;
    public static boolean isLeaf(TreeNode root){
        if(root.left==null && root.right==null) return true;
        return false;
    }
    public static void right(TreeNode root,List<Integer> temp){
        if(root==null) return;
        if(isLeaf(root)) return;
        temp.add(root.data);
        if(root.right!=null) right(root.right,temp);
        else right(root.left,temp);
    }
    public static void leaf(TreeNode root,List<Integer> ans){
        if(root==null) return;
        if(isLeaf(root)){
            ans.add(root.data);
            return;
        }
        leaf(root.left,ans);
        leaf(root.right,ans);
    }
    public static void left(TreeNode root,List<Integer> ans){
        if(root==null) return;
        if(isLeaf(root)) return;
        ans.add(root.data);
        if(root.left!=null) left(root.left,ans);
        else left(root.right,ans);
    }
    public static List<Integer> traverseBoundary(TreeNode root){
        List<Integer> ans=new ArrayList<>();
        
        if(root==null) return ans;
        if(!isLeaf(root)) ans.add(root.data);
        if(root.left!=null) left(root.left,ans);
        leaf(root,ans);
        List<Integer> temp=new ArrayList<>();
        if(root.right!=null )right(root.right,temp);
        Collections.reverse(temp);
        for(int t:temp){
            ans.add(t);
        }
        return ans;
        
    }
}
