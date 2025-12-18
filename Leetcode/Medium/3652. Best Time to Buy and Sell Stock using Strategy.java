class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        long profit=0;
        int n=prices.length;
        long[] prefix=new long[n];
        
        for(int i=0;i<n;i++){
            profit+=(strategy[i]*prices[i]);
            prefix[i]= profit;
        }
        int halfPtr=k/2;
        long delta=0;
        for(int i=k/2;i<k;i++){
            delta+=prices[i];
        }
        long currProfit=delta+(prefix[n-1]-prefix[k-1]);
        profit=Math.max(profit,currProfit);
        for(int i=k;i<n;i++){
            delta-=prices[halfPtr];
            halfPtr++;
            delta+=prices[i];
            currProfit=delta+(prefix[n-1]-prefix[i]);
            currProfit+=prefix[i-k];
            profit=Math.max(currProfit,profit);
        }
        return profit;
    }
}
