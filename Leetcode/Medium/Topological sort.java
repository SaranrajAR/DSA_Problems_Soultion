class Solution {
    public static void dfs(int node,List<Integer>[] adj,int[] visited,Stack<Integer> stack){
        visited[node]=1;
        for(int adjNode:adj[node]){
            if(visited[adjNode]==0) dfs(adjNode,adj,visited,stack);
        }
        stack.push(node);
    }
    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        Stack<Integer> stack=new Stack<>();
        List<Integer>[] adj=new List[V];
        for(int i=0;i<V;i++){
            adj[i]=new ArrayList<>();
        }
        for(int[] edge:edges){
            adj[edge[0]].add(edge[1]);
        }
        int[] visited=new int[V];
        for(int i=0;i<V;i++){
            if(visited[i]==0) dfs(i,adj,visited,stack);
        }
        ArrayList<Integer> ans=new ArrayList<>();
        while(!stack.isEmpty()){
            ans.add(stack.pop());
        }
        return ans;
        
    }
}
