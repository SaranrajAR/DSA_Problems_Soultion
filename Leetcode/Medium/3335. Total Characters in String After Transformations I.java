class Solution {
    public int lengthAfterTransformations(String s, int t) {
        int[] freq=new int[26];
        for(int i=0;i<s.length();i++){
            freq[s.charAt(i)-'a']++;
        }
        for(int i=0;i<t;i++){
            int[] tempfreq=new int[26];
            for(int j=0;j<26;j++){
                if(j<25){
                    tempfreq[j+1]=freq[j]%1000000007;
                }
                else{
                    tempfreq[0]+=freq[j]%1000000007;
                    tempfreq[1]+=freq[j]%1000000007;
                }
            }
            freq=tempfreq;

        }
        long ans=0;
        for(int i=0;i<26;i++){
            ans=(ans+freq[i])%1000000007;
        }
        return (int)(ans);
    }
}
