class Solution {
    public int helper(int[][] grid,int i,int j,int m,int n){
        Set<Integer> set=new HashSet<>();
        int rowSum1=0;
        int rowSum2=0;
        int rowSum3=0;
        int colSum1=0;
        int colSum2=0;
        int colSum3=0;
        int dia1=0;
        int dia2=0;
        for(int row=i;row<=i+2;row++){
            for(int col=j;col<=j+2;col++){
                if(set.contains(grid[row][col]) || grid[row][col]<=0 || grid[row][col]>9) return 0;
                set.add(grid[row][col]);
            }
        }
        rowSum1+=grid[i][j]+grid[i][j+1]+grid[i][j+2];
        rowSum2+=grid[i+1][j]+grid[i+1][j+1]+grid[i+1][j+2];
        rowSum3+=grid[i+2][j]+grid[i+2][j+1]+grid[i+2][j+2];
        
        colSum1=grid[i][j]+grid[i+1][j]+grid[i+2][j];
        colSum2=grid[i][j+1]+grid[i+1][j+1]+grid[i+2][j+1];
        colSum3=grid[i][j+2]+grid[i+1][j+2]+grid[i+2][j+2];
        

        dia1+=grid[i][j]+grid[i+1][j+1]+grid[i+2][j+2];
        dia2=grid[i][j+2]+grid[i+1][j+1]+grid[i+2][j];

        if(rowSum1 == rowSum2 && rowSum3==rowSum1 && colSum1==rowSum1 && colSum2==rowSum1 && colSum3==rowSum1 && dia1==rowSum1 && dia2==rowSum1) return 1;

        return 0;
    }
    public int numMagicSquaresInside(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int res=0;
        for(int i=0;i<=m-3;i++){
            for(int j=0;j<=n-3;j++){
                res+=helper(grid,i,j,m,n);
            }
        }
        return res;
    }
}
