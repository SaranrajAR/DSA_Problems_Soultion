class Solution {
    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        long res=0;
        int n = bottomLeft.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int x1=bottomLeft[i][0];
                int y1=bottomLeft[i][1];
                
                int x2=topRight[i][0];
                int y2=topRight[i][1];

                int x3=bottomLeft[j][0];
                int y3=bottomLeft[j][1];

                int x4=topRight[j][0];
                int y4=topRight[j][1];

                int side1=Math.min(x4,x2)-Math.max(x1,x3);
                int side2=Math.min(y4,y2)-Math.max(y1,y3);

                if(side1>0 && side2>0){
                    res=Math.max(res,Math.min(side1,side2));
                }
            }

        }
        return res*res;
    }
}
