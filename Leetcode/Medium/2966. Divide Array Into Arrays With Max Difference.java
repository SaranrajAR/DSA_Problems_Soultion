class Solution {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int n=nums.length;
        int[][] arr=new int[n/3][3];
        int idx=0;
        for(int i=0;i<n;i+=3){
            if(nums[i+2]-nums[i]<=k){
                arr[idx]=new int[]{nums[i],nums[i+1],nums[i+2]};
                idx++;
            }
            else return new int[0][0];
        }
        return arr;

        
    }
}
