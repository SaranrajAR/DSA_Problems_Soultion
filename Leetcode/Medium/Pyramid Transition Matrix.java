class Solution {
    public boolean helper(int idx,String curr,String bottom, HashMap<String,List<Character>> map, HashMap<String,Boolean> memo){
        if(curr.length()==1) return true;
        if(idx==curr.length()-1){
            if(memo.containsKey(bottom)) return memo.get(bottom);
            boolean res=helper(0,bottom,"",map,memo);
            memo.put(bottom,res);
            return res;
        }
        String temp=curr.substring(idx,idx+2);
        if(!map.containsKey(temp)) return false;
        for(char ch:map.get(temp)){
            if(helper(idx+1,curr,bottom+ch,map,memo)) return true;
        }
        return false;
    }
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        HashMap<String,List<Character>> map=new HashMap<>();
        HashMap<String,Boolean> memo=new HashMap<>();
        for(String s:allowed){
            map.putIfAbsent(s.substring(0,2),new ArrayList<>());
            map.get(s.substring(0,2)).add(s.charAt(2));
        }
        return helper(0,bottom,"",map,memo);
    }
}
