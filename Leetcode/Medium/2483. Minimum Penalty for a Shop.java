class Solution {
    public int bestClosingTime(String customers) {
        int n=customers.length();
        int[] prefix=new int[n+1];
        int[] suffix=new int[n+1];
        for(int i=0;i<n;i++){
            int val=0; 
            if(customers.charAt(i)=='N') val=1;
            prefix[i+1]=prefix[i]+val;
        }
        for(int i=n-1;i>=0;i--){
            int val=0;
            if(customers.charAt(i)=='Y') val=1;
            suffix[i]=suffix[i+1]+val;
        }
        int min=Integer.MAX_VALUE;
        int resIdx=n;
        for(int i=n;i>=0;i--){
            if(prefix[i]+suffix[i]<=min){
                min=prefix[i]+suffix[i];
                resIdx=i;
            }
        }
        return resIdx;
    }
}
