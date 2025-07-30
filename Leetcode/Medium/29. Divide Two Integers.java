class Solution {
    public int divide(int dividend, int divisor) {
        boolean sign=true;
        if(dividend<0 && divisor>0) sign=false;
        if(dividend>0 && divisor<0) sign=false;
        long ans=0;
        long n=Math.abs((long) dividend);
        long d=Math.abs((long) divisor);
        while(n>=d){
            int cnt=0;
            while(n>=(d << (cnt+1))){
                cnt++;
            }
            ans+=1L<<cnt;
            n=n-(d<<cnt);
        }
        if(ans>Integer.MAX_VALUE){
            return sign ? Integer.MAX_VALUE:Integer.MIN_VALUE;
        }
       
        return sign ? (int)ans:(int)(-ans);
    }
}
