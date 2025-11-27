class Solution {
    public int findMaxLength(int[] nums) {
        int maxLength=0;
        int n=nums.length;
        int[] prefix=new int[n+1];
        for(int i=0;i<n;i++){
            if(nums[i]==1) prefix[i+1]=prefix[i]+1;
            else prefix[i+1]=prefix[i]-1;
        }
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,0);
        for(int i=1;i<=n;i++){
            int curr=prefix[i];
            if(map.containsKey(curr)) maxLength=Math.max(maxLength,(i-map.get(curr)));
            else map.put(curr,i);
        }
        return maxLength;  
    }
}
