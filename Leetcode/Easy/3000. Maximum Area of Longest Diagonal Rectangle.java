class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        double  maxDiagnol=0;
        int maxArea=0;
        for(int []dim:dimensions){
            int l=dim[0];
            int w=dim[1];
            int currArea=l*w;
            l=l*l;
            w=w*w;
            double  currDiagnol=l+w;
            
            
            currDiagnol= Math.sqrt((double) currDiagnol);
            if(currDiagnol> maxDiagnol){
                maxDiagnol=currDiagnol;
                maxArea=currArea;
            }
            else if(currDiagnol == maxDiagnol && currArea>maxArea){
                maxDiagnol=currDiagnol;
                maxArea=currArea;
            }
            
        }
        return maxArea;
    }
}
