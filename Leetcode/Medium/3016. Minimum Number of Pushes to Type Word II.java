class Solution {
    public int minimumPushes(String word) {
        int res=0;
        int[] hash=new int[26];
        for(char ch:word.toCharArray()){
            hash[ch-'a']++;
        }
        Arrays.sort(hash);
        int j=0;
        for(int i=25;i>=0;i--){
            if(hash[i]<=0) break;
            else{
                int num=1;
                num+=j/8;
                res+=hash[i]*num; 
            }
            j++;
        }
        return res;
    }
}
