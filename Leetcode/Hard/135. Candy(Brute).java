class Solution {
    public int candy(int[] ratings) {
        int n=ratings.length;
        int[] child=new int[n];
        Arrays.fill(child,1);
        for(int i=0;i<n;i++){
            int left=i>0?ratings[i-1]:-1;
            if(left!=-1 &&  left<ratings[i]){
                child[i]=child[i-1]+1;
            }
        }
        for(int i=n-1;i>=0;i--){
            int right=i<=n-2?ratings[i+1]:-1;
            if(right!=-1 && right<ratings[i]){
                child[i]=Math.max(child[i],child[i+1]+1);
            }
        }
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=child[i];
        }
        return sum;


        
    }
}
