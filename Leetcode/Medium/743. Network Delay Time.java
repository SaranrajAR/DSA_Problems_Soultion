class Pair{
    int node;
    int dist;
    Pair(int node,int dist){
        this.node=node;
        this.dist=dist;
    }
}
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        List<Pair>[] adj=new List[n+1];
        for(int i=1;i<=n;i++){
            adj[i]=new ArrayList<>();
        }
        for(int[] edge:times){
            adj[edge[0]].add(new Pair(edge[1],edge[2]));
        }
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->a.dist-b.dist);
        int[] dist=new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k]=0;
        pq.offer(new Pair(k,0));
        while(!pq.isEmpty()){
            Pair temp=pq.poll();
            int node=temp.node;
            int dis=temp.dist;
            for(Pair adjNode:adj[node]){
                int newDist=dis+adjNode.dist;
                if(newDist<dist[adjNode.node]){
                    dist[adjNode.node]=newDist;
                    pq.offer(new Pair(adjNode.node,newDist));
                }
            }
        }
        int ans=-1;
        for(int i=1;i<=n;i++){
            if(dist[i]==Integer.MAX_VALUE) return -1;
            ans=Math.max(ans,dist[i]);
        }
        return ans;

    }
}
