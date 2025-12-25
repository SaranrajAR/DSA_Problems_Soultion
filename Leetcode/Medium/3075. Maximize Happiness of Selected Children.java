class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        long res=0;
        Arrays.sort(happiness);
        int n=happiness.length;
        int minus=0;
        for(int i=n-1;i>=0 && k>0;i--,k--){
            if(happiness[i]-minus>=0) res+=happiness[i]-minus;
            
            minus++;
        }
        return res;
    }
}
