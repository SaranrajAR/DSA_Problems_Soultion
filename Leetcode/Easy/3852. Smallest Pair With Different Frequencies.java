class Solution {
    public int[] minDistinctFreqPair(int[] nums) {
        int[] hash=new int[101];
        for(int num:nums){
            hash[num]++;
        }
        int[] res=new int[]{-1,-1};
        
        for(int i=1;i<=100;i++){
            if(hash[i]!=0){
                int freq1=hash[i];
                for(int j=i+1;j<=100;j++){
                    if(hash[j]!=0 && hash[j]!=freq1){
                        
                        return new int[]{i,j};
                    }
                }
            }
        }
        return res;
    }
}
