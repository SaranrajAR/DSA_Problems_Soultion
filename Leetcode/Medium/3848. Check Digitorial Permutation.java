class Solution {
    public boolean isDigitorialPermutation(int n) {
        int copy=n;
        int[] fact=new int[10];
        fact[0]=1;
        for(int i=1;i<10;i++){
            fact[i]=fact[i-1]*i;
        }
        int[] freq=new int[10];
        int sum=0;
        while(n>0){
            int temp=n%10;
            freq[temp]++;
            sum+=fact[temp];
            n/=10;
        }
        n=sum;
        while(n>0){
            int temp=n%10;
            freq[temp]--;
            n/=10;
        }
        for(int i=0;i<10;i++) if(freq[i]!=0) return false;
        
        return true;
        
    }
}
