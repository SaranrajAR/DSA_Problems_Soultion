class Solution {
    public int lowerBound(int[] nums,int low,int val){
        int high=nums.length-1;
        int idx=-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(nums[mid]>=val) {
                low=mid+1;
                idx=mid;
            }    
            else high=mid-1;
        }
        return idx;
    }
    public int maxDistance(int[] nums1, int[] nums2) {
        int maxDistance=0;
        int n1=nums1.length;
        int n2=nums2.length;
        for(int i=0;i<n1;i++){
            int j=lowerBound(nums2,i,nums1[i]);
            maxDistance=Math.max((j-i),maxDistance);
        }
        return maxDistance;
    }
}
