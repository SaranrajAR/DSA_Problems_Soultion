class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        int[] dp=new int[n];
        int[] hash=new int[n]; // track the changes by storing its index
        Arrays.fill(dp,1);
        for(int i=0;i<n;i++) hash[i]=i;
        for(int i=1;i<n;i++){
            int curr=nums[i];
            for(int j=0;j<i;j++){
                int prev=nums[j];
                if(curr%prev == 0 && dp[i]<(1+dp[j])){
                    dp[i]=1+dp[j];
                    hash[i]=j;
                }
            }
        }
        int max=1;
        int maxIdx=-1;
        for(int i=0;i<n;i++){
            int num=dp[i];
            if(max<=num){
                max=num;
                maxIdx=i;
            }
        }
        List<Integer> res=new ArrayList<>();
        int i=maxIdx;
        res.add(nums[i]);
        while(dp[i]!=1){
            i=hash[i];
            res.add(nums[i]);
        }
        return res;
    }
}
