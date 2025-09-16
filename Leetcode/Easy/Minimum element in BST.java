/*
class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/
class Solution {
    // Function to find the minimum element in the given BST.
    int minValue(Node root) {
        // code here
        int min=0;
        while(root!=null){
            min=root.data;
            root=root.left;
        }
        return min;
    }
}
