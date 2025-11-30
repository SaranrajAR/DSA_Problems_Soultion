class Solution {
    public int reverse(int num){
        StringBuilder sb=new StringBuilder(Integer.toString(num));
        String s=sb.reverse().toString();
        int i=0;
        while(s.charAt(i)=='0') i++;
        s=s.substring(i,s.length());
        return Integer.parseInt(s);

    }
    public int minMirrorPairDistance(int[] nums) {
        int ans=Integer.MAX_VALUE;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])) ans=Math.min(ans,i-map.get(nums[i]));
            int rev=reverse(nums[i]);
            map.put(rev,i);
        }
        return ans==Integer.MAX_VALUE?-1:ans;
    }
}
