class Solution {
    public boolean binsearch(int[] nums,int n,int target){
        int low=0;
        int high=n-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(nums[mid]==target) return true;
            else if(nums[mid]<target) low=mid+1;
            else high=mid-1;
        }
        return false;
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length;
        int n=matrix[0].length;
        boolean ans=false;
        for(int[] rows:matrix){
            ans=binsearch(rows,n,target);
            if(ans) return true;
        }
        return false;
        
    }
}
