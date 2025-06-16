class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack=new Stack<>();
        int n=nums.length;
        int[] ans=new int[n];
        for(int i=(2*n)-1;i>=n;i--){ //precomputing nge from  last element ---> 
            while(!stack.isEmpty() && stack.peek()<=nums[i%n]){
                stack.pop();
            }
            stack.push(nums[i%n]);
            
        }
        for(int i=n-1;i>=0;i--){ 
            while(!stack.isEmpty() && stack.peek()<=nums[i]){
                stack.pop();
            }
            ans[i]=!stack.isEmpty()?stack.peek():-1;
            stack.push(nums[i]);
        }
        return ans;
        
    }
}
