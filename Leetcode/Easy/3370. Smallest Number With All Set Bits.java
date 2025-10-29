class Solution {
    public int smallestNumber(int n) {
       int ans=-1;
       System.out.print(n&1);
       while(true){
        if(((n+1) & n) ==0){
            ans=n;
            break;
        }
        n++;
       } 
       return ans;
    }
}
