class Solution {
    public int gcd(int a,int b){
        if(b==0) return a;
        return gcd(b,a%b);
    }
    public int gcdOfOddEvenSums(int n) {
        int n1=n*n;
        int n2=n*(n+1);
        return gcd(n1,n2);
    }
}
