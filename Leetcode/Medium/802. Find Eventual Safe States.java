class Solution {
    public boolean dfs(int node,int[][] graph,int[] visited,int[] pathVisited,List<Integer> safeNodes){
        visited[node]=1;
        pathVisited[node]=1;
        for(int adjNode:graph[node]){
            if(visited[adjNode]==0){
                if(!dfs(adjNode,graph,visited,pathVisited,safeNodes)){
                    return false;
                }
            }
            else if(pathVisited[adjNode]==1) return false;
        }
        pathVisited[node]=0;
        safeNodes.add(node);
        return true;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n=graph.length;
        int[] visited=new int[n];
        int[] pathVisited=new int[n];
        List<Integer> safeNodes=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(visited[i]==0) dfs(i,graph,visited,pathVisited,safeNodes);
        }
        Collections.sort(safeNodes);
        return safeNodes;

    }
}
