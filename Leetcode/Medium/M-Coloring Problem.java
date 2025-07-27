class Solution {
    boolean isSafe(int node,int[][] edges,int colour,int[] colours){
        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];
            
            if(u==node && colours[v]==colour) return false;
            if(v==node && colours[u]==colour) return false;
        }
        return true;
    }
    boolean helper(int node,int[][] edges,int v,int m,int[] colours){
        if(node==v) return true;
        for(int colour=1;colour<=m;colour++){
            if(isSafe(node,edges,colour,colours)){
                colours[node]=colour;
                if(helper(node+1,edges,v,m,colours)) return true;
                colours[node]=0;
            }
        }
        return false;
    }
    boolean graphColoring(int v, int[][] edges, int m) {
        // code here
        int[] colours=new int[v];
        return helper(0,edges,v,m,colours);
    }
}
