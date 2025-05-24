class Solution {
    public int myAtoi(String s) {
        int n=s.length();
        if(n==0) return 0;
        int i=0;
        while(i<n && s.charAt(i)==' '){
            i++;
        }
        if(i==n) return 0;
        s=s.substring(i); // i------->last;
        int sign=1;
        long ans=0;
        if(s.charAt(0)=='-') sign=-1;
        int MAX=Integer.MAX_VALUE;
        int MIN=Integer.MIN_VALUE;
        i=0;
        if((s.charAt(0)=='-') || (s.charAt(0)=='+')) i=1;
        while(i<s.length()){
            if(!Character.isDigit(s.charAt(i))) break;
            ans=(ans*10) + s.charAt(i)-'0';
            if(sign==-1 && ((ans*-1) < MIN  )) return MIN;
            if(sign==1 && (ans>MAX)) return MAX;
            i++;
        }
        return (int) ans*sign;

    }
}
