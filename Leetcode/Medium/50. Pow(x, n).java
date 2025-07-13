class Solution {
    public double power(double x,long n){
        if(n==0) return 1;
        double half=power(x,n/2);
        if(n%2==0) return half*half;
        else return half*half*x;
    }
    public double myPow(double x, int n) {
        long nn=n;
        nn=Math.abs(nn);
        double ans=power(x,nn);
        if(n<0) return 1/ans;
        return ans;
        
    }
}
