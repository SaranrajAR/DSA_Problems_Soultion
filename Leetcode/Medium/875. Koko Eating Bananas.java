class Solution {
    private long calc(int[] piles,int number){
        long totalhours=0;
        for(int pile:piles){
           totalhours+=(pile + number - 1) / number; //here this make time complexity better rather using ceile function
        }
        return totalhours;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int max=piles[0];
        for(int pile:piles){
            max= Math.max(max,pile);
        }
        int low=1;
        int high=max;
        int ans=0;
        while(low<=high){
            int mid=(low+high)/2;
            
            long totalhours=calc(piles,mid);
            if(totalhours<=h) {
                ans=mid;
                high=mid-1;
            }    
            else low=mid+1;
        }
        return ans;
        
    }
}
