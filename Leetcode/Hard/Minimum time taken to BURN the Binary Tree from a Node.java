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
}  */
class Solution {
    public static int minTime(Node root, int target) {
        // code here
        Node tar=root;
        HashMap<Node,Node> parentMap=new HashMap<>();
        Queue<Node> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int n=queue.size();
            for(int i=0;i<n;i++){
                Node temp=queue.poll();
                
                if(temp.left!=null){
                    queue.offer(temp.left);
                    parentMap.put(temp.left,temp);
                }
                if(temp.right!=null){
                    queue.offer(temp.right);
                    parentMap.put(temp.right,temp);
                }
                if(temp.data==target) tar=temp;
            }
        }
        queue=new LinkedList<>();
        Set<Node> visited=new HashSet<>();
        queue.offer(tar);
        int ans=0;
        while(!queue.isEmpty()){
            int n=queue.size();
            for(int i=0;i<n;i++){
                Node temp=queue.poll();
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
            ans++;
        }
        return ans-1;
    }
}
