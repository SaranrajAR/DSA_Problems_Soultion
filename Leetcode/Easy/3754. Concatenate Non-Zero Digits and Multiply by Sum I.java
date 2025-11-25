class Solution {
    public long sumAndMultiply(int n) {
        long sum=0;
        String s="";
        while(n>0){
            int rem=n%10;
            if(rem!=0){
                s=s+rem;
                sum+=rem;
            }
            n=n/10;

        }
        n=s.length();
        long x=0;
        for(int i=n-1;i>=0;i--){
            x+=s.charAt(i)-'0';
            x*=10;
        }
        x/=10;
        return sum*x;

    }
}
