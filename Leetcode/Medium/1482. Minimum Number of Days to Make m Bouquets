class Solution {
    public boolean checkpossibleornot(int[] bloomDay,int day,int m,int k){
        int count=0;
        int totalpossible=0;
        for(int bloom:bloomDay){
            if(bloom<=day){
                count++;
            }
            else{
                totalpossible+=(count/k);
                count=0;
            }
        }
        totalpossible+=(count/k);
        if(totalpossible>=m) return true;
        return false;

    }
    public int minDays(int[] bloomDay, int m, int k) {
        int max=bloomDay[0];
        int min=bloomDay[0];
        for(int bloom:bloomDay){
            min=Math.min(bloom,min);
            max=Math.max(bloom,max);
        }
        int low=min;
        int high=max;
        int ans=-1;
        if(bloomDay.length<(m*k)) return -1;
        while(low<=high){
            int mid=(low+high)/2;
            boolean checkpossible=checkpossibleornot(bloomDay,mid,m,k);
            if(checkpossible){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }

            
        }
        return ans;

        
    }
}
