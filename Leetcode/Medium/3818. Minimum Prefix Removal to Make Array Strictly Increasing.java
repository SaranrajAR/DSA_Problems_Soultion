class Solution {
    public int minimumPrefixLength(int[] nums) {
        int n=nums.length;
        int[] nse=new int[n];
        Stack<Integer> st=new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && nums[st.peek()]>nums[i]) st.pop();
            if(st.isEmpty()){
                nse[i]=-1;
            }
            else{
                nse[i]=st.peek();
                break;
            }
            st.push(i);
        }
        
        int res=0;
        for(int i=n-1;i>=0;i--){
            if(nse[i]!=-1) return nums.length-res;
            res++;
        }
        return nums.length-res;
    }
}
