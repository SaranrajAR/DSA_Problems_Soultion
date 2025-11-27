class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> ans=new ArrayList<>();
        int rem=0;
        for(int num:nums){
            rem=rem*2;
            rem+=num;
            rem%=5;
            ans.add(rem==0);
        }
        return ans;
    }
}
