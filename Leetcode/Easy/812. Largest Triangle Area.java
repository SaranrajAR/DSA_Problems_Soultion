class Solution {
    public double compute(int x1,int y1,int x2,int y2,int x3,int y3){
        double ans=(double) 0.5* (double) Math.abs(x1*(y2-y3)+x2*(y3-y1)+x3*(y1-y2));
        return ans;
    }
    public double largestTriangleArea(int[][] points) {
        int n=points.length;
        double maxArea=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                for(int k=j+1;k<n;k++){
                    double currArea=compute(points[i][0],points[i][1],points[j][0],points[j][1],points[k][0],points[k][1]);
                    maxArea=Math.max(currArea,maxArea);
                }
            }
        }
        return maxArea;
    }
}
