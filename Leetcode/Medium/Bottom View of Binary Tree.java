/*
class Node
{
    int data; //data of the node
    int hd; //horizontal distance of the node
    Node left, right; //left and right references

    // Constructor of tree node
    public Node(int key)
    {
        data = key;
        hd = Integer.MAX_VALUE;
        left = right = null;
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
    public ArrayList<Integer> bottomView(Node root) {
        // Code here
        TreeMap<Integer,Integer> map=new TreeMap<>();
        Queue<Pair> queue=new LinkedList<>();
        queue.offer(new Pair(root,0));
        while(!queue.isEmpty()){
            int n=queue.size();
            for(int i=0;i<n;i++){
                Pair temp=queue.poll();
                int vertical=temp.vertical;
                if(temp.node.left!=null) queue.offer(new Pair(temp.node.left,vertical-1));
                if(temp.node.right!=null) queue.offer(new Pair(temp.node.right,vertical+1));
                map.put(vertical,temp.node.data);
            }
        }
        ArrayList<Integer> ans=new ArrayList<>();
        for(int key:map.keySet()){
            ans.add(map.get(key));
        }
        return ans;
        
    }
}
