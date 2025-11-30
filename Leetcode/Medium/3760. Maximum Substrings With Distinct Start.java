class Solution {
    public int maxDistinct(String s) {
        int[] hash=new int[26];
        for(char ch:s.toCharArray()){
            hash[ch-'a']++;
        }
        int ans=0;
        for(int i:hash){
            if(i!=0) ans++;
        }
        return ans;
    }
}
