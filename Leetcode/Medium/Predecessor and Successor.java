/* BST Node
class Node {
    int data;
    Node left, right;
    Node(int x) {
        data = x;
        left = right = null;
    }
} */

class Solution {
    public ArrayList<Node> findPreSuc(Node root, int key) {
        // code here
        Node successor=new Node(-1);
        Node curr=root;
        while(curr!=null){
            if(curr.data>key){
                successor=curr;
                curr=curr.left;
            }
            else{
                curr=curr.right;
            }
        }
        
        Node predecessor=new Node(-1);
        curr=root;
        while(curr!=null){
            if(curr.data<key){
                predecessor=curr;
                curr=curr.right;
            }
            else{
                curr=curr.left;
            }
        }
        ArrayList<Node> ans=new ArrayList<>();
        ans.add(predecessor);
        ans.add(successor);
        
        return ans;
    }
}
