class Solution {
    public boolean dfs(int[][] adj,int[] visited,int node,int col){
        visited[node]=col;
        for(int adjNode:adj[node]){
            if(visited[adjNode]==-1){
                if(!dfs(adj,visited,adjNode,1-col)) return false;
                
            }
            else if(visited[adjNode]==col) return false;
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int[] visited=new int[n];
        Arrays.fill(visited,-1);
        for(int i=0;i<n;i++){
            if(visited[i]==-1) {
                if(!dfs(graph,visited,i,0)) return false;
            }     
        }
        return true;
    }
}
