class Dsu{
    List<Integer> rank;
    List<Integer> parent;
    Dsu(int n){
        rank=new ArrayList<>();
        parent=new ArrayList<>();
        for(int i=0;i<n;i++){
            rank.add(0);
            parent.add(i);
        }

    }
    public int find(int node){
        if(parent.get(node)==node) return node;
        int ulp=find(parent.get(node));
        parent.set(node,ulp);
        return ulp;
    }
    public void unionByRank(int u,int v){
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
    public int removeStones(int[][] stones) {
        int maxRow=0;
        int maxCol=0;
        int n=stones.length;
        for(int[] stone:stones){
            maxRow=Math.max(maxRow,stone[0]);
            maxCol=Math.max(maxCol,stone[1]);
        }
        Dsu ds=new Dsu(maxRow+maxCol+2);
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int[] stone:stones){
            int rowNode=stone[0];
            int colNode=stone[1]+maxRow+1;
            ds.unionByRank(rowNode,colNode);
            map.put(rowNode,1);
            map.put(colNode,1);
        }
        int cnt=0;
        for(int node:map.keySet()){
            if(ds.find(node)==node) cnt++;
        }
        return n-cnt;

    }
}
