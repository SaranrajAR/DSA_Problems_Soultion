// User function Template for Java
class Pair{
    int node;
    int weight;
    Pair(int node,int weight){
        this.node=node;
        this.weight=weight;
    }
}
class Solution {
    public void dfs(List<Pair>[] adj,int[] visited,Stack<Integer> stack,int node){
        visited[node]=1;
        
        for(Pair adjNode:adj[node]){
            if(visited[adjNode.node]==0) dfs(adj,visited,stack,adjNode.node);
        }
        stack.push(node);
    }
    public int[] shortestPath(int V, int E, int[][] edges) {
        // Code here
        List<Pair>[] adj=new List[V];
        int n=V;
        for(int i=0;i<n;i++){
            adj[i]=new ArrayList<>();
        }
        for(int[] edge:edges){
            int node=edge[0];
            int adjNode=edge[1];
            int wt=edge[2];
            adj[node].add(new Pair(adjNode,wt));
        }
        int[] visited=new int[n];
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<n;i++){
            if(visited[i]==0) dfs(adj,visited,stack,i);
        }
        
        int[] ans=new int[n];
        Arrays.fill(ans,Integer.MAX_VALUE);
        ans[0]=0;
        while(!stack.isEmpty()){
            int node=stack.pop();
            int dist=ans[node];
            if (ans[node] != Integer.MAX_VALUE) {
                for (Pair adjNode : adj[node]) {
                    int newDist = ans[node] + adjNode.weight;
                    if (ans[adjNode.node] > newDist)
                        ans[adjNode.node] = newDist;
                }
            }
        }
        for(int i=0;i<n;i++){
            if(ans[i]==Integer.MAX_VALUE) ans[i]=-1;
        }
        return ans;
    }
}
