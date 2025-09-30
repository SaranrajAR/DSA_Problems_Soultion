class Solution {
    public boolean dfs(int node,List<Integer>[] adj,int[] visited,int[] pathVisited){
        visited[node]=1;
        pathVisited[node]=1;
        for(int adjNode:adj[node]){
            if(visited[adjNode]==0){
                if(dfs(adjNode,adj,visited,pathVisited)) return true;
            }
            else if(pathVisited[adjNode]==1) return true;
        }
        pathVisited[node]=0;
        return false;
    }
    public boolean isCyclic(int V, int[][] edges) {
        // code here
        int[] visited=new int[V];
        int[] pathVisited=new int[V];
        List<Integer>[] adj=new List[V];
        for(int i=0;i<V;i++){
            adj[i]=new ArrayList<>();
        }
        for(int[] edge:edges){
            adj[edge[0]].add(edge[1]);
        }
        for(int i=0;i<V;i++){
            if(visited[i]==0 && dfs(i,adj,visited,pathVisited)) return true;
        }
        return false;
        
    }
}
