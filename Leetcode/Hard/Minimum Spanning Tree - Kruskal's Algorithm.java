// User function Template for Java
class disSet{
    public List<Integer> rank;
    public List<Integer> parent;
    public disSet(int n){
        rank=new ArrayList<>();
        parent=new ArrayList<>();
        for(int i=0;i<n;i++){
            rank.add(0);
            parent.add(i);
        }
    }
    
    public int find(int node){
        if(node==parent.get(node)) return node;
        int ulp=find(parent.get(node));
        parent.set(node,ulp);
        return ulp;
    }
    
    public void union(int u,int v){
        int ulp_u=find(u);
        int ulp_v=find(v);
        if(ulp_u==ulp_v) return;
        if(rank.get(ulp_u)<rank.get(ulp_v)){
            parent.set(ulp_u,ulp_v);
        }
        else if(rank.get(ulp_u)>rank.get(ulp_v)){
            parent.set(ulp_v,ulp_u);
        }
        else{
            parent.set(ulp_v,ulp_u);
            int rankU=rank.get(ulp_u);
            rank.set(ulp_u,rankU+1);
            
            
        }
    }
    
}
class Solution {
    static int kruskalsMST(int V, int[][] edges) {
        // code here
        Arrays.sort(edges,(a,b)->a[2]-b[2]);
        disSet ds=new disSet(V);
        int ans=0;
        for(int[] edge:edges){
            int weight=edge[2];
            int u=edge[0];
            int v=edge[1];
            if(ds.find(u)!=ds.find(v)){
                ans+=weight;
                ds.union(u,v);
            }
        }
        return ans;
    }
}
