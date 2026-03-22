class Solution {
    public int[][] rotate(int[][] mat,int n){
        int[][] temp=new int[n][n];
        int col=n;
        
        for(int i=0;i<n;i++){
            col--;
            int row=0;
            for(int j=0;j<n;j++){
                temp[row++][col]=mat[i][j];
            }
        }
        return temp;
        
    }
    public boolean checkEqual(int[][] mat,int[][] target,int n){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]!=target[i][j]) return false;
            }
        }
        return true;
    }
    public boolean findRotation(int[][] mat, int[][] target) {
        int n=mat.length;
        if(checkEqual(mat,target,n)) return true;
        for(int i=0;i<3;i++){
            mat=rotate(mat,n);
            if(checkEqual(mat,target,n)) return true;
        }
        return false;
    }
}
