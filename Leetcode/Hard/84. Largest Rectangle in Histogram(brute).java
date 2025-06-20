class Solution {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        int[] pse=new int[n];
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && heights[stack.peek()]>heights[i]) stack.pop();
            if(stack.isEmpty()) pse[i]=-1;
            else pse[i]=stack.peek();
            stack.push(i);
        }
        stack=new Stack<>();
        int[] nse=new int[n];
        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && heights[stack.peek()]>=heights[i]) stack.pop();
            if(stack.isEmpty()) nse[i]=n;
            else nse[i]=stack.peek();
            stack.push(i);
        }
        int max=0;
        for(int i=0;i<n;i++){
            max=Math.max(max,heights[i]*(nse[i]-pse[i]-1));
        }
        return max;
        
    }
}
