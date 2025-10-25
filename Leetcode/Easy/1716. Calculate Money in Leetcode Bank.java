class Solution {
    public int totalMoney(int n) {
        int i=1;
        int curr=1;
        int ans=0;
        while(i<=n){
            
            for(int j=curr;j<=curr+6 && i<=n;j++){
                ans+=j;
                i++;
            }
            curr++;

        }
        return ans;
    }
}
