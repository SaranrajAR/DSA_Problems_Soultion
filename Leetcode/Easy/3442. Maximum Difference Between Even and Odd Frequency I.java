class Solution {
    public int maxDifference(String s) {
        int[] hash=new int[26];
        for(int i=0;i<s.length();i++){
            hash[s.charAt(i)-'a']++;
        }
        int max=0;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<26;i++){
            if(hash[i]==0) continue;
            if(hash[i]%2==0 && hash[i]<min){
                min=hash[i];
            }
            else if(hash[i]%2!=0 && hash[i]>max){
                max=hash[i];
            }
        }
        return max-min;
        
    }
}
