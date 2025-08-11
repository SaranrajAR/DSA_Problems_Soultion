class Solution {
    public int[] productQueries(int n, int[][] queries) {
        List<Integer> powers=new ArrayList<>();
        int MOD=1_000_000_007;
        while(n>0){
        // int temp=(int) Math.floor(Math.log(n)/Math.log(2)); //gets max 2 power of val <= n 
             //if any doubt watch  StatLearn Tech channel
            // temp=1<<temp; 
            int temp = Integer.highestOneBit(n); // safer than log
            powers.add(temp);
            n=n-temp;
        }
        Collections.sort(powers);
        int[] ans=new int[queries.length];
        int idx=0;
        for(int[] arr:queries){
            int l=arr[0];
            int r=arr[1];
            long prod=1;
            for(int i=l;i<=r;i++){
                prod=(prod*powers.get(i)) %MOD;
            }
            ans[idx++]=(int) prod;
        }
        return ans;
    }
}
