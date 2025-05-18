class Solution {
    public boolean checkleastweightfunc(int[] weights,int days,int day){
        int currentdays = 1; //First day.
        int load = 0;
        for(int weight:weights){
            if((load+weight)>day){
                load=weight;
                currentdays++;
            }
            else{
                load+=weight;
            }
        }
        if(currentdays>days) return false;
        return true;
    }
    public int shipWithinDays(int[] weights, int days) {
        int max=0;
        int sum=0;
        for(int weight:weights){
            max=Math.max(max,weight);
            sum+=weight;
        }
        int low=max;
        int high=sum;
        int ans=0;
        while(low<=high){
            int mid=(low+high)/2;
            boolean checkleastweight=checkleastweightfunc(weights,days,mid);
            if(checkleastweight){
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
