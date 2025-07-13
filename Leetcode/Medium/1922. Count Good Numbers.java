class Solution {
    int MOD=1000000007;
    public long power(long x, long n ){ 
        // if(n==0) return 1;
        // long half=power(x,n/2);
        // if(n%2 ==0 ) return (half*half)%MOD;
        // else return (half*half*x)%MOD;

        long res=1;
        while(n>0){
            if(n%2!=0){
                res=(res*x)%MOD;
            }
            x=(x*x)%MOD;
            n/=2;
        }
        return res;
    }
    public int countGoodNumbers(long n) {
        
        long even=n/2;
        long odd=even;
        if(n%2==1) even++;
        long ans=power(5,even);
        ans=(ans*power(4,odd))%MOD;
        return (int) ans;

    }
}
