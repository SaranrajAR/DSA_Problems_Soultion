class Solution {
    int ans;
    public long dfs(int node,List<Integer>[] adj,int[] visited,int k,int[] values){
        visited[node]=1;
        long sum=values[node];

        for(int adjNode:adj[node]){
            if(visited[adjNode]==0){
                sum+=dfs(adjNode,adj,visited,k, values);
            }
        }
        if(sum%k==0){
            ans++;
            return 0;
        }
        return sum;

    }
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        ans=0;
        List<Integer>[] adj=new List[n];
        for(int i=0;i<n;i++){
            adj[i]=new ArrayList<>();
        }
        for(int[] edge:edges){
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }
        int[] visited=new int[n];
        for(int i=0;i<n;i++){
            if(visited[i]==0) dfs(i,adj,visited,k,values);
        }
        
        return ans;
    }
}
