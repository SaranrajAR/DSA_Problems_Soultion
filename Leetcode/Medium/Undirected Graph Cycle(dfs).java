
class Solution {
    public boolean dfs(ArrayList<Integer>[] adj,int[] visited,int node,int parent){
        visited[node]=1;
        for(int adjacentNode:adj[node]){
            if(visited[adjacentNode]==0){
                if(dfs(adj,visited,adjacentNode,node)) return true;
            }
            else if(adjacentNode!=parent) return true;
        }
        return false;
        
    }
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        ArrayList<Integer>[] adj=new ArrayList[V];
        int[] visited=new int[V];
        for(int i=0;i<V;i++){
            adj[i]=new ArrayList<>();
            
        }
        for(int[] edge:edges){
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }
        for(int i=0;i<V;i++){
            if(visited[i]==0 && dfs(adj,visited,i,-1)) return true;
        }
        return false;
    }
}
