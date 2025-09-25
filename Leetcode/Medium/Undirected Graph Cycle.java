class Pair{
    int curr;
    int prev;
    Pair(int curr,int prev){
        this.prev=prev;
        this.curr=curr;
    }
}
class Solution {
    
    public boolean checkCycle(ArrayList<Integer>[] adj,int[] visited,int i){
        Queue<Pair> queue=new LinkedList<>();
        queue.offer(new Pair(i,-1));
        visited[i]=1;
        while(!queue.isEmpty()){
            Pair temp=queue.poll();
            for(int val:adj[temp.curr]){
                if(visited[val]==0){
                    queue.offer(new Pair(val,temp.curr));
                    visited[val]=1;
                }
                else if(temp.prev!=val){
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        ArrayList<Integer>[] adj=new ArrayList[V];
        for(int i=0;i<V;i++){
            adj[i]=new ArrayList<>();
        }
        for(int[] edge:edges){
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }
        int[] visited=new int[V];
        for(int i=0;i<V;i++){
            
            if(visited[i]==0 && checkCycle(adj,visited,i)) return true;
        }
        return false;
    }
}
