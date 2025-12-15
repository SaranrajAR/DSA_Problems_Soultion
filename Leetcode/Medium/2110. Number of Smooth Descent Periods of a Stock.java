class Solution {
    public long getDescentPeriods(int[] prices) {
        long res=0;
        
        int n=prices.length;
        int l=0;
        for(int r=0;r<n;r++){
            if(r==0 || (prices[r-1]-prices[r])!=1) l=r;
            long len=r-l+1;
            res+=len;
        }
        return res;
    }
}
