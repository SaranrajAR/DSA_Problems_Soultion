class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        int mod=(int) (1e9+7);
        for(int[] query:queries){
            int idx=query[0];
            int n=query[1];
            int k=query[2];
            int v=query[3];
            for(int i=idx;i<=n;i+=k){
                nums[i]=(int) (((long) nums[i]*((long) v))%mod);
            }
        }
        int ans=0;
        for(int num:nums) ans^=num;
        return ans;
    }
}
