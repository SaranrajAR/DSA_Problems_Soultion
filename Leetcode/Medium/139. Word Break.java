class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n=s.length();
        HashSet<String> set=new HashSet<>();
        int maxlen=wordDict.get(0).length();
        for(String word:wordDict){
            set.add(word);
            maxlen=Math.max(maxlen,word.length());
        }

        boolean dp[]=new boolean[n+1];
        dp[0]=true;

        for(int i=1;i<=n;i++){
            for(int j=i-1;j>=Math.max(0,i-maxlen);j--){
                if(dp[j] && set.contains(s.substring(j,i))) {
                    dp[i]=true;
                    break;
                }
           }
        }
        return dp[n];
    }
}
