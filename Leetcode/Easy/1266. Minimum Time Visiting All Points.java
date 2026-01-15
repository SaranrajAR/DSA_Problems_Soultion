class Solution {
    public int func(int[][] points,int st,int end){
        int x=Math.abs(points[st][0]-points[end][0]);
        int y=Math.abs(points[st][1]-points[end][1]);
        return Math.max(x,y);
    }
    public int minTimeToVisitAllPoints(int[][] points) {
        int res=0;
        for(int i=0;i<points.length-1;i++){
            res+=func(points,i,i+1);
        }
        return res;
    }
}
