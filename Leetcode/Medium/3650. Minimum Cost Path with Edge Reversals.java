class Pair{
    int node;
    int cost;
    Pair(int node,int cost){
        this.node=node;
        this.cost=cost;
    }
}
class Solution {
    public int minCost(int n, int[][] edges) {
        List<Pair>[] adj=new List[n];
        for(int i=0;i<n;i++) adj[i]=new ArrayList<>();
        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];
            int w=edge[2];
            adj[u].add(new Pair(v,w));
            adj[v].add(new Pair(u,2*w));
        }
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->a.cost-b.cost);
        pq.offer(new Pair(0,0));
        int[] dist=new int[n];
        Arrays.fill(dist,(int) 1e9);
        while(!pq.isEmpty()){
            Pair temp=pq.poll();
            int u=temp.node;
            int w=temp.cost;
            for(Pair adjNode:adj[u]){
                int v=adjNode.node;
                int cost=w+adjNode.cost;
                if(cost<dist[v]){
                    dist[v]=cost;
                    pq.add(new Pair(v,cost));
                }
            }
        }
        if(dist[n-1]==(int) 1e9) return -1;
        return dist[n-1];
        
    }
}
