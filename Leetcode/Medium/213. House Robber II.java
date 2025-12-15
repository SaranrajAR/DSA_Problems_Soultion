class Solution {
    public int helper(int[] nums){
        int n=nums.length;
        int prev1=nums[0];
        int prev2=0;
        for(int i=1;i<n;i++){
            int curri=0;

            int notPick=prev1;
            int Pick=nums[i];
            if(i>1) Pick+=prev2;
            curri=Math.max(Pick,notPick);
            prev2=prev1;
            prev1=curri;
            
        }
        return prev1;
    }
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1) return nums[0];
        int[] temp1=new int[n-1];
        int[] temp2=new int[n-1];
        for(int i=0;i<n-1;i++){
            temp1[i]=nums[i];
            temp2[i]=nums[i+1];
        }

        return Math.max(helper(temp1),helper(temp2));
    }
}
