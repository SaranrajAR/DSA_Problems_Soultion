// class Pair{
//     int node;
//     int cost;
//     Pair(int node,int cost){
//         this.node=node;
//         this.cost=cost;
//     }
// }
class Solution {
    public int diji(int[][] adjMat,int src,int dst){
        // PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->a.cost-b.cost);
        // int[] dist=new int[26];
        // Arrays.fill(dist,(int) 1e9);
        // pq.offer(new Pair(src,0));
        // while(!pq.isEmpty()){
        //     Pair top=pq.poll();
        //     int u=top.node;
        //     int w=top.cost;
        //     for(Pair adjNode:adj[u]){
        //         int v=adjNode.node;
        //         int cost=w+adjNode.cost;
        //         if(cost<dist[v]){
        //             dist[v]=cost;
        //             pq.offer(new Pair(v,cost));
        //         }
        //     }
        // }
        return adjMat[src][dst]==(int) 1e9?-1:adjMat[src][dst];
    }
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        long res=0;
        // List<Pair>[] adj=new List[26];
        // for(int i=0;i<26;i++) adj[i]=new ArrayList<>();
        int[][] adjMat=new int[26][26];
        for(int i=0;i<26;i++) {
            Arrays.fill(adjMat[i],(int) 1e9);
            adjMat[i][i]=0;
        }    
        for(int i=0;i<original.length;i++){
            int u=original[i]-'a';
            int v=changed[i]-'a';
            int w=cost[i];
            adjMat[u][v]=Math.min(w,adjMat[u][v]);
        }
        for(int via=0;via<26;via++){ //floyd warshall alg
            for(int i=0;i<26;i++){
                for(int j=0;j<26;j++){
                    if(adjMat[i][via]<(int) 1e9 && adjMat[via][j]<(int) 1e9){
                        adjMat[i][j]=Math.min(adjMat[i][j],(adjMat[i][via]+adjMat[via][j]));

                    }
                }
            }
        }
        

        for(int i=0;i<source.length();i++){
            int src=source.charAt(i)-'a';
            int dst=target.charAt(i)-'a';
            if(src==dst) continue;
            int curr=diji(adjMat,src,dst);
            if(curr==-1) return -1;
            res+=curr;
        }
        return res;

    }
}
