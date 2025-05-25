class Solution {
    private int allocate(int[] nums, int size){
        int cntnum=1;
        int last=0;
        for(int i=0;i<nums.length;i++){
            if(last+nums[i]<=size) last+=nums[i];
            else{
                cntnum++;
                last=nums[i];
            }
        }
        return cntnum;

    }
    public int splitArray(int[] nums, int k) {
        if(nums.length<k) return -1;
        int sum=0;
        int max=0;
        for(int num:nums){
            sum+=num;
            max=Math.max(max,num);
        }
        int low=max;
        int high=sum;
        int ans=0;
        while(low<=high){
            int mid=(low+high)/2;
            int allocsum=allocate(nums,mid);
            if(allocsum<=k){
                ans=mid;
                high=mid-1;

            }
            else low=mid+1;
            
        }
        // for(int i=low;i<=high;i++){
        //     int allocsum=allocate(nums,i);
        //     if(allocsum==k) return i;

        // }
        return ans;

        
    }
}
