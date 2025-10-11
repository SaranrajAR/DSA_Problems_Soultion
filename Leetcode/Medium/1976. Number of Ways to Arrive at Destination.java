class Pair{
    int node;
    long weight;
    Pair(int node,long weight){
        this.node=node;
        this.weight=weight;
    }
}
class Solution {
    public int countPaths(int n, int[][] roads) {
        List<Pair>[] adj=new List[n];
        int MOD=1000000007;
        for(int i=0;i<n;i++) adj[i]=new ArrayList<>();
        for(int[] edge:roads){
            adj[edge[0]].add(new Pair(edge[1],edge[2]));
            adj[edge[1]].add(new Pair(edge[0],edge[2]));
        }
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->Long.compare(a.weight,b.weight));
        long[] dist=new long[n];
        int[] ways=new int[n];
        Arrays.fill(dist,Long.MAX_VALUE);
        dist[0]=0;
        ways[0]=1;
        pq.offer(new Pair(0,0));
        while(!pq.isEmpty()){
            Pair temp=pq.poll();
            long weight=temp.weight;
            int node=temp.node;
            
            for(Pair adjNode:adj[node]){
                long newWeight=weight+adjNode.weight;
                if(newWeight<dist[adjNode.node]){
                    dist[adjNode.node]=newWeight;
                    ways[adjNode.node]=ways[node];
                    pq.offer(new Pair(adjNode.node,newWeight));
                }
                else if(newWeight==dist[adjNode.node]){
                    ways[adjNode.node]=(ways[node]+ways[adjNode.node])%MOD;
                }
            }

        }
        return ways[n-1]%MOD;

        
    }
}
