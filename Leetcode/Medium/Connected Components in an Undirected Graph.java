
class Solution {
    public void bfs(ArrayList<Integer>[] adj,int[] visited,int i,ArrayList<ArrayList<Integer>> ans){
        Queue<Integer> queue=new LinkedList<>();
        queue.offer(i);
        visited[i]=1;
        ArrayList<Integer> curr=new ArrayList<>();
        while(!queue.isEmpty()){
            int temp=queue.poll();
            
            curr.add(temp);
            
            for(int t:adj[temp]){
                if(visited[t]==0){
                    queue.offer(t);
                    visited[t]=1;
                }
                
            }
        }
        ans.add(curr);
    }
    
    public ArrayList<ArrayList<Integer>> getComponents(int V, int[][] edges) {
        // code here
        int[] visited=new int[V];
        
        ArrayList<Integer>[] adj=new ArrayList[V];
        for(int i=0;i<V;i++){
            adj[i]=new ArrayList<>();
        }
        for(int[] edge:edges){
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }
        
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        
        
        Arrays.fill(visited,0);
        for(int i=0;i<V;i++){
            if(visited[i]!=1){
                bfs(adj,visited,i,ans);
            }
        }
        
        return ans;
    }
    
}
