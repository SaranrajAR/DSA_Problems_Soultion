class Pair{
    int node;
    int dist;
    Pair(int node,int dist){
        this.node=node;
        this.dist=dist;
    }
}
class Solution {
    public int[] shortestPath(ArrayList<ArrayList<Integer>> adj, int src) {
        // code here
        Queue<Pair> queue=new LinkedList<>();
        queue.offer(new Pair(src,0));
        
        int n=adj.size();
        int[] ans=new int[n];
        Arrays.fill(ans,Integer.MAX_VALUE);
        ans[src]=0;
        
        while(!queue.isEmpty()){
            Pair temp=queue.poll();
            int dist=temp.dist;
            int node=temp.node;
            // ans[node]=dist;
            int newDist=dist+1;
            for(int adjNode:adj.get(node)){
                if(ans[adjNode]>= newDist) {
                    queue.offer(new Pair(adjNode,newDist));
                    ans[adjNode]=newDist;
                }    
            }
            
        }
        for(int i=0;i<n;i++){
            if(ans[i]==Integer.MAX_VALUE) ans[i]=-1;
        }
        return ans;
    }
}
