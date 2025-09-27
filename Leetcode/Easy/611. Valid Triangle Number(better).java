class Solution {
    public int bSearch(int sum,int low,int high,int[] nums){
        int start=low;
        while(low<=high){
            int mid=(low+high)/2;
            if(nums[mid]>=sum) high=mid-1;
            else low=mid+1;
        }
        return low-start;

    }
    public int triangleNumber(int[] nums) {
        int ans=0;
        int n=nums.length;
        Arrays.sort(nums);
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int sum=nums[i]+nums[j];
                ans+=bSearch(sum,j+1,n-1,nums);
            }
        }
        return ans;
    }
}
