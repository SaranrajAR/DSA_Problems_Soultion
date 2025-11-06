class Dsu{
    List<Integer> parent;
    List<Integer> rank;
    Dsu(int n){
        this.parent=new ArrayList<>();
        this.rank=new ArrayList<>();
        for(int i=0;i<n;i++){
            parent.add(i);
            rank.add(0);
        }
    }
    public int find(int node){
        if(parent.get(node)==node) return node;
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
        else if(rank.get(ulp_v)<rank.get(ulp_u)){
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
    public int makeConnected(int n, int[][] connections) {
        Dsu ds=new Dsu(n);
        int extras=0;
        for(int[] edge:connections){
            int u=edge[0];
            int v=edge[1];
            int ulp_u=ds.find(u);
            int ulp_v=ds.find(v);
            if(ulp_u==ulp_v) extras++;
            else ds.union(u,v);
        }
        int cntC=0;
        for(int i=0;i<n;i++){
            if(ds.parent.get(i)==i) cntC++;
        }
        int ans=cntC-1;
        if(extras>=ans) return ans;
        return -1;
    }
}
