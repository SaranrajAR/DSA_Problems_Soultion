class Solution {
    public long minCost(String s, int[] cost) {
        if(s.length()==1) return 0;
        long[] hash=new long[26];
        for(int i=0;i<cost.length;i++){
            hash[s.charAt(i)-'a']+=cost[i];
        }
        long maxCost=0;
        char maxChar='a';
        for(int i=0;i<26;i++){
            if(hash[i]>maxCost){
                maxCost=hash[i];
                maxChar=(char) ('a'+i);
            }
        }
        long res=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!=maxChar) res+=cost[i];
        }
        return res;
    }
}
