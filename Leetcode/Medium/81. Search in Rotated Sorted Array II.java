class Solution {
    public boolean search(int[] nums, int target) {
        int low=0;
        int high=nums.length-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(nums[mid]==target) return true;
            if(nums[low]==nums[mid] && nums[mid]==nums[high]){  //this line shrinks the search space
            // because if the duplicates exisits in all of these
                low++;
                high--;
                continue;
            }
            if(nums[low]<=nums[mid]){ //check left half is sorted 
                if(nums[low]<=target && target<=nums[mid]) high=mid-1; //checks target is b/w low,mid
                else low=mid+1;
            }
            else{
                if(nums[mid]<=target && target<=nums[high]) low=mid+1;
                else high=mid-1;
            }
        }
        return false;
        
    }
}
