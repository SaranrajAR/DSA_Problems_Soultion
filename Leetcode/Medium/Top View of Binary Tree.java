/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
*/
class Pair{
    Node node;
    int vertical;
    Pair(Node node,int vertical){
        this.node=node;
        this.vertical=vertical;
    }
}
class Solution {
    // Function to return a list of nodes visible from the top view
    // from left to right in Binary Tree.
    static ArrayList<Integer> topView(Node root) {
        // code here
        Queue<Pair> queue=new LinkedList<>();
        TreeMap<Integer,Integer> map=new TreeMap<>();
        queue.offer(new Pair(root,0));
        while(!queue.isEmpty()){
            int n=queue.size();
            for(int i=0;i<n;i++){
                Pair temp=queue.poll();
                int vertical=temp.vertical;
                if(temp.node.left!=null){
                    
                    queue.offer(new Pair(temp.node.left,vertical-1));
                    
                }
                if(temp.node.right!=null){
                    queue.offer(new Pair(temp.node.right,vertical+1));
                }
                if(!map.containsKey(vertical)){
                    map.put(vertical,temp.node.data);
                }
            }
        }
        ArrayList<Integer> ans=new ArrayList<>();
        
        for(int key:map.keySet()){
            ans.add(map.get(key));
        }
        return ans;
        
    }
}
