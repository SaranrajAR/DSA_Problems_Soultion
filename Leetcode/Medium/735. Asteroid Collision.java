class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<asteroids.length;i++){
            if(asteroids[i]>0) stack.push(asteroids[i]);
            else{
                while(!stack.isEmpty() && stack.peek()>0 && stack.peek()<Math.abs(asteroids[i])){
                    stack.pop();
                }    
                if(stack.isEmpty() || stack.peek()<0) stack.push(asteroids[i]);
                else if(!stack.isEmpty() && Math.abs(asteroids[i])==stack.peek()){
                    stack.pop();
                } 
            }
        }
        int n=stack.size();
        int[] ans=new int[n];
        int idx=n-1;
        for(int i=0;i<n;i++){
            ans[idx]=stack.pop();
            idx--;
        }
        return ans;
        
    }
}
