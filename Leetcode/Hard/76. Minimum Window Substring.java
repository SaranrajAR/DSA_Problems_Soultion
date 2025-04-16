class Solution {
    public String minWindow(String s, String t) {
        int minlen=Integer.MAX_VALUE;
        int l=0,r=0;
        int count=0;
        int SIndex=-1;
        int m=s.length();
        int n=t.length();
        int[] hash=new int[256];
        Arrays.fill(hash,0);
        for(int i=0;i<n;i++){
            hash[t.charAt(i)]++;
        }
        while(r<m){
            if(hash[s.charAt(r)]>0) count++;
            hash[s.charAt(r)]--;
            while(count==n){
                if(r-l+1 < minlen){
                    minlen=r-l+1;
                    SIndex=l;
                }
                hash[s.charAt(l)]++;
                if(hash[s.charAt(l)]>0) count--;
                l++;

            }
            r++;
        }
        if(SIndex==-1) return "";
        return s.substring(SIndex,SIndex+minlen);
        
    }
}
