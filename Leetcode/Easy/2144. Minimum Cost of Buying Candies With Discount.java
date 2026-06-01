class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int i=cost.length-1;
        int res=0;
        while(i>=0){
            res+=cost[i];
            i--;
            if(i>=0) {
                res+=cost[i];
                i--;
            }
            if(i>=0) i--;    
        }
        return res;
    }
}
