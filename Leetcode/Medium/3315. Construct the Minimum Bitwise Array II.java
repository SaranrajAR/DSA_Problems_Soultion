class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n=nums.size();
        int[] res=new int[n];
        for(int i=0;i<n;i++){
            int num=nums.get(i);
            if(num%2==0) res[i]=-1;
            else{
                int curr=(int) 1e9;
                for(int j=0;j<31;j++){
                    int c=((num) & ~(1<<j));
                    if(num== (c | (c+1))){
                        curr=Math.min(curr,c);
                    }
                }
                res[i]=curr;
            }
        }
        return res;
    }
}
