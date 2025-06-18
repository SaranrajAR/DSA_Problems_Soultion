class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n=arr.length;
        int[] nse=new int[n];
        Stack<Integer> stack=new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && arr[stack.peek()]>arr[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                nse[i]=n;
            }
            else nse[i]=stack.peek();
            stack.push(i);
        }
        stack=new Stack<>();
        int[] psee=new int[n];
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && arr[stack.peek()]>=arr[i]) stack.pop();

            if(stack.isEmpty()) psee[i]=-1;
            else psee[i]=stack.peek();
            stack.push(i);
        }
        long total=0;
        int mod=(int) 1e9+7;
        for(int i=0;i<n;i++){
            int left=i-psee[i];
            int right=nse[i]-i;
            total=(total+(((long)left*right)%mod*arr[i])%mod)%mod;
        }
        return (int)total;
        
        
    }
}
