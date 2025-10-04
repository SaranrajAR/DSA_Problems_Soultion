class Solution {
    public int maxArea(int[] height) {
        int max=Integer.MIN_VALUE;
        int i=0;
        int j=height.length-1;
        while(i<j){
            if(height[i]<height[j]){
                int area=height[i]*(j-i);
                max=Math.max(max,area);
                i++;
            }
            else{
                int area=height[j]*(j-i);
                max=Math.max(max,area);
                j--;
            }
        }
        return max;
    }
}
