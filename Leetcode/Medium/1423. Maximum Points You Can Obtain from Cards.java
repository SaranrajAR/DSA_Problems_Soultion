class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int sum=0;
        int n=cardPoints.length;
        for(int i=0;i<k;i++){
            sum+=cardPoints[i];
        }
        int max=sum;
        int j=k-1;
        
        for(int i=n-1;i>=n-k;i--){
            sum-=cardPoints[j];
            j--;
            sum+=cardPoints[i];
            max=Math.max(sum,max);


        }
        
        return max;
        
    }
}
