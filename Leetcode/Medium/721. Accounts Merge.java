class Dsu{
    List<Integer> parent;
    List<Integer> rank;
    Dsu(int n){
        parent=new ArrayList<>();
        rank=new ArrayList<>();
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
            int rankU=rank.get(ulp_u);
            parent.set(ulp_v,ulp_u);
            rank.set(ulp_u,rankU+1);
        }
    }
}
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        HashMap<String,Integer> map=new HashMap<>();
        
        int n=accounts.size();
        Dsu ds=new Dsu(n);
        for(int i=0;i<n;i++){
            List<String> email=accounts.get(i);
            for(int j=1;j<email.size();j++){
                if(!map.containsKey(email.get(j))){
                    map.put(email.get(j),i);
                }
                else{
                    int u=ds.find(map.get(email.get(j)));
                    int v=i;
                    ds.union(u,v);
                }
                
                
            }
        }
        // System.out.print(map);
        List<List<String>> ans =new ArrayList<>();
        List<List<String>> merged=new ArrayList<>();
        for(int i=0;i<n;i++){
            merged.add(new ArrayList<>());
        }
        for(String key:map.keySet()){
            int u=ds.find(map.get(key));
            merged.get(u).add(key);
        }
        for(int i=0;i<n;i++){
            if(merged.get(i).size()==0) continue;
            Collections.sort(merged.get(i));
            List<String> temp=new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            for(String curr:merged.get(i)){
                temp.add(curr);
            }
            ans.add(temp);
        }
        return ans;
    }
}
