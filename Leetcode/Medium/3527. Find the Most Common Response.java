class Solution {
    public String findCommonResponse(List<List<String>> responses) {
        Map<String,Integer> map=new HashMap<>();
        for(int i=0;i<responses.size();i++){
            Set<String> set=new HashSet<>();
            for(int j=0;j<responses.get(i).size();j++){
                set.add(responses.get(i).get(j));
            }
            for(String item:set){
                map.put(item,map.getOrDefault(item,0)+1);
            }
        }
        System.out.print(map);
        int max=Collections.max(map.values());
        List<String> ans=new ArrayList<>();
        for(String key:map.keySet()){
            if(map.get(key)==max) ans.add(key);
        }
        if(ans.size()==1) return ans.get(0); 
        String fAns=Collections.min(ans);
        return fAns;

        
        
    }
}
