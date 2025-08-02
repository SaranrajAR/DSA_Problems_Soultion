class Solution {
    
    public int helper(String s,int idx,Set<String> set){
        if(idx==s.length()) return set.size();
        int max=0;
        for(int i=idx;i<s.length();i++){
            String temp=s.substring(idx,i+1);
            if(!set.contains(temp)){
                set.add(temp);
                max=Math.max(max,helper(s,i+1,set));
                set.remove(temp);
            }
        }
        return max;
    }
    public int maxUniqueSplit(String s) {
        
        return helper(s,0,new HashSet<>());
    }
}
