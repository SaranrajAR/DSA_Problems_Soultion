class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack=new Stack<>();
        int max=0;
        int n=heights.length;
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && heights[stack.peek()]>heights[i]){
                int element=stack.pop();
                int nse=i;
                int pse=stack.isEmpty()?-1:stack.peek();
                max=Math.max(max,heights[element]*(nse-pse-1));
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            int element=stack.pop();
            int pse=stack.isEmpty()?-1:stack.peek();
            int nse=n;
            max=Math.max(max,heights[element]*(nse-pse-1));
        }
        return max;
        
    }
}
