// User function Template for Java
class Pair{
    int node;
    int dist;
    Pair(int node,int dist){
        this.node=node;
        this.dist=dist;
    }
}
class Solution {
    int minimumMultiplications(int[] arr, int start, int end) {

        // Your code here
        if(start==end) return 0;
        int[] dist=new int[100000];
        Arrays.fill(dist,Integer.MAX_VALUE);
        Queue<Pair> queue=new LinkedList<>();
        queue.offer(new Pair(start,0));
        int MOD=100000;
        dist[start]=0;
        while(!queue.isEmpty()){
            Pair temp=queue.poll();
            int currDist=temp.dist;
            int node=temp.node;
            for(int x:arr){
                int adjNode=(node*x)%MOD;
                if(currDist+1 < dist[adjNode]){
                    if(adjNode==end) return currDist+1;
                    dist[adjNode]=currDist+1;
                    queue.offer(new Pair(adjNode,currDist+1));
                    
                }
            }
        }
        return -1;
        
    }
}
