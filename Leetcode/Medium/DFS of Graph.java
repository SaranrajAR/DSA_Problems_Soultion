class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public void dfs(ArrayList<ArrayList<Integer>> adj,int[] visited,ArrayList<Integer> ans,int node){
        visited[node]=1;
        ans.add(node);
        for(int neighbour:adj.get(node)){
            if(visited[neighbour]==0) dfs(adj,visited,ans,neighbour);
        }
        
    }
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // Code here
        Stack<Integer> stack=new Stack<>();
        int n=adj.size();
        int[] visited=new int[n];
        Arrays.fill(visited,0);
        ArrayList<Integer> ans=new ArrayList<>();
        dfs(adj,visited,ans,0);
        return ans;
        
       
    }
}
