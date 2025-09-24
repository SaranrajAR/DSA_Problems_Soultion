class Solution {
    public void bfs(int[][] adj,int[] visited,int i){
        Queue<Integer> queue=new LinkedList<>();
        queue.offer(i);
        visited[i]=1;
        while(!queue.isEmpty()){
            int temp=queue.poll();
            for(int j=1;j<visited.length;j++){
                if(j!=i && adj[temp-1][j-1]==1 && visited[j]==0){
                    visited[j]=1;
                    queue.offer(j);
                }
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        int[] visited=new int[n+1];
        Arrays.fill(visited,0);
        int ans=0;
        int i=1;
        for(int j=1;j<=n;j++){
            if(visited[j]==0){
                ans++;
                bfs(isConnected,visited,j);
            }
        }
        return ans;

    }
}
