class Solution {
    public boolean canJump(int[] nums) {
        int n=nums.length;
        if(n==1) return true;
        boolean[] arr=new boolean[n];
        arr[0]=true;
        
        if(nums[0]==0) return false;
        
        
        for(int i=0;i<n;i++){
            int num=nums[i];
            
            if(arr[i]==false) return false;
            for(int j=1;j<=num && i+j<n;j++){
                arr[i+j]=true;
            }
        }
        return arr[n-1];
        
    }
}
