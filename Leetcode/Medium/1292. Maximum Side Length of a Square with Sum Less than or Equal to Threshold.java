class Solution {
    public boolean helper(int[][] mat,int row,int col,int k,int thres){
        int sum=0;
        for(int i=row;i<row+k;i++){
            for(int j=col;j<col+k;j++){
                sum+=mat[i][j];
                if(sum>thres) return false;
            }
        }
        
        return true;
    }
    public int maxSideLength(int[][] mat, int threshold) {
        int m=mat.length;
        int n=mat[0].length;
        int sqSize=Math.min(m,n);
        int low=0;
        int high=sqSize;
        int res=0;
        while(low<=high){
            int mid=(low+high)/2;
            int k=mid;
            boolean isTrue=false;
            for(int i=0;i<=m-k;i++){
                for(int j=0;j<=n-k;j++){
                    isTrue=helper(mat,i,j,k,threshold);

                    if(isTrue) {
                        res=Math.max(res,k);
                        break;
                    }    
                }
                if(isTrue) break;
            }
            if(isTrue) low=mid+1;
            else high=mid-1;
        
        }
        return res;

    }
}
