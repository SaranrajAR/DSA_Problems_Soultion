class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map=new HashMap<>();
        for(String s:strs){
            char[] temp=s.toCharArray();
            Arrays.sort(temp);
            String curr=new String(temp);
            if(!map.containsKey(curr)) map.put(curr,new ArrayList<>());
            map.get(curr).add(s);
                
            
        }
        List<List<String>> ans=new ArrayList<>();
        if(strs.length==0){
            return ans;
        }
        for(List<String> val:map.values()){
            ans.add(val);
        }
        return ans;
       

    
    }
}
